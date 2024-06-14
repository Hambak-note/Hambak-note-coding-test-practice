import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfYaksu = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] yaksuArr = new int[numberOfYaksu];
        for(int i = 0; i < numberOfYaksu; i++) {
            yaksuArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(yaksuArr);
        if(yaksuArr.length == 1) {
            System.out.println(yaksuArr[0] * yaksuArr[0]);
            return;
        }

        System.out.println(yaksuArr[0] * yaksuArr[yaksuArr.length - 1]);
        
    }
}