import kotlin.math.abs

fun main() {
    fun getPair(input: String): Pair<Int, Int> {
        val (num1, num2) = input.split("\\s+".toRegex()).map { Integer.parseInt(it) }
        return Pair(num1, num2)
    }
    val input = readInput("Day01")
    val numbers1 = mutableListOf<Int>()
    val numbers2 = mutableListOf<Int>()
    for (elem in input) {
        //println(getPair(elem))
        numbers1.add(getPair(elem).first)
        numbers2.add(getPair(elem).second)
    }
    numbers1.sort()
    numbers2.sort()
    val bothlists = numbers1.zip(numbers2).take(minOf(numbers1.size, numbers2.size)).toList()
    var totaldist = 0
    for (elem in bothlists) {
        totaldist += abs(elem.second - elem.first)
    }
    //println(totaldist)
    var simiscore = 0
    for (elem in numbers1) {
        var occur = 0
        for (elem2 in numbers2) {
            if (elem == elem2) { occur++ }
        }
        simiscore += occur * elem
    }
    println(simiscore)
}
