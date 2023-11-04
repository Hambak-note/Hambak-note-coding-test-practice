import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();

        
        for(int i = 0; i < a.length(); i++) {
            char value = a.charAt(i);
            if(Character.isUpperCase(value)) {
                value = Character.toLowerCase(value);
            } else {
                value = Character.toUpperCase(value);
            }
            
            sb.append(value);
            
        }
        
        System.out.println(sb);
        
    }
}