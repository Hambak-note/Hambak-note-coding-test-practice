import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0;

        String[] splitMinus = input.split("-");

        String[] splitPlus = splitMinus[0].split("\\+");
        for (String plus : splitPlus) {
            answer += Integer.parseInt(plus);
        }

        for(int i = 1; i < splitMinus.length; i++) {

            splitPlus = splitMinus[i].split("\\+");
            for (String plus : splitPlus) {
                answer -= Integer.parseInt(plus);
            }
        }

        System.out.println(answer);
    }
}
