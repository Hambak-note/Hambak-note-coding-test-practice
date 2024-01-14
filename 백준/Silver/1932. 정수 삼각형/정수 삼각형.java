import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] intTriangle;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        intTriangle = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()) {
                intTriangle[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        System.out.println(dp());
    }

    private static int dp() {

        for(int i=n-1;i>=1;i--)
            for(int j=0;j<i;j++) {
                intTriangle[i - 1][j] += Math.max(intTriangle[i][j], intTriangle[i][j + 1]);
            }

        return intTriangle[0][0];
    }
}
