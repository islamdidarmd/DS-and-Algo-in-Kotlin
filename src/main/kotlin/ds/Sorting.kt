package ds

fun main() {
    val arr = readLine()!!.split(" ").map(String::toInt)
    bubbleSort(arr.toMutableList())
}

fun bubbleSort(arr: MutableList<Int>) {
    for (i in 0..arr.size - 2) {
        for (j in i + 1 until arr.size) {
            if (arr[i] > arr[j]) {
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }

    println("-------Bubble Sort--------")
    println(arr)
}