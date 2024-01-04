import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int t;
    private static int n;
    private static int m;
    private static Queue<Integer> importance; //문서의 중요도
    private static Queue<Integer> index; //문서의 인덱스

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            importance = new LinkedList<>();
            index = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                importance.offer(Integer.parseInt(st.nextToken()));
                index.offer(j);
            }
            solveAndPrintResult();
        }
    }
    
    private static void solveAndPrintResult() {
        int count = 1;
        
        while(!importance.isEmpty()) {
            int maxImportance = Collections.max(importance);
            int curImportance = importance.poll();
            int curIndex = index.poll();
            
            if(curImportance == maxImportance) {
                if(curIndex == m) {
                    System.out.println(count);
                    break;
                }
                count++;
            }
            else {
                importance.offer(curImportance);
                index.offer(curIndex);
            }
        }
    }
}