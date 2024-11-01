import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        while(n--> 0){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());

            if(w == 136){
                sum += 1000;
            } else if (w == 142) {
                sum += 5000;
            } else if (w == 148) {
                sum += 10000;
            } else if (w == 154)   {
                sum += 50000;
            }
        }
        System.out.println(sum);

    }
}