import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        
        int maxLength = 0;
        int n = S.length();
        
        for (int len = 2; len <= n; len += 2) {
            for (int start = 0; start <= n - len; start++) {
                String substring = S.substring(start, start + len);
                if (isLucky(substring)) {
                    maxLength = Math.max(maxLength, len);
                }
            }
        }
        
        System.out.println(maxLength);
    }
    
    private static boolean isLucky(String str) {
        int half = str.length() / 2;
        int leftSum = 0;
        int rightSum = 0;
        
        for (int i = 0; i < half; i++) {
            leftSum += str.charAt(i) - '0';
        }
        
        for (int i = half; i < str.length(); i++) {
            rightSum += str.charAt(i) - '0';
        }
        
        return leftSum == rightSum;
    }
}