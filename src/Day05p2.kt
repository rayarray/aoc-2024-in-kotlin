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
    fun checkAllRules(rules : List<Pair<Int, Int>>, list: List<Int>) : Boolean {
        for (rule in rules) {
            if (!checkRule(rule, list))
                return false
        }
        return true
    }
    fun getFailingRule(rules: List<Pair<Int, Int>>, list: List<Int>) : Pair<Int, Int> {
        for (rule in rules) {
            if (!checkRule(rule, list))
                return rule
        }
        error("getFailingRule failed to get failing rule")
        return Pair(-1, -1)
    }
    val input = readInput("Day05")
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
            println("Passed! Middle page: ${printList[printList.size / 2]}")
            middlePageSum += printList[printList.size / 2]
        }
    }
    println("Final sum of middle pages: $middlePageSum")
    var correctedMiddlePageSum = 0
    var modifiedPrints = mutableListOf<List<Int>>()
    for (printList in printOuts) {
        println ("car: ${checkAllRules(orderingRules, printList)}")
        var modPage = printList.toMutableList()
        if (!checkAllRules(orderingRules, modPage)) {
            while (!checkAllRules(orderingRules, modPage)) {
                println(getFailingRule(orderingRules, modPage))
                val (first, second) = getFailingRule(orderingRules, modPage)
                for (i in 0..(modPage.size - 1)) {
                    if (second == modPage[i]) { modPage[i] = first }
                    else if (first == modPage[i]) { modPage[i] = second }
                }
            }
            modifiedPrints.add(modPage)
            correctedMiddlePageSum += modPage[modPage.size / 2]
        }
    }
    println(modifiedPrints)
    println("Final sum of corrected middle pages: $correctedMiddlePageSum")
//    println(orderingRules)
//    println(printOuts)
}