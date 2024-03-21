import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int TEAM_NAME = 0;
    private static final int MEMBER_NAME = 1;

    private static int numberOfGirlGroup;
    private static int numberOfQuiz;

    private static Map<String, List<String>> teamMap = new HashMap<>();
    private static Map<String, String> memberMap = new HashMap<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfGirlGroup = Integer.parseInt(st.nextToken());
        numberOfQuiz = Integer.parseInt(st.nextToken());

        for(int i = 0; i < numberOfGirlGroup; i++) {
            String teamName = br.readLine();
            int numberOfMember = Integer.parseInt(br.readLine());
            List<String> members = new ArrayList<>();

            for (int j = 0; j < numberOfMember; j++) {
                String memberName = br.readLine();
                members.add(memberName);
                memberMap.put(memberName, teamName);
            }
            Collections.sort(members);
            teamMap.put(teamName, members);
        }

        for (int i = 0; i < numberOfQuiz; i++) {

            String quiz = br.readLine();
            int quizCategory = Integer.parseInt(br.readLine());

            if(quizCategory == TEAM_NAME) {
                List<String> members = teamMap.get(quiz);
                for (String member : members) {
                    System.out.println(member);
                }
                continue;
            }

            System.out.println(memberMap.get(quiz));
        }
    }
}
