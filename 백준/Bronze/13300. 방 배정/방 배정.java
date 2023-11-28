
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int k;

    private static int[][] students = new int[7][2];
    private static final int GIRL = 0;
    private static final int BOY = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            students[grade][sex]++;
        }

        int roomCnt = 0;

        for(int i = 1; i < students.length; i++) {

            int girlCnt = students[i][GIRL];
            int boyCnt = students[i][BOY];

            if(girlCnt % k > 0) {
                roomCnt+= ((girlCnt/k) +1);
            } else {
                roomCnt += (girlCnt/k);
            }

            if(boyCnt % k > 0) {
                roomCnt+= ((boyCnt/k) +1);
            } else {
                roomCnt += (boyCnt/k);
            }
        }

        System.out.println(roomCnt);
    }
}
