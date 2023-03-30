package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int[] resultArr = new int[input+1];

        resultArr[1] = 0;

        for(int i = 2; i <= input; i++){

            resultArr[i] = resultArr[i-1] + 1;
            if(i%2 ==0) resultArr[i] = Math.min(resultArr[i], resultArr[i/2]+1);
            if(i%3 ==0) resultArr[i] = Math.min(resultArr[i], resultArr[i/3]+1);
        }

        System.out.println(resultArr[input]);
    }


}
