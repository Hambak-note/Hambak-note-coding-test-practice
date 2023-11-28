

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[] numCnt = new int[10];
    private static final int ZERO = 48;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for(int i = 0; i < input.length(); i++) {

            int cur = input.charAt(i) - ZERO;
            numCnt[cur]++;
        }

        int sixPlusNine = 0;
        int maxValue = 0;
        for(int i = 0; i < numCnt.length; i++) {

            if(i == 6 || i == 9) {
                sixPlusNine+=numCnt[i];
                continue;
            }
            maxValue = Math.max(numCnt[i], maxValue);
        }

        if(sixPlusNine % 2 > 0){
            sixPlusNine = (sixPlusNine / 2)+1;
        } else {
            sixPlusNine = sixPlusNine / 2;
        }

        maxValue = Math.max(maxValue, sixPlusNine);

        System.out.println(maxValue);
    }
}
