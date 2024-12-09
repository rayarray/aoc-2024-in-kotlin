import kotlin.math.max
import kotlin.math.min

fun main() {
    fun min(val1: Int, val2: Int, val3: Int): Int {
        return (min(val1, min(val2, val3)))
    }
    fun getColumns(input: List<String>) : List<String> {
        val columns = mutableListOf<String>()
        for (col in 0..(input[0].length - 1)) {
            var rowString = ""
            for (row in input) {
                rowString += row[col]
            }
            columns.add(rowString)
        }
        return columns
    }
    fun getDiagonal(input : List<String>) : List<String> {
        val ROW = input.size
        val COL = input[0].length
        var diagonal = mutableListOf<String>()
        for (line in 1..(input.size + input[0].length)) {
            var lineString = ""
            val start_col = max(0, line - ROW)
            val count = min(line, (COL - start_col), ROW)
            for (j in 0..count - 1) {
                lineString += input[min(ROW, line) - j - 1][start_col + j]
            }
            diagonal.add(lineString)
        }
        return diagonal
    }
    fun getDiagonalLine(line: Int, input: List<String>) : String {
        var diagonal = ""
        var size = input[0].length
        if (line < 1 || line >= size * 2) return diagonal
        if (line <= input[0].length) {
            var xy = 2
        }
        return "1"
    }
    fun xmasMatch(input : String) : Boolean {
        if (input.length > 3 && input[0] == 'X' && input[1] == 'M' && input[2] == 'A' && input[3] == 'S') return true
        return false
    }
    fun xmasCount(input : String) : Int {
        var count = 0
        for (i in 0..(input.length - 4)) {
            if (xmasMatch(input.substring(i, i + 4))) count++
        }
        return count
    }
    fun xmasListCount(input : List<String>) : Int {
        var count = 0
        for (elem in input) {
            count += xmasCount(elem)
            count += xmasCount(elem.reversed())
        }
        return count
    }
    val input = readInput("Day04")
    println(input[0])
    println(input[0][0])
    println(input[0][input[0].length - 1])
    val rowLength = input[0].length
    var xmasMatches = 0
    for (row in input) {
        assert(row.length == rowLength)
        xmasMatches += xmasCount(row)
        xmasMatches += xmasCount(row.reversed())
    }
    xmasMatches += xmasListCount(getDiagonal(input))
    xmasMatches += xmasListCount(getDiagonal(input.reversed()))
    xmasMatches += xmasListCount(getColumns(input))
    println("XMAS total matches: $xmasMatches")
}
