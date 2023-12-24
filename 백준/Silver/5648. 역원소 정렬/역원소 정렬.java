

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        long arr[] = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = reverseInteger(sc.next());
        }

        Arrays.sort(arr);
        for (long value : arr) {
            sb.append(value).append('\n');
        }

        System.out.println(sb);
    }

    private static long reverseInteger(String value) {

        StringBuilder sb = new StringBuilder();
        for(int i = value.length()-1; i >= 0; i--) {
            sb.append(value.charAt(i));
        }

        return Long.parseLong(sb.toString());
    }
}
