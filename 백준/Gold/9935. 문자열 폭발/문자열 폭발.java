import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        StringBuilder stack = new StringBuilder();
        int bombLen = bomb.length();

        for(char ch : s.toCharArray()) {

            stack.append(ch);

            if(stack.length() >= bombLen &&
                stack.substring(stack.length() - bombLen).equals(bomb)) {
                stack.delete(stack.length() - bombLen, stack.length());
            }
        }

        System.out.println(stack.length() == 0 ? "FRULA" : stack.toString());
    }
}
