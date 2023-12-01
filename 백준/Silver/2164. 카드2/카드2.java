

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int n;
    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        initQueue();
        System.out.println(getLastCard());
    }

    private static void initQueue() {

        for(int i = 1; i <=n; i++) q.add(i);

    }

    private static int getLastCard() {

        while(q.size() > 1) {

            // 1. 제일 위의 카드를 버린다.
            q.poll();

            if(q.size() == 1) break;

            int topCard = q.poll();
            q.add(topCard);
        }

        return q.peek();
    }
}
