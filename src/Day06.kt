fun main() {
    val input = readInput("Day06example")
    val ROWS = input.size
    val COLS = input[0].length
    val empty: Char = '.'
    val blocked: Char = '#'
    var guardPos: Pair<Int, Int>
    val guardDir = 1
    fun movePos(pos: Pair<Int, Int>, dir: Int): Pair<Int, Int> {
        if (dir == 1) return Pair(pos.first - 1, pos.second)
        else if (dir == 2) return Pair(pos.first, pos.second + 1)
        else if (dir == 3) return Pair(pos.first + 1, pos.second)
        else if (dir == 4) return Pair(pos.first, pos.second - 1)
        error("invalid direction")
    }
    fun checkBounds(pos: Pair<Int, Int>): Boolean {
        return if (pos.first < 0 || pos.second < 0 || pos.first >= ROWS || pos.second >= COLS) false
        else true
    }
    fun canMove(pos: Pair<Int, Int>, dir: Int, grid: Array<CharArray>): Boolean {
        val newPos = movePos(pos, dir)
        if (!checkBounds(newPos)) return true
        else if (grid[newPos.first][newPos.second] != blocked) return true
        else if (grid[newPos.first][newPos.second] == blocked) return false
        error("canMove invalid state")
    }
    //println(input)
    //println(input.get(0))
    var labGrid: Array<CharArray> = Array(ROWS) { CharArray(COLS) }
    var rownbr = 0
    var guardSet = false
    for (row in input) {
        var colnbr = 0
        for (char in row) {
            if (char == empty) labGrid[rownbr][colnbr] = empty
            else if (char == blocked) labGrid[rownbr][colnbr] = char
            else if (!guardSet && char == '^') {
                labGrid[rownbr][colnbr] = empty
                guardPos = Pair(rownbr, colnbr)
                guardSet = true
            }
            else if (guardSet && char == '^')
                error("multiple guards!")
            else error("grid initialization failure")
        }
        rownbr++
    }
    for (i in 0..(input[0].length - 1))
        println(labGrid[i])
}