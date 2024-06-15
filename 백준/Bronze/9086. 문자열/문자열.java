import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < testCase; i++) {

            String input = br.readLine();
            char first = input.charAt(0);
            char last = input.charAt(input.length()-1);
            sb.append(first);
            sb.append(last);
            sb.append("\n");
        }

        System.out.println(sb.toString());
        
    }
}