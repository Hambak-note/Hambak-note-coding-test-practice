import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            xList.add(Integer.parseInt(st.nextToken()));
            yList.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(xList);
        Collections.sort(yList);
        
        int midX = xList.get(m/2);
        int midY = yList.get(m/2);
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer += Math.abs(xList.get(i) - midX);
            answer += Math.abs(yList.get(i) - midY);
        }
        
        System.out.println(answer);
    }
}