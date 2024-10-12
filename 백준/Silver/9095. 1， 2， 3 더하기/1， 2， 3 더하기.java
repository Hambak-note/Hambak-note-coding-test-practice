
import java.io.*;

public class Main {

    private static final int MAX_N = 11;
    
    private static int tc;
    private static int n;
    private static int d[];

    // D[i] = D[i-1] + D[i-2] + D[i-3]
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());
        initArrayD();
        
        for(int i = 0; i < tc; i++) {
            
            n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }
    
    private static void initArrayD() {
        
        d = new int[MAX_N];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        
        for(int i = 4; i < MAX_N; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
    }
}
