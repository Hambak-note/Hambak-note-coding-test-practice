import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static int testCase;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < testCase; i++) {

            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(startTime, endTime));
        }

        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                int endTimeComparison = Integer.compare(m1.endTime, m2.endTime);
                if(endTimeComparison == 0) {
                    return Integer.compare(m1.startTime, m2.startTime);
                }

                return endTimeComparison;
            }
        });

        int answer = 0;
        int curTime = 0;
        for(int i = 0; i < testCase; i++) {

            Meeting curMeeting = meetings.get(i);
            if(curTime > curMeeting.startTime) continue;
            answer++;
            curTime = curMeeting.endTime;
        }

        System.out.println(answer);

    }

    static class Meeting {

        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
