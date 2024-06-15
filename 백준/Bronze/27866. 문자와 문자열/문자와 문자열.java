import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int targetIndex = Integer.parseInt(br.readLine());

        System.out.println(str.charAt(targetIndex - 1));
    }
}