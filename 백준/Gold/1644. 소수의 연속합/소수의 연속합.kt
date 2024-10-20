fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val primes = sieveOfEratosthenes(n)
    println(twoPointer(n, primes))
}

fun sieveOfEratosthenes(n: Int): List<Int> {
    val primes = mutableListOf<Int>()
    val isPrime = BooleanArray(n + 1) { true }

    for (p in 2..n) {
        if (isPrime[p]) {
            primes.add(p)
            var i = p * 2
            while (i <= n) {
                isPrime[i] = false
                i += p
            }
        }
    }
    return primes
}

fun twoPointer(n: Int, primes: List<Int>): Int {
    var cnt = 0
    var left = 0
    var right = 0
    var sum = 0

    while (true) {
        if (sum >= n) {
            if (sum == n) cnt++
            sum -= primes[left++]
        }
        else if (right == primes.size) break
        else sum += primes[right++]
    }
    return cnt
}