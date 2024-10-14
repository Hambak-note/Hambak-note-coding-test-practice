fun main() = with(System.`in`.bufferedReader()) {

    val inputStr = readLine();
    val targetStr = readLine();
    val inputStrLen = inputStr.length;
    val targetStrLen = targetStr.length;
    
    val replacedStr = inputStr.replace(targetStr, "");
    val replacedStrLen = replacedStr.length;

    val answer = (inputStrLen - replacedStrLen) / targetStrLen;
    println(answer);
}