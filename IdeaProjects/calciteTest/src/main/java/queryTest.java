import org.apache.calcite.adapter.jdbc.JdbcSchema;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.plan.Contexts;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.JoinRelType;
import org.apache.calcite.rel.core.RelFactories;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.tools.*;

import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.plan.RelTraitDef;
import org.apache.calcite.prepare.Prepare;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.JoinRelType;
import org.apache.calcite.runtime.Hook;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Program;
import org.apache.calcite.tools.Programs;
import org.apache.calcite.tools.RelBuilder;
import org.apache.calcite.util.Bug;
import org.apache.calcite.util.Holder;
import org.apache.calcite.util.Pair;

import com.google.common.base.Function;


import java.util.List;
import java.util.Random;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;



public class queryTest {

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:calcite:");

        CalciteConnection calciteConnection = conn.unwrap(org.apache.calcite.jdbc.CalciteConnection.class);

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("jdbcUrl", "jdbc:postgresql://localhost:5432/tpcds");
        props.put("jdbcUser", "pguser");
        props.put("jdbcPassword", "test");
        props.put("jdbcSchema", "postgrestest");

        SchemaPlus rootSchema = calciteConnection.getRootSchema();
        JdbcSchema schema = JdbcSchema.create(rootSchema, "postgrestest", props);
        rootSchema.add("postgrestest", schema);

        FrameworkConfig frameworkConfig = Frameworks.newConfigBuilder()
                .parserConfig(SqlParser.Config.DEFAULT)
                .defaultSchema(rootSchema)
                .traitDefs((List<RelTraitDef>) null)
                .programs(Programs.heuristicJoinOrder(Programs.RULE_SET, true, 2)).build();


        RelBuilder builder = RelBuilder.create(frameworkConfig);
        RelNode root =
                builder.scan("store_sales")
                        .scan("CUSTOMER_DEMOGRAPHICS")
                        .scan("DATE_DIM")
                        .scan("postgrestest","STORE")
                        .scan("postgrestest","ITEM")
                        .join(JoinRelType.INNER)
                        .join(JoinRelType.INNER)
                        .join(JoinRelType.INNER)
                        .join(JoinRelType.INNER)
                        .filter(
                                builder.equals(builder.field("SS_SOLD_DATE_SK"), builder.field("D_DATE_SK")),
                                builder.equals(builder.field("SS_ITEM_SK"), builder.field("I_ITEM_SK")),
                                builder.equals(builder.field("SS_STORE_SK"), builder.field("S_STORE_SK")),
                                builder.equals(builder.field("SS_CDEMO_SK"), builder.field("CD_DEMO_SK")),
                                builder.equals(builder.field("CD_GENDER"), builder.literal("M")),
                                builder.equals(builder.field("CD_MARITAL_STATUS"), builder.literal("S")),
                                builder.equals(builder.field("CD_EDUCATION_STATUS"),
                                        builder.literal("HIGH SCHOOL")),
                                builder.equals(builder.field("D_YEAR"), builder.literal(1998)),
                                builder.call(SqlStdOperatorTable.IN,
                                        builder.field("S_STATE"),
                                        builder.call(SqlStdOperatorTable.ARRAY_VALUE_CONSTRUCTOR,
                                                builder.literal("CA"),
                                                builder.literal("OR"),
                                                builder.literal("WA"),
                                                builder.literal("TX"),
                                                builder.literal("OK"),
                                                builder.literal("MD"))))
                        .aggregate(builder.groupKey("I_ITEM_ID", "S_STATE"),
                                builder.avg(false, "AGG1", builder.field("SS_QUANTITY")),
                                builder.avg(false, "AGG2", builder.field("SS_LIST_PRICE")),
                                builder.avg(false, "AGG3", builder.field("SS_COUPON_AMT")),
                                builder.avg(false, "AGG4", builder.field("SS_SALES_PRICE")))
                        .sortLimit(0, 100, builder.field("I_ITEM_ID"), builder.field("S_STATE"))
                        .build();

        /*System.out.println(RelOptUtil.toString(rel));

        RelRunner relRunner = conn.unwrap(RelRunner.class);
        PreparedStatement stmt = relRunner.prepare(rel);
        System.out.println(stmt);*/
        //ResultSet resultSet = stmt.executeQuery();*/
    }
}