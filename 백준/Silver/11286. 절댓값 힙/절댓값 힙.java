import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int numberOfOp = Integer.parseInt(br.readLine());

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }

                return Integer.compare(o1[1], o2[1]);
            }
        };

        //[원래값 , 절대값]
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);

        for (int i = 0; i < numberOfOp; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                if(pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()[0]).append('\n');
                continue;
            }

            pq.add(new int[]{input, Math.abs(input)});
        }

        System.out.println(sb);
    }
}
