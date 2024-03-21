import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] nums;
    private static int[][] s;
    private static List<List<Integer>> combinations = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        s = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++){
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        generateCombinations(n / 2, 1, new ArrayList<>());
        int minimumDifference = findMinimumDifference();
        System.out.println(minimumDifference);

    }

    private static int findMinimumDifference() {

        int startTeam;
        int linkTeam;
        int minimumDifference = Integer.MAX_VALUE;
        boolean[] used = new boolean[n + 1];
        List<Integer> notUsedNum = new ArrayList<>();

        for (List<Integer> combination : combinations) {

            startTeam = 0;
            linkTeam = 0;

            for (Integer num : combination) used[num] = true;
            for (int i = 1; i <= n; i++) {
                if(!used[i]) notUsedNum.add(i);
            }

            for(int i = 0; i < combination.size()-1; i++) {
                for(int j = i+1; j < combination.size(); j++) {
                    int startTeamNum1 = combination.get(i);
                    int startTeamNum2 = combination.get(j);
                    int linkTeamNum1 = notUsedNum.get(i);
                    int linkTeamNum2 = notUsedNum.get(j);

                    startTeam += (s[startTeamNum1][startTeamNum2] + s[startTeamNum2][startTeamNum1]);
                    linkTeam += (s[linkTeamNum1][linkTeamNum2] + s[linkTeamNum2][linkTeamNum1]);
                }
            }

            minimumDifference = Math.min(minimumDifference, Math.abs(startTeam - linkTeam));
            Arrays.fill(used, false);
            notUsedNum.clear();
        }

        return minimumDifference;
    }

    private static void generateCombinations(int numberToDraw, int start, List<Integer> current) {

        if(numberToDraw == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            generateCombinations(numberToDraw - 1, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
