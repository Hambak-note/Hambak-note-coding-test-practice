import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Long> subA = new ArrayList<>();
        ArrayList<Long> subB = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            long sum = 0;
            for(int j = i; j < n; j++) {
                sum += A[j];
                subA.add(sum);
            }
        }
        
        for(int i = 0; i < m; i++) {
            long sum = 0;
            for(int j = i; j < m; j++) {
                sum += B[j];
                subB.add(sum);
            }
        }
        
        Collections.sort(subA);
        Collections.sort(subB);
        
        long result = 0;
        int left = 0;
        int right = subB.size() - 1;
        
        while(left < subA.size() && right >= 0) {
            long sum = subA.get(left) + subB.get(right);
            
            if(sum == T) {
                long leftCount = 0;
                long leftValue = subA.get(left);
                while(left < subA.size() && subA.get(left) == leftValue) {
                    leftCount++;
                    left++;
                }
                
                long rightCount = 0;
                long rightValue = subB.get(right);
                while(right >= 0 && subB.get(right) == rightValue) {
                    rightCount++;
                    right--;
                }
                
                result += leftCount * rightCount;
            }
            else if(sum < T) {
                left++;
            }
            else {
                right--;
            }
        }
        
        System.out.println(result);
    }
}