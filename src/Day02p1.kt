import kotlin.math.abs

fun main() {
    fun isItSafe(input: List<Int>): Boolean {
        var currentlevel = -1
        var incdec = 0
        for (elem in input) {
            if (currentlevel == -1) currentlevel = elem
            else if (incdec == 0) {
                val diff = elem - currentlevel
                if (diff > 3 ||  diff < -3|| diff == 0) return false
                currentlevel = elem
                incdec = if (diff > 0) 1 else -1
            }
            else {
                val diff = elem - currentlevel
                if (incdec == 1 && (diff > 3 || diff <= 0)) return false
                else if (incdec == -1 && (diff < -3 || diff >= 0)) return false
                currentlevel = elem
            }

        }
        return true
    }
    val input = readInput("Day02")
    var numOfSafeReports = 0
    for (elem in input) {
        //println(elem)
        val row = elem.split(' ').map { it.toInt() }
        //println(row)
        if (isItSafe(row)) numOfSafeReports++
        //if (isItSafe(row)) println("safe") else println("NOT safe")
    }
    println(numOfSafeReports)
}
