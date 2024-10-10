import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private int n;
    private int choiceCnt;
    private int[][] gameDice;
    private List<Integer> aSumArr;
    private List<Integer> bSumArr;
    private int[][] dices;


    public int[] solution(int[][] dice) {


        dices = dice;
        n = dice.length;
        choiceCnt = n / 2;
        gameDice = dice;
        int[] answer = new int[choiceCnt];

        List<List<Integer>> result = new ArrayList<>();
        choiceDice(0, new ArrayList<>(), result);

        int max = 0;
        for (List<Integer> aDices : result) {


            makeABSumArr(aDices);
            Collections.sort(bSumArr);

            int count = 0;
            for(int i = 0; i < aSumArr.size(); i++) {

                int cur = aSumArr.get(i);

                int left = 0;
                int right = bSumArr.size() - 1;

                int index = Integer.MIN_VALUE;
                while(left <= right) {

                    int mid = (left + right) / 2;

                    if(bSumArr.get(mid) < cur) {
                        left = mid + 1;
                        index = Math.max(index, mid);
                    } else {
                        right = mid - 1;
                    }
                }

                if (index != Integer.MIN_VALUE) {
                    count += index + 1;
                }
            }

            if(max < count) {
                max = count;
                for(int i = 0; i < choiceCnt; i++) {
                    answer[i] = aDices.get(i) + 1;
                }
            }
        }
        
        return answer;
    }

    private void choiceDice(int index,
                            List<Integer> current,
                            List<List<Integer>> result) {

        if(current.size() == choiceCnt) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < n; i++) {
            current.add(i);
            choiceDice(i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    private void makeABSumArr(List<Integer> choiceDice) {
        aSumArr = new ArrayList<>();
        bSumArr = new ArrayList<>();

        int[][] aDiceInfos = new int[choiceCnt][6];
        int[][] bDiceInfos = new int[choiceCnt][6];

        int aIdx = 0;
        int bIdx = 0;
        for(int i = 0; i < n; i++) {
            if(choiceDice.contains(i)) {
                aDiceInfos[aIdx] = dices[i];
                aIdx++;
            } else {
                bDiceInfos[bIdx] = dices[i];
                bIdx++;
            }
        }


        makeSumArr(0, aDiceInfos, 0, aSumArr);
        makeSumArr(0, bDiceInfos, 0, bSumArr);

    }

    private void makeSumArr(int cnt,
                            int[][] dice,
                            int sum,
                            List<Integer> sumArr) {

        if(cnt == choiceCnt) {
            sumArr.add(sum);
            return;
        }

        for(int i = 0; i < 6; i++) {
            int newSum = sum + dice[cnt][i];
            makeSumArr(cnt+1, dice, newSum, sumArr);
        }
    }
}
