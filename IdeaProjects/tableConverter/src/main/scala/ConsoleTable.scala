import java.util.ArrayList

import java.lang.StringBuilder

//remove if not needed
import scala.collection.JavaConversions._

class ConsoleTable(headersIn: ArrayList[String],
                   content: ArrayList[ArrayList[String]]) {

  /*
   * Modify these to suit your use
   */

  private val TABLEPADDING: Int = 4

  private val SEPERATOR_CHAR: Char = '-'

  private var headers: ArrayList[String] = headersIn

  private var table: ArrayList[ArrayList[String]] = content

  private var maxLength: ArrayList[Integer] = new ArrayList[Integer]()

  private var rows: Int = _

  private var cols: Int = _

  for (i <- 0 until headers.size) {
    maxLength.add(headers.get(i).length)
  }

  calcMaxLengthAll()

  /*
   * To update the matrix
   */

  def updateField(row: Int, col: Int, input: String): Unit = {
    //Update the value
    table.get(row).set(col, input)
    //Then calculate the max length of the column
    calcMaxLengthCol(col)
  }

  /*
   * Prints the content in table to console
   */

  def printTable(): Unit = {
    //Take out the
    val sb: StringBuilder = new StringBuilder()
    val sbRowSep: StringBuilder = new StringBuilder()
    var padder: String = ""
    val rowLength: Int = 0
    var rowSeperator: String = ""
    for (i <- 0 until TABLEPADDING) {
      padder += " "
    }
    for (i <- 0 until maxLength.size) {
      sbRowSep.append("|")
      for (j <- 0 until maxLength.get(i) + (TABLEPADDING * 2)) {
        sbRowSep.append(SEPERATOR_CHAR)
      }
    }
    sbRowSep.append("|")
    rowSeperator = sbRowSep.toString
    sb.append(rowSeperator)
    sb.append("\n")
    //HEADERS
    sb.append("|")
    for (i <- 0 until headers.size) {
      sb.append(padder)
      sb.append(headers.get(i))
      for (k <- 0 until (maxLength.get(i) - headers.get(i).length)) {
        sb.append(" ")
      }
      sb.append(padder)
      sb.append("|")
    }
    sb.append("\n")
    sb.append(rowSeperator)
    sb.append("\n")
    for (i <- 0 until table.size) {
      val tempRow: ArrayList[String] = table.get(i)
      //New row
      sb.append("|")
      for (j <- 0 until tempRow.size) {
        sb.append(padder)
        sb.append(tempRow.get(j))
        for (k <- 0 until (maxLength.get(j) - tempRow.get(j).length)) {
          sb.append(" ")
        }
        sb.append(padder)
        sb.append("|")
      }
      sb.append("\n")
      sb.append(rowSeperator)
      sb.append("\n")
    }
    println(sb.toString)
  }

/*
 * Fills maxLenth with the length of the longest word
 * in each column
 *
 * This will only be used if the user dont send any data
 * in first init
 */
private def calcMaxLengthAll(): Unit = {
  for (i <- 0 until table.size) {
    val temp: ArrayList[String] = table.get(i)
    for (j <- 0 until temp.size if temp.get(j).length > maxLength.get(j)) {
      maxLength.set(j, temp.get(j).length)
    }
  }
}

  /*
   * Same as calcMaxLength but instead its only for the column given as inparam
   */

  private def calcMaxLengthCol(col: Int): Unit = {
    for (i <- 0 until table.size
         if table.get(i).get(col).length > maxLength.get(col)) {
      maxLength.set(col, table.get(i).get(col).length)
    }
  }

}