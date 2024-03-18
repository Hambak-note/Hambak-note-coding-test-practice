import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    private static int stoneCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stoneCnt = Integer.parseInt(br.readLine());
        
        if(stoneCnt % 2 == 0) System.out.println("CY");
        else System.out.println("SK");
    }
}
