import java.util
import java.lang.StringBuilder
import java.util.ArrayList


class ConsoleTable(var headers: ArrayList[String], var table: ArrayList[ArrayList[String]]) {
  this.maxLength = new ArrayList[Integer]
  //Set headers length to maxLength at first
  var i = 0
  while ( {
    i < headers.size
  }) {
    maxLength.add(headers.get(i).length)

    {
      i += 1; i - 1
    }
  }
  calcMaxLengthAll()
  /*
     * Modify these to suit your use
     */ final private val TABLEPADDING = 4
  final private val SEPERATOR_CHAR = '-'
  private var maxLength = null
  private val rows = 0
  private val cols = 0

  /*
     * To update the matrix
     *//*
     * Constructor that needs two arraylist
     * 1: The headersIs is one list containing strings with the columns headers
     * 2: The content is an matrix of Strings build up with ArrayList containing the content
     *
     * Call the printTable method to print the table
     */ def updateField(row: Int, col: Int, input: String): Unit = { //Update the value
    table.get(row).set(col, input)
    //Then calculate the max length of the column
    calcMaxLengthCol(col)
  }

  /*
     * Prints the content in table to console
    */ def printTable(): Unit = { //Take out the
    val sb = new StringBuilder
    val sbRowSep = new StringBuilder
    var padder = ""
    val rowLength = 0
    var rowSeperator = ""
    //Create padding string containing just containing spaces
    var i = 0
    while ( {
      i < TABLEPADDING
    }) {
      padder += " "

      {
        i += 1; i - 1
      }
    }
    //Create the rowSeperator
    var i = 0
    while ( {
      i < maxLength.size
    }) {
      sbRowSep.append("|")
      var j = 0
      while ( {
        j < maxLength.get(i) + (TABLEPADDING * 2)
      }) {
        sbRowSep.append(SEPERATOR_CHAR)

        {
          j += 1; j - 1
        }
      }

      {
        i += 1; i - 1
      }
    }
    sbRowSep.append("|")
    rowSeperator = sbRowSep.toString
    sb.append(rowSeperator)
    sb.append("\n")
    //HEADERS
    sb.append("|")
    var i = 0
    while ( {
      i < headers.size
    }) {
      sb.append(padder)
      sb.append(headers.get(i))
      //Fill up with empty spaces
      var k = 0
      while ( {
        k < (maxLength.get(i) - headers.get(i).length)
      }) {
        sb.append(" ")

        {
          k += 1; k - 1
        }
      }
      sb.append(padder)
      sb.append("|")

      {
        i += 1; i - 1
      }
    }
    sb.append("\n")
    sb.append(rowSeperator)
    sb.append("\n")
    //BODY
    var i = 0
    while ( {
      i < table.size
    }) {
      val tempRow = table.get(i)
      //New row
      sb.append("|")
      var j = 0
      while ( {
        j < tempRow.size
      }) {
        sb.append(padder)
        sb.append(tempRow.get(j))
        var k = 0
        while ( {
          k < (maxLength.get(j) - tempRow.get(j).length)
        }) {
          sb.append(" ")

          {
            k += 1; k - 1
          }
        }
        sb.append(padder)
        sb.append("|")

        {
          j += 1; j - 1
        }
      }
      sb.append("\n")
      sb.append(rowSeperator)
      sb.append("\n")

      {
        i += 1; i - 1
      }
    }
    System.out.println(sb.toString)
  }

  /*
     * Fills maxLenth with the length of the longest word
     * in each column
     *
     * This will only be used if the user dont send any data
     * in first init
     */ private def calcMaxLengthAll(): Unit = {
    var i = 0
    while ( {
      i < table.size
    }) {
      val temp = table.get(i)
      var j = 0
      while ( {
        j < temp.size
      }) { //If the table content was longer then current maxLength - update it
        if (temp.get(j).length > maxLength.get(j)) maxLength.set(j, temp.get(j).length)

        {
          j += 1; j - 1
        }
      }

      {
        i += 1; i - 1
      }
    }
  }

  /*
     * Same as calcMaxLength but instead its only for the column given as inparam
     */ private def calcMaxLengthCol(col: Int): Unit = {
    var i = 0
    while ( {
      i < table.size
    }) {
      if (table.get(i).get(col).length > maxLength.get(col)) maxLength.set(col, table.get(i).get(col).length)

      {
        i += 1; i - 1
      }
    }
  }
}