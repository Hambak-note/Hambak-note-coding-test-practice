fun main() {
    val alpArray = Array<Int>(26){0}
    val answer = StringBuilder("")
    val input = readln()
    val firstArray = StringBuilder("")
    val center = StringBuilder("")
    input.toCharArray().sort()

    input.forEach {
        alpArray[it.toInt()-65]++
    }
    val count = alpArray.count { it%2 !=0 }
    if (count > 1) {
        println("I'm Sorry Hansoo")
        return
    } else if (count == 1) {
        alpArray.forEachIndexed { index, i ->
            if (i %2 != 0) {
                repeat((i-1)/2) {
                    firstArray.append((index+65).toChar())
                }
                center.append((index+65).toChar().toString())
            } else {
                repeat(i/2) {
                    firstArray.append((index+65).toChar())
                }
            }
        }
        answer.append(firstArray)
        answer.append(center)
        answer.append(firstArray.reverse())
    } else {
        alpArray.forEachIndexed { index, i ->
            repeat(i/2) {
                firstArray.append((index+65).toChar())
            }
        }
        answer.append(firstArray)
        answer.append(firstArray.reverse())
    }
    println(answer)
}