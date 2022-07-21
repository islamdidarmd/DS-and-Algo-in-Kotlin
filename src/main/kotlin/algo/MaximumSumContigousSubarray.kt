package algo

fun main() {
    val nums = readLine()!!.split(" ").map(String::toInt)

    var maxSum = Int.MIN_VALUE
    var currentSum = 0

    for (i in nums.indices) {
        currentSum += nums[i]
        if(currentSum > maxSum){
            maxSum = currentSum
        }

        if(currentSum < 0) currentSum = 0
    }

    println(maxSum)
}