import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] first = st.nextToken().toCharArray();
        char[] second = st.nextToken().toCharArray();

        int reversedFirst = reverseAndMapToInt(first);
        int reversedSecond = reverseAndMapToInt(second);

        if(reversedFirst > reversedSecond) System.out.println(reversedFirst);
        else System.out.println(reversedSecond);
    }

    private static int reverseAndMapToInt(char[] charList) {

        for (int i = 0; i < charList.length / 2; i++) {
            char temp = charList[i];
            charList[i] = charList[charList.length - 1 - i];
            charList[charList.length - 1 - i] = temp;
        }

        String reversedStr = new String(charList);
        int mapToInt = Integer.parseInt(reversedStr); 
        
        return mapToInt;
    }
}