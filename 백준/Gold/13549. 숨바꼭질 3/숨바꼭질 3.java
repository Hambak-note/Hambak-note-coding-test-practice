import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int subinLocation;
    private static int brotherLocation;
    private static int[] location = new int[200002];

    private static final int MAX_LOCATION = 200000;
    private static final int NOT_VISIT = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subinLocation = Integer.parseInt(st.nextToken());
        brotherLocation = Integer.parseInt(st.nextToken());

        Arrays.fill(location, NOT_VISIT);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(subinLocation);
        location[subinLocation] = 0;

        while (!dq.isEmpty()) {

            int cur = dq.pollFirst();
            if (2 * cur < MAX_LOCATION && location[2 * cur] == NOT_VISIT) {
                location[2 * cur] = location[cur];
                dq.addFirst(2*cur);
            }
            for(int next : new int[]{cur-1, cur+1}) {
                if(next < 0 || next >= MAX_LOCATION || location[next] != -1) continue;
                location[next] = location[cur] + 1;
                dq.addLast(next);
            }
        }

        System.out.println(location[brotherLocation]);
    }


}
