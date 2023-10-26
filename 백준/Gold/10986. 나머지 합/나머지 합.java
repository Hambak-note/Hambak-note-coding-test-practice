

import java.util.Scanner;

/**
 * 핵심 개념
 * 1. (A + B) % C = ((A % C) + (B%C)) % C와 같다
 * 2. subTotal[i] % M = subTotal[j] % M 일면 (S[j] - S[i]) % M 은 0이다. 
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] subTotalArr = new long[N];
        long[] C = new long[M]; //같은 나머지의 인덱스를 카운트하는 배열
        long answer = 0;
        
        subTotalArr[0] = sc.nextInt();
        for(int i = 1; i < N; i++) {
            subTotalArr[i] = subTotalArr[i-1] + sc.nextInt();
        }
        
        for(int i = 0; i < N; i++){
            int remainder = (int) (subTotalArr[i] % M);
            if(remainder == 0) answer++; //0~i까지의 구간 합 자체가 0일 때 정답에 더해주기
            //나머지가 같은 인덱스의 개수 카운팅 하기
            C[remainder]++;
        }
        
        for(int i =0; i < M; i++) {
            if(C[i] > 1) {
                
                //나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 더하기
                answer = answer + (C[i] * (C[i] -1) / 2);
            }
        }

        System.out.println(answer);
    }
}
