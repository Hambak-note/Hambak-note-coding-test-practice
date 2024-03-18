import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int numberOfTrucks;
    private static int bridgeLen;
    private static int maxLoadOnTheBridge;

    private static int[] bridge;
    private static Queue<Integer> trucks;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberOfTrucks = Integer.parseInt(st.nextToken());
        bridgeLen = Integer.parseInt(st.nextToken());
        bridge = new int[bridgeLen];
        maxLoadOnTheBridge = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trucks = new LinkedList<>();
        for (int i = 0; i < numberOfTrucks; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        do {
            int curLoadOnTheBridge = calculateLoadOnTheBridge();
            if(curLoadOnTheBridge <= maxLoadOnTheBridge) {
                curLoadOnTheBridge -= bridge[bridgeLen - 1];
                moveTruck();
                if(!trucks.isEmpty() && (curLoadOnTheBridge+trucks.peek()) <= maxLoadOnTheBridge) {
                    bridge[0] = trucks.poll();
                }
            }
            ++answer;
        } while(!isEmptyBridge());


        System.out.println(answer);
    }

    private static int calculateLoadOnTheBridge() {
        int loadOnTheLeg = 0;
        for (int i = 0; i < bridgeLen; i++) {
            loadOnTheLeg += bridge[i];
        }

        return loadOnTheLeg;
    }

    private static void moveTruck() {
        for (int i = bridgeLen - 1; i > 0; --i) {
            bridge[i] = bridge[i - 1];
        }
        bridge[0] = 0;
    }

    private static boolean isEmptyBridge(){
        for (int i = 0; i < bridgeLen; i++) {
            if(bridge[i] != 0) return false;
        }
        return true;
    }
}
