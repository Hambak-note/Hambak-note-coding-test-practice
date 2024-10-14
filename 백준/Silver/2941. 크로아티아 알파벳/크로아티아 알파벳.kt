fun main() = with(System.`in`.bufferedReader()) {

    val alphas = arrayOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");
    var input = readLine()!!;

    alphas.forEach { alpha ->
        if( input.contains(alpha)) input = input.replace(alpha, "!");
    }

    println(input.length);
}