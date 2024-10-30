import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCnt = Integer.parseInt(bf.readLine());  
        List<String> textList = new ArrayList<String>(); 
        for (int i = 0; i < testCnt; i++) {
            int candidateCount = Integer.parseInt(bf.readLine()); 

            List<Integer> voteCntList = new ArrayList<Integer>(); 
            int voteTotalCnt = 0;
            int voteMajority = 0;

            for (int j = 0; j < candidateCount; j++) {
                int voteCnt = Integer.parseInt(bf.readLine());
                voteCntList.add(voteCnt);
                voteTotalCnt += voteCnt;
            }

            voteMajority = voteTotalCnt/2 + 1; 

            int topVote = 0;
            int who = 0;
            int same = 0;

            for (int j = 0; j < voteCntList.size(); j++) { 
                if(voteCntList.get(j) > topVote) {
                    topVote = voteCntList.get(j);
                    who = j + 1;
                    same = 0;
                }else if(voteCntList.get(j) == topVote) {
                    same += 1;
                }
            }

            String text = ""; 
            if(same != 0) {
                text = "no winner";
            }else {
                if(voteMajority <= voteCntList.get(who-1)) {
                    text = "majority winner " + who;
                }else {
                    text = "minority winner " + who;
                }
            }
            textList.add(text);

        }
        for (String string : textList) {
            System.out.println(string);
        }
    }
}
