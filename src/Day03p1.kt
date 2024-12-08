//import kotlin.math.abs

var globalint = 3

fun main() {
    val input = readInput("Day03")
    //val pattern = Regex("mul\((\d+),(\d+)\)")
    val pattern = Regex("mul\\((\\d+),(\\d+)\\)")
    //val input = readInput("Day03test01")
    var total = 0
    for (elem in input) {
        print(elem)
        print('.')
    }
    println()
    println(pattern.findAll(input.toString()).map{it.value}.toList())
}
