import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        boolean isContain = false;
        String input = "";
        while(tc-- > 0 && !isContain) {

            input = br.readLine();
            isContain = input.contains("S");
        }

        System.out.println(input);
    }
}
