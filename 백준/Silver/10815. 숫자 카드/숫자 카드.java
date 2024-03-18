import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int numberCardCnt;
    private static long[] numberCards;
    private static int matchCardCnt;
    private static long[] matchCards;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberCardCnt = Integer.parseInt(br.readLine());
        numberCards = new long[numberCardCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberCardCnt; i++) {
            numberCards[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(numberCards);

        matchCardCnt = Integer.parseInt(br.readLine());
        matchCards = new long[matchCardCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < matchCardCnt; i++) {
            matchCards[i] = Long.parseLong(st.nextToken());
        }

        for (long matchCard : matchCards) {
            if(hasCard(matchCard)) System.out.print(1 + " ");
            else System.out.print(0 + " ");
        }
        System.out.println();
    }

    private static boolean hasCard(long findCard) {


        int left = 0;
        int right = numberCardCnt-1;


        while(left <= right) {

            int mid = (left + right) / 2;

            if(numberCards[mid] == findCard) return true;

            if(numberCards[mid] > findCard) {
                right = mid - 1;
                continue;
            }

            left = mid + 1;
        }

        return false;
    }
}
