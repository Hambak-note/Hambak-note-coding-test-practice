
import java.io.*;
import java.util.*;

public class Main {

    private static int n, s;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int curSum = 0;

        while(left <= n && right <= n) {

            if(curSum >= s && answer > (right - left)) answer = right - left;

            if(curSum < s) curSum += arr[right++];
            else curSum -= arr[left++];
        }

        if(answer == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(answer);

    }
}
