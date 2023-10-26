import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfNumbers = Integer.parseInt(st.nextToken());
        int requiredSumCount = Integer.parseInt(st.nextToken());

        long[] subTotalArr = new long[numberOfNumbers+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= numberOfNumbers; i++) {
            subTotalArr[i] = subTotalArr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < requiredSumCount; i++) {
            st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(subTotalArr[end] - subTotalArr[begin-1]);
        }
    }
}