import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
   public static void main(String[] args) throws IOException {
       new Main().solution();
   }

   private int[] contestArray;

   private void solution() throws IOException {
       try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                
           contestArray = Arrays.stream(br.readLine().split(" "))
                               .mapToInt(Integer::parseInt)
                               .toArray();
           
           bw.write(contestOpen() + "\n");
           bw.flush();
       }
   }

   private int contestOpen() {
       int count = 0;
       
       while (true) {
           // Easy
           if (!useEasy()) break;
           
           // Medium
           if (!useMedium()) break;
           
           // Hard
           if (!useHard()) break;
           
           count++;
       }
       
       return count;
   }
   
   private boolean useEasy() {
       if (contestArray[0] > 0) {
           contestArray[0]--;
           return true;
       }
       if (contestArray[1] > 0) {
           contestArray[1]--;
           return true;
       }
       return false;
   }
   
   private boolean useMedium() {
       if (contestArray[2] > 0) {
           contestArray[2]--;
           return true;
       }
       if (contestArray[1] > 0 && contestArray[1] > contestArray[3]) {
           contestArray[1]--;
           return true;
       }
       if (contestArray[3] > 0 && contestArray[3] > contestArray[1]) {
           contestArray[3]--;
           return true;
       }
       if (contestArray[1] == contestArray[3] && contestArray[1] > 0) {
           contestArray[1]--;
           return true;
       }
       return false;
   }
   
   private boolean useHard() {
       if (contestArray[4] > 0) {
           contestArray[4]--;
           return true;
       }
       if (contestArray[3] > 0) {
           contestArray[3]--;
           return true;
       }
       return false;
   }
}