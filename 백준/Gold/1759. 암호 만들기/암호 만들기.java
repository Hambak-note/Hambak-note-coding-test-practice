import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int pwLen;
    private static int typeOfCharLen;
    private static char[] typeOfChar;
    private static int[] charPosArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        pwLen = Integer.parseInt(st.nextToken());
        typeOfCharLen = Integer.parseInt(st.nextToken());
        typeOfChar = br.readLine().replace(" ", "").toCharArray();
        charPosArr = new int[pwLen];

        Arrays.sort(typeOfChar);
        findPossiblePw(0, 0);

    }

    private static boolean isAeiou(char alphabet) {
        return alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u';
    }

    private static void findPossiblePw(int curPwLen, int charPos) {
        if(curPwLen == pwLen) {
            boolean flag = false;
            int aeiouCnt = 0;
            int notAeiouCnt = 0;
            for(int i = 0; i < pwLen; i++) {
                if(isAeiou(typeOfChar[charPosArr[i]])) aeiouCnt++;
                else notAeiouCnt++;
            }

            if(aeiouCnt >= 1 && notAeiouCnt >= 2) flag = true;

            if(flag) {
                for(int i = 0; i < pwLen; i++) {
                    System.out.print(typeOfChar[charPosArr[i]]);
                }
                System.out.println();
            }

            return;
        }

        for (int i = charPos; i < typeOfCharLen; i++) {
            charPosArr[curPwLen] = i;
            findPossiblePw(curPwLen+1, i+1);
        }
    }
}
