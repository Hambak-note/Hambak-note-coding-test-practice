import java.io.*;

public class Main {

    private static String[] alphas = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for(String alpha : alphas) {
            if(input.contains(alpha)) input = input.replace(alpha, "!");
        }
        
        System.out.println(input.length());
    }
}
