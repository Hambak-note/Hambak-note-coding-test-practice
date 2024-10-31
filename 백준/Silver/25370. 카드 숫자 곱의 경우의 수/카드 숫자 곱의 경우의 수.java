import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] arr;
    private static Set<Integer> set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        set = new HashSet<>();

        func(0);
        System.out.println(set.size());


    }

    private static void func(int k) {

        if(k == n) {
            int result = 1;
            for(int i = 0; i < n; i++) result *= arr[i];
            set.add(result);
            return;
        }

        for(int i = 1; i <= 9; i++) {
            arr[k] = i;
            func(k+1);
        }
    }
}
