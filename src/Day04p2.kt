import kotlin.math.max
import kotlin.math.min

fun main() {
    fun min(val1: Int, val2: Int, val3: Int): Int {
        return (min(val1, min(val2, val3)))
    }
    fun msPair(first: Char, second: Char): Boolean {
        if (first == 'M' && second == 'S') return true
        else if (first == 'S' && second == 'M') return true
        return false
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
    val input = readInput("Day04test5")
    println("input.size: " + input.size + " input[0].length: " + input[0].length)
    //println(input[0])
    for (j in 0..(input.size - 1)) { print(input.get(1)[j]) }
    var XmasMatches = 0
    for (i in 1..(input.size - 1)) {
        for (j in 1..(input[0].length - 2)) {
            if (input[i][j] == 'A') {
                println("A at [$i][$j]")
                if (msPair(input[i - 1][j - 1], input[i + 1][j + 1])) println("msPair leftdown match")
                if (msPair(input[i - 1][j + 1], input[i + 1][j - 1])) println("msPair leftup match")
            }
            //if (j == 1) print(input[i][j])
            //if (i == 0 || i == input.size - 1 || j == 0 || j == input[0].length - 2 || input[i][j] != 'A') continue
            if (input[i][j] == 'A' && msPair(input[i - 1][j - 1], input[i + 1][j + 1]) &&
                msPair(input[i - 1][j + 1], input[i + 1][j - 1])) {
                println("Match at [$i][$j]")
                XmasMatches++
            }
        }
    }
    println("X-MASmatches: $XmasMatches")
}
