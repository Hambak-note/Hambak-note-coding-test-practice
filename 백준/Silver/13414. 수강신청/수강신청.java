import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int possibleNum;
    private static int waitListLen;

    private static Queue<String> signUpQueue = new LinkedList<>();
    private static HashMap<String, Integer> duplicateCheckMap = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        possibleNum = Integer.parseInt(st.nextToken());
        waitListLen = Integer.parseInt(st.nextToken());

        for (int i = 0; i < waitListLen; i++) {
            String signUp = br.readLine();
            signUpQueue.add(signUp);
            duplicateCheckMap.put(signUp, duplicateCheckMap.getOrDefault(signUp, 0)+1);
        }


        while (possibleNum > 0 && !signUpQueue.isEmpty()) {

            String signUp = signUpQueue.poll();
            int count = duplicateCheckMap.get(signUp);

            if(count > 1) {
                duplicateCheckMap.put(signUp, count - 1);
                continue;
            }

            System.out.println(signUp);
            --possibleNum;
        }


    }
}
