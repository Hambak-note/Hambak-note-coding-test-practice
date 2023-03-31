package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[] targetNumberCountArr = new int[20];

        targetNumberCountArr[1] = 1;
        targetNumberCountArr[2] = 2;
        targetNumberCountArr[3] = 4;

        //n은 양수이며 11보다 작다.
        for(int i = 4; i < 11; i++){
            targetNumberCountArr[i] =
                    targetNumberCountArr[i-1] + targetNumberCountArr[i-2] + targetNumberCountArr[i-3];
        }

        while(testCase > 0){

            int n = Integer.parseInt(br.readLine());

            System.out.println(targetNumberCountArr[n]);

            testCase--;
        }
    }
}
