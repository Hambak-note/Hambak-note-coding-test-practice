

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    private static int numberOfCards;
    private static int answer;
    private static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfCards = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for(int i = 0; i < numberOfCards; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        answer = 0;
        while(pq.size() > 1) {

            int comparedCards = pq.poll() + pq.poll();
            answer += comparedCards;
            pq.add(comparedCards);
        }

        System.out.println(answer);

    }
}
