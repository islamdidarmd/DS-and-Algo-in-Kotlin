package algo

fun main() {
    val (n) = readLine()!!.split(" ").map(String::toInt)

    val matrix = Array(n) { IntArray(n) }
    val visitMap = Array(n) { BooleanArray(n) }

    var visitedItemCounter = 0
    var value = 1
    var direction = 0

    var left = 0
    var right = n - 1
    var top = 0
    var bottom = n - 1

    repeat(n) { i ->
        repeat(n) { j ->
            matrix[i][j] = value++
            visitMap[i][j] = false
        }
    }

    repeat(n) { i ->
        repeat(n) { j ->
            print("${matrix[i][j]} ")
        }
        println()
    }
    println()

    while (visitedItemCounter < n * n) {
        when (direction) {
            0 -> {
                //topLeft to topRight
                for (i in top..bottom) {
                    var visited = false

                    for (j in left..right) {
                        if (!visitMap[i][j]) {
                            visitMap[i][j] = true
                            visited = true
                            visitedItemCounter++
                            print("${matrix[i][j]} ")
                        }
                    }
                    if (visited) break
                }
                top++
                direction = 1
            }
            1 -> {
                // topRight to bottomRight
                for (j in right downTo left) {
                    var visited = false

                    for (i in top..bottom) {
                        if (!visitMap[i][j]) {
                            visitMap[i][j] = true
                            visited = true
                            visitedItemCounter++
                            print("${matrix[i][j]} ")
                        }
                    }
                    if (visited) break
                }
                right--
                direction = 2
            }
            2 -> {
                //bottomRight to bottomLeft
                for (i in bottom downTo top) {
                    var visited = false

                    for (j in right downTo left) {
                        if (!visitMap[i][j]) {
                            visitMap[i][j] = true
                            visited = true
                            visitedItemCounter++
                            print("${matrix[i][j]} ")
                        }
                    }
                    if (visited) break

                }
                bottom--
                direction = 3
            }
            3 -> {
                //bottomLeft to topLeft
                for (j in left .. right) {
                    var visited = false

                    for (i in bottom downTo top) {
                        if (!visitMap[i][j]) {
                            visitMap[i][j] = true
                            visited = true
                            visitedItemCounter++
                            print("${matrix[i][j]} ")
                        }
                    }
                    if (visited) break
                }
                left++
                direction = 0
            }
        }
    }
}