import java.io.*;
import java.util.StringTokenizer;

public class Main {


    private static BufferedReader br;
    private static int N, K;
    private static String S;
    private static char[] chArr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } 

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (K > 0) {
            if (idx == N - 1) {

                K %= 26;
                if (K > 'Z' + 1 - chArr[idx]) {
                    K -= 'Z' + 1 - chArr[idx];
                    chArr[idx] = 'A';
                }
                chArr[idx] += K;
                K = 0;
            } else {
                if (chArr[idx] == 'A') {
                    idx++;
                    continue;
                } else {
                    int count = 'Z' - chArr[idx] + 1;
                    if (count <= K) {
                        chArr[idx] = 'A';
                        K -= count;
                        idx++;
                    } else {
                        idx++;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(chArr[i]);
        }

        return sb.toString();
    } 

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        S = br.readLine();
        chArr = S.toCharArray();
    } 
} 