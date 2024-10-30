import java.io.*;

public class Main {
    
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        char c = input.charAt(0);
        int cnt = 0;
        for(int i = 0; i < input.length(); i++) {
            
            if(c == input.charAt(i)) cnt++;
            else break;
        }

        System.out.println(cnt);
    }
}
