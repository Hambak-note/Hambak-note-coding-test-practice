import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       int n = Integer.parseInt(st.nextToken());
       int s = Integer.parseInt(st.nextToken());
       int d = Integer.parseInt(st.nextToken());
       int f = Integer.parseInt(st.nextToken());
       int b = Integer.parseInt(st.nextToken());
       int k = Integer.parseInt(st.nextToken());
       
       boolean[] visited = new boolean[n + 1];
       boolean[] police = new boolean[n + 1];
       
       if (k > 0) {
           st = new StringTokenizer(br.readLine());
           for (int i = 0; i < k; i++) {
               police[Integer.parseInt(st.nextToken())] = true;
           }
       }
       
       Queue<Integer> queue = new LinkedList<>();
       queue.offer(s);
       visited[s] = true;
       int count = 0;
       
       boolean possible = false;
       
       while (!queue.isEmpty()) {
           int size = queue.size();
           
           for (int i = 0; i < size; i++) {
               int current = queue.poll();
               
               if (current == d) {
                   possible = true;
                   queue.clear();
                   break;
               }
               
               int forward = current + f;
               int backward = current - b;
               
               if (forward <= n && !visited[forward] && !police[forward]) {
                   visited[forward] = true;
                   queue.offer(forward);
               }
               
               if (backward > 0 && !visited[backward] && !police[backward]) {
                   visited[backward] = true;
                   queue.offer(backward);
               }
           }
           
           if (!queue.isEmpty()) count++;
       }
       
       if (possible) System.out.println(count);
       else System.out.println("BUG FOUND");
   }
}