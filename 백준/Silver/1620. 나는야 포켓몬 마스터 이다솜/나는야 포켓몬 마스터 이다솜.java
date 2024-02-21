import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfPocket = Integer.parseInt(st.nextToken());
        int numberOfQuestion = Integer.parseInt(st.nextToken());

        Map<Integer, String> numberToName = new HashMap<>();
        Map<String, Integer> nameToNumber = new HashMap<>();

        for(int i = 1; i <= numberOfPocket; i++) {

            String name = br.readLine();
            numberToName.put(i, name);
            nameToNumber.put(name, i);
        }

        for(int i = 0; i < numberOfQuestion; i++) {

            String question = br.readLine();
            if(nameToNumber.containsKey(question)) {
                System.out.println(nameToNumber.get(question));
                continue;
            }

            Integer questionInt = Integer.parseInt(question);
            if(numberToName.containsKey(questionInt)) {
                System.out.println(numberToName.get(questionInt));
            }
        }
    }
}
