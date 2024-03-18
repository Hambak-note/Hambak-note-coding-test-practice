import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int oneCnt = 0;
        int zeroCnt = 0;

        char cur = input.charAt(0);
        if(cur == '0') zeroCnt++;
        else oneCnt++;

        for (int i = 0; i < input.length()-1; i++) {

            char next = input.charAt(i+1);

            if(cur == next) continue;

            if(next == '0') zeroCnt++;
            else oneCnt++;

            cur = next;
        }

        if(oneCnt > zeroCnt) System.out.println(zeroCnt);
        else System.out.println(oneCnt);
    }
}
