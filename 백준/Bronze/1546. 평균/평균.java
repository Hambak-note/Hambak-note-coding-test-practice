import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] scoreArr = new int[N];

        for(int i = 0; i < N; i++) {
            scoreArr[i] = sc.nextInt();
        }

        long sum = 0;
        long max = 0;

        for(int i = 0; i < N; i++) {
            if(scoreArr[i] > max) max = scoreArr[i];
            sum = sum +scoreArr[i];
        }

        System.out.println(sum * 100.0 / max / N);
    }
}