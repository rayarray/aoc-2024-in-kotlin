import kotlin.math.abs
import kotlin.comparisons.compareByDescending

var x = 0

fun main() {
    fun incAllSafe(levels: List<Int>): Boolean {
        if (levels.size < 2) return true
        var curr = -1
        for (level in levels) {
            if (curr == -1) curr = level
            else {
                val diff = level - curr
                if (diff <= 0 || diff > 3) return false
                curr = level
            }
        }
        return true
    }
    fun decAllSafe(levels: List<Int>): Boolean {
        if (levels.size < 2) return true
        var curr = -1
        for (level in levels) {
            if (curr == -1) curr = level
            else {
                val diff = level - curr
                if (diff >= 0 || diff < -3) return false
                curr = level
            }
        }
        return true
    }
    fun incSafe(levels: List<Int>): Boolean {
        if (levels.size < 2) return true
        var curr = -1
        var skip = -1
        for (level in levels) {
            var skipdone = false
            if (curr == -1) curr = level
            else {
                val diff = level - curr
                if (diff <= 0 || diff > 3) {
                    if (skip == -1) {
                        print('S')
                        print(level)
                        skipdone = true
                        skip = level
                    }
                    else {
                        //print('i')
                        //println(level)
                        return false
                    }
                }
                if (!skipdone) curr = level
            }
        }
        return true
    }
    fun decSafe(levels: List<Int>): Boolean {
        if (levels.size < 2) return true
        var curr = -1
        var skip = -1
        for (level in levels) {
            var skipdone = false
            if (curr == -1) curr = level
            else {
                val diff = level - curr
                if (diff >= 0 || diff < -3) {
                    if (skip == -1) {
                        skipdone = true
                        skip = level
                    }
                    else {
                        //print('d')
                        //println(level)
                        return false
                    }
                }
                if (!skipdone) curr = level
            }
        }
        return true
    }
//    fun List<Int>.getAllSublistsOneLess(): List<List<Int>> {
//        val originalSize = size
//        return combinations(originalSize - 1)
//            .filter { it.size == originalSize - 1 }
//            .map { it.toList() }
//    }
    val input = readInput("Day02")
    //val input = readInput("Day02test01")
    //val input = readInput("Day02test02")
    var numOfSafeReports = 0
    for (elem in input) {
        val row = elem.split(' ').map { it.toInt() }
        if (incAllSafe(row.subList(1, row.size)) || decAllSafe(row.subList(1, row.size)) || incSafe(row) || decSafe(row)) {
            //print('+')
            numOfSafeReports++
            if (incAllSafe(row.subList(1, row.size)))
                print("iOK: ")
            else if (decAllSafe(row.subList(1, row.size)))
                print("dOK: ")
            else if (incSafe(row))
                print("IOK: ")
            else if (decSafe(row))
                print("DOK: ")
        } else
            print("KO: ")
        println(row)
        //println(row.subList(1, row.size))
    }
    println("safe reports: $numOfSafeReports")
    //println(numOfSafeReports)
    numOfSafeReports = 0
    for (report in input) {
        val row = report.split(' ').map { it.toInt()}
        //println(row.toMutableList())
        var safereport = false
        for (i in row.indices) {
            val sub = row.toMutableList()
            sub.removeAt(i)
            //println(sub)
            if (incAllSafe(sub) || decAllSafe(sub)) {
                safereport = true
                break
            }
        }
        if (safereport) numOfSafeReports++
    }
    println("2safe reports: $numOfSafeReports")
}
