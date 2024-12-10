//import kotlin.math.abs

fun main() {
    val input = readInput("Day03")
    val pattern = Regex("mul\\((\\d+),(\\d+)\\)")
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
