import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(maxHeap.size() == 0) {
                    bw.write("0\n");
                } else bw.write(maxHeap.poll() + "\n");
                continue;
            }

            maxHeap.add(input);
        }

        bw.flush();
        bw.close();
    }
}
