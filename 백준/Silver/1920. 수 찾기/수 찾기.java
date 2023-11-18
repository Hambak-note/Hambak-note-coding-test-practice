

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int m;
    static int[] nArr;
    private final static int EXIST = 1;
    private final static int NOT_EXIST = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            System.out.println(binarySearch(Integer.parseInt(st.nextToken())));
        }



    }

    static int binarySearch(int target) {

        int mid = n /2;
        int left = 0;
        int right = n-1;
        while(left <= right) {

            if(nArr[mid] == target) return EXIST;
            else if(nArr[mid] > target) right = mid-1;
            else left = mid+1;

            mid = (left+right) / 2;
        }

        return NOT_EXIST;

    }
}
