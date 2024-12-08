//import kotlin.math.abs

var globalint = 3

fun main() {
    val input = readInput("Day03")
    //val pattern = Regex("mul\((\d+),(\d+)\)")
    val pattern = Regex("mul\\((\\d+),(\\d+)\\)")
    //val input = readInput("Day03test01")
    var total = 0
    println()
    var mulStrs = pattern.findAll(input.toString()).map{it.value}.toList()
    var mulTotal = 0
    for (elem in mulStrs) {
        val subElem = elem.subSequence(4, elem.length - 1)
        //println("$subElem")
        val row = subElem.split(',').map(String::toInt)
        println(row)
        mulTotal += row[0] * row[1]
    }
    println(mulTotal)
}
