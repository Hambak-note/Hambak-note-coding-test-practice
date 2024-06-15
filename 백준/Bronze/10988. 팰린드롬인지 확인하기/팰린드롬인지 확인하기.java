import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for(int i = 0; i < input.length() / 2; i++) {

            char first = input.charAt(i);
            char second = input.charAt(input.length() - 1 - i);

            if(first != second) {
                System.out.println("0");
                return;
            }
        }

        System.out.println("1");
    }
}