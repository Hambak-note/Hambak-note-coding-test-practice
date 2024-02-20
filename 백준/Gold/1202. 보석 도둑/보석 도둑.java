
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int m = scan.nextInt();
            int v = scan.nextInt();
            list.add(new int[]{m, v});
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]); 

        int[] weight = new int[k];
        for(int i = 0; i < k; i++) {
            weight[i] = scan.nextInt();
        }
        Arrays.sort(weight);

        long total = 0;
        int listIdx = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]); 
        for(int i = 0; i < k; i++) {
            while(listIdx < n && list.get(listIdx)[0] <= weight[i]) {
                int[] current = list.get(listIdx++);
                pq.add(new int[]{current[0], current[1]});
            }
            if(!pq.isEmpty()) total += pq.poll()[1];
        }
        System.out.println(total);
    }
}
