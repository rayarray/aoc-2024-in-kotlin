import kotlin.math.abs

fun main() {
    fun getPair(input: String): Pair<Int, Int> {
        val (num1, num2) = input.split("\\s+".toRegex()).map { Integer.parseInt(it) }
        return Pair(num1, num2)
    }
    fun part1(input: List<String>): Int { return input.size }

    fun part2(input: List<String>): Int { return input.size }

    //fun sortPart(input: )

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
    //println(getPair(input[0]))
    val numbers1 = mutableListOf<Int>()
    val numbers2 = mutableListOf<Int>()
    for (elem in input) {
        //println(getPair(elem))
        numbers1.add(getPair(elem).first)
        numbers2.add(getPair(elem).second)
    }
    numbers1.sort()
    numbers2.sort()
    //println(numbers1.joinToString())
    //println(numbers2.joinToString())
    //val bothlists = Pair(numbers1, numbers2)
    val bothlists = numbers1.zip(numbers2).take(minOf(numbers1.size, numbers2.size)).toList()
    var totaldist = 0
    for (elem in bothlists) {
        totaldist += abs(elem.second - elem.first)
    }
    println(totaldist)
}
