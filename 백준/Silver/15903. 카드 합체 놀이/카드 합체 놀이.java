import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int cardCnt;
    private static int unionCnt;
    private static long answer = 0;
    private static PriorityQueue<Long> pq = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cardCnt = Integer.parseInt(st.nextToken());
        unionCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardCnt; i++) pq.add(Long.parseLong(st.nextToken()));

        while (unionCnt-- > 0 && pq.size() > 1) {

            long cur = pq.poll();
            long next = pq.poll();
            long plus = cur + next;

            pq.add(plus);
            pq.add(plus);
        }


        while(!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);

    }
}
