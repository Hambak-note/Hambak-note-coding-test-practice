import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            String input = br.readLine();
        
            if(input.equals("#")) break;

            int count = 0;
            for(int i = 0; i < input.length(); i++) {

                char cur = input.charAt(i);
                if(isAeiou(cur)) count++;
            }

            System.out.println(count);
        }
    }

    private static boolean isAeiou(char cur){
        if(cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') return true;
        if(cur == 'A' || cur == 'E' || cur == 'I' || cur == 'O' || cur == 'U') return true;
        return false;
    }
}