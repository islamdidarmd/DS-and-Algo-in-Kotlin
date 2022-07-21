fun main() {
    val arr = readLine()!!.split(" ").map(String::toInt)
    val (query) = readLine()!!.split(" ").map(String::toInt)

    val pos = binarySearch(arr, query)

    if (pos == -1) println("Not found")
    else println("Found at pos $pos")
}

fun binarySearch(arr: List<Int>, query: Int): Int {
    var left = 0
    var right = arr.size - 1
    var pos = -1

    while (left <= right) {
        val mid = (left + right) / 2

        when {
            query == arr[mid] -> {
                pos = mid
                break
            }
            query > arr[mid] -> left = mid + 1
            else -> right = mid - 1
        }
    }

    return pos
}