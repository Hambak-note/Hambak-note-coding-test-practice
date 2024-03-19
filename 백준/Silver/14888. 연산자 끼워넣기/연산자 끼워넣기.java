import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int operandCnt;

    private static int[] operands;
    private static int[] operationCount; //덧셈, 뺄셈, 곱셈, 나눗셈
    private static List<String> operations = new ArrayList<>();
    private static boolean[] operationsUsed;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        operandCnt = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        operands = new int[operandCnt];
        for (int i = 0; i < operandCnt; i++) {
            operands[i] = Integer.parseInt(st.nextToken());
        }

        operationCount = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operationCount[i] = Integer.parseInt(st.nextToken());
        }

        String operationsStr = makeOperationString();
        operationsUsed = new boolean[operationsStr.length()];
        generateOperationPermutation(operationsStr, "");


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String operation : operations) {
            int result = calculate(operation);
            max = Math.max(max, result);
            min = Math.min(min, result);
        }


        System.out.println(max);
        System.out.println(min);

    }

    private static String makeOperationString() {

        StringBuilder sb = new StringBuilder();

        int plusCnt = operationCount[0];
        for (int i = 0; i < plusCnt; i++) sb.append("+");


        int minusCnt = operationCount[1];
        for (int i = 0; i < minusCnt; i++) sb.append("-");

        int mulCnt = operationCount[2];
        for (int i = 0; i < mulCnt; i++) sb.append("*");

        int divCnt = operationCount[3];
        for (int i = 0; i < divCnt; i++) sb.append("/");


        return sb.toString();
    }

    private static void generateOperationPermutation(String operationStr, String current) {

        if(current.length() == operationStr.length()) {
            operations.add(current);
            return;
        }

        for (int i = 0; i < operationStr.length(); i++) {

            if(operationsUsed[i]) continue;

            operationsUsed[i] = true;
            generateOperationPermutation(operationStr, current + operationStr.charAt(i));
            operationsUsed[i] = false;
        }
    }

    private static int calculate(String operations) {

        int result = 0;

        int operand = operands[0];
        for(int i= 1; i < operandCnt; i++) {
            char operation = operations.charAt(i - 1);
            if(operation == '+') {
                result = operand + operands[i];
                operand = result;
                continue;
            }

            if(operation == '-') {
                result = operand - operands[i];
                operand = result;
                continue;
            }

            if(operation == '*') {
                result = operand * operands[i];
                operand = result;
                continue;
            }

            result = operand / operands[i];
            operand = result;
        }

        return result;
    }
}
