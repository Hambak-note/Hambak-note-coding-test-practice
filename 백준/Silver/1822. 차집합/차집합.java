import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int aCnt;
    private static int bCnt;
    private static int[] a;
    private static int[] b;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        aCnt = Integer.parseInt(st.nextToken());
        bCnt = Integer.parseInt(st.nextToken());

        a = new int[aCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aCnt; i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        b = new int[bCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bCnt; i++) b[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(b);

        List<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int element : a) {
            if(hasElement(element)) continue;
            answer.add(element);
        }

        System.out.println(answer.size());
        for (Integer element : answer) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static boolean hasElement(int findElement) {

        int left = 0;
        int right = bCnt-1;

        while(left <= right) {

            int mid = (left + right) / 2;

            if(b[mid] == findElement) return true;

            if(b[mid] < findElement) {
                left = mid + 1;
                continue;
            }

            right = mid - 1;
        }

        return false;
    }
}
