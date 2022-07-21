package algo

fun main() {
    val nums = readLine()!!.split(" ").map(String::toInt).toMutableList()
    val size = nums.size
    var currentIndex = 1

    for (i in 1 until size){
        if(nums[i] != nums[i-1]){
            nums[currentIndex] = nums[i]
            currentIndex++
        }
    }

    for (i in 0 until currentIndex){
        print("${nums[i]} ")
    }
}