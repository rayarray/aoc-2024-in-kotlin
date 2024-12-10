//import kotlin.math.abs

fun main() {
    val input = readInput("Day03")
    var allInput = ""
    for (elem in input) { allInput += elem }
    //val pattern = Regex("mul\((\d+),(\d+)\)")
    val multiPattern = Regex("(mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\))")
    val mulPattern = Regex("mul\\((\\d+),(\\d+)\\)")
    val doPattern = Regex("do\\(\\)")
    //val input = readInput("Day03test01")
    var total = 0
    println()
//    for (i in 1..allInput.size) {
//        val firstMul = mulPattern.find(allInput, i)
//        val firstDo = doPattern.find(allInput, i)
//        if (firstMul < firstDo)
//    }
    var mulStrs = multiPattern.findAll(input.toString()).map{it.value}.toList()
    var mulTotal = 0
    var doMul = true
    for (elem in mulStrs) {
        println("[$elem]")
        if (elem == "do()") doMul = true
        else if (elem == "don't()") doMul = false
        else if (doMul == true) {
            val subElem = elem.subSequence(4, elem.length - 1)
            //println("$subElem")
            val row = subElem.split(',').map(String::toInt)
            //println(row)
            mulTotal += row[0] * row[1]
        }
    }
    println(mulTotal)
}
