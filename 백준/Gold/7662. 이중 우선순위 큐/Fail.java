/*
* 우선순위 기준을 다르게 한 2개의 우선순위 큐로 문제를 풀이 했을 때 시간 초과가 발생하여 실패
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Fail {

    static int t; //입력 데이터의 수
    static int k; //연산의 개수

    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;

    private final static String DEL_MAX = "D 1";
    private final static String DEL_MIN = "D -1";
    private final static String EMPTY = "EMPTY";


    public static void main(String[] args) throws IOException {

        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            k = Integer.parseInt(br.readLine());
            for(int i = 0; i < k; i++) {

                String command = br.readLine();
                if(command.equals(DEL_MIN) && !minHeap.isEmpty()){
                    Integer poll = minHeap.poll();
                    maxHeap.remove(poll);
                    continue;
                }

                if(command.equals(DEL_MAX) && !maxHeap.isEmpty()) {
                    Integer poll = maxHeap.poll();
                    minHeap.remove(poll);
                    continue;
                }

                if(command.charAt(0) == 'I') {
                    int input = Integer.parseInt(command.substring(2));
                    minHeap.add(input);
                    maxHeap.add(input);
                }
            }

            if(minHeap.isEmpty()) System.out.println(EMPTY);
            else System.out.println(maxHeap.poll() + " " + minHeap.poll());
        }
    }
}
