package algo.math

import kotlin.math.sqrt

fun main() {
    val n = readLine()!!.toInt()
    val sieve = SieveOfEratosthenes(max = n)
    sieve.preCalculatePrimes()

    for (i in 0..n) {
        if(sieve.isPrime(i)) {
            print("$i ")
        }
    }
}

class SieveOfEratosthenes(max: Int) {
    private val primeFlags = BooleanArray(max + 1) { true }
    private val primeCheckingLimit = sqrt(max.toDouble())

    fun preCalculatePrimes() {
        primeFlags.fill(true)
        primeFlags[0] = false
        primeFlags[1] = false

        var prime = 2
        while (prime <= primeCheckingLimit) {
            cutOffMultiples(flags = primeFlags, prime = prime)
            prime = getNextPrime(flags = primeFlags, prime = prime)
        }
    }

    fun isPrime(num: Int): Boolean = primeFlags[num]

    private fun cutOffMultiples(flags: BooleanArray, prime: Int) {
        var num = prime * prime

        while (num < primeFlags.size) {
            flags[num] = false
            num += prime
        }
    }

    private fun getNextPrime(flags: BooleanArray, prime: Int): Int {
        var num = prime + 1
        while (num < primeFlags.size && !flags[num]) {
            num++
        }
        return num
    }
}