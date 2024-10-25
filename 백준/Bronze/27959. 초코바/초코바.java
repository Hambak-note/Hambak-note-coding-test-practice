import java.io.*;
import java.util.*;

public class Main {
    
    private static int n, m;
    private static final int COIN = 100;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        
        int money = n * COIN;
        
        if(money >= m) System.out.println("Yes");
        else System.out.println("No");
    }
}
