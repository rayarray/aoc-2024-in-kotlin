fun main() {
    fun checkRule(rule : Pair<Int, Int>, list: List<Int>) : Boolean {
        var firstFound = false
        var secondFound = false
        var firstBefore = true
        for (page in list) {
            if (rule.first == page) {
                firstFound = true
                if (secondFound) { firstBefore = false }
            }
            else if (rule.second == page)
                secondFound = true
        }
        if (secondFound == false) return true
        if (secondFound && !firstFound) return true
        if (secondFound && firstFound && firstBefore) return true
        return false
    }
    val input = readInput("Day05example")
    var orderingRules = mutableListOf<Pair<Int, Int>>()
    var printOuts = mutableListOf<List<Int>>()
    var linebreak = false
    for (row in input) {
        if (row.length == 5 && row[2] == '|') {
            val pair = row.split('|').map { it.toInt() }
            orderingRules.add(Pair(pair[0], pair[1]))
        }
        else if (row.isBlank()) { linebreak = true }
        else if (linebreak) {
            val printOrder = row.split(',').map { it.toInt() }
            printOuts.add(printOrder)
        }
    }
    var middlePageSum = 0
    for (printList in printOuts) {
        if (printList.size % 2 != 1) println("FAIL!")
        var ruleChecksPassed = true
        for (rule in orderingRules) {
            if (!checkRule(rule, printList)) {
                println("Rule ${rule.first}|${rule.second} failed for $printList")
                ruleChecksPassed = false
            }
        }
        if (ruleChecksPassed) {
            println("Passed! Pages to print: ${printList.size / 2} Middle page: ${printList[printList.size / 2]}")
            middlePageSum += printList[printList.size / 2]
        }
    }
    println("Final sum of middle pages: $middlePageSum")
//    println(orderingRules)
//    println(printOuts)
}