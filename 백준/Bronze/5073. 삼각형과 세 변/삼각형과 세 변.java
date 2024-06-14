import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] bounList = new int[3];
            bounList[0] = Integer.parseInt(st.nextToken());
            bounList[1] = Integer.parseInt(st.nextToken());
            bounList[2] = Integer.parseInt(st.nextToken());

            if(isEnd(bounList)) break;

            Arrays.sort(bounList);
            if(!isTriangle(bounList)) {
                System.out.println("Invalid");
                continue;
            }

            System.out.println(compareBounList(bounList));
        }
    }

    private static String compareBounList(int[] bounList) {

        if(bounList[0] == bounList[1] && bounList[1] == bounList[2]) return "Equilateral";
        if(bounList[0] != bounList[1] && bounList[1] != bounList[2] && bounList[0] != bounList[2]) return "Scalene";

        return "Isosceles";
    }

    private static boolean isTriangle(int[] bounList) {

        int maxBoun = bounList[2];
        int twoBounSum = bounList[0] + bounList[1];

        if(maxBoun >= twoBounSum) return false;
        return true;
    }

    private static boolean isEnd(int[] bounList) {
        if(bounList[0] == 0 && bounList[1] == 0 && bounList[2] ==0) return true;
        return false;
    }
}