import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static int numOfLevel;
    private static int[] scores;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numOfLevel = Integer.parseInt(br.readLine());
        scores = new int[numOfLevel];

        for (int i = 0; i < numOfLevel; i++) scores[i] = Integer.parseInt(br.readLine());

        for (int i = numOfLevel - 1; i > 0; i--) {

            int cur = scores[i];
            int prev = scores[i-1];

            if(cur > prev) continue;

            int minus = Math.abs(cur - prev - 1);

            answer += minus;
            scores[i - 1] = prev - minus;
        }

        System.out.println(answer);


    }
}
