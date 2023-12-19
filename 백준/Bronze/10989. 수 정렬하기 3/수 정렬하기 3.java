

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    private static int testCase;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testCase = Integer.parseInt(br.readLine());

        int[] inputArr = new int[testCase];
        
        for(int i = 0; i < testCase; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(inputArr);
        for (int val : inputArr) {
            sb.append(val).append('\n');
        }

        System.out.println(sb);
    }
}
