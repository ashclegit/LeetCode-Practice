import java.util.regex.Pattern;

public class revString {

    public static void main(String[] args) {
        String test = "the sky is blue";
        String[] splitted = test.split(" ");

        String res = "";
        for(int i=0;i<splitted.length;i++)
        {
            res = " " + splitted[i] + res;
        }

        System.out.println(res);

    }
}
