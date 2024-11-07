import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {

            String input = br.readLine().replaceAll(" ", "");
            if(input.equals("*")) break;

            Set<Character> s = new HashSet<>();
            for(int i = 0; i < input.length(); i++) s.add(input.charAt(i));

            if(s.size() >= 26) bw.write("Y\n");
            else bw.write("N\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
