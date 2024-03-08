
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int citySize;
    private static int maxNumOfChicken;
    private static int minChickenDistance = Integer.MAX_VALUE;
    private static List<Position> chickenPositions;
    private static List<Position> housePositions;
    private static List<List<Position>> combinations;


    private static final int BLANK = 0;
    private static final int HOUSE = 1;
    private static final int CHICKEN = 2;

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int calDistance(Position position) {
            return Math.abs(this.x - position.x) + Math.abs(this.y - position.y);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        citySize = Integer.parseInt(st.nextToken());
        maxNumOfChicken = Integer.parseInt(st.nextToken());

        chickenPositions = new ArrayList<>();
        housePositions = new ArrayList<>();
        combinations = new ArrayList<>();

        for(int i = 0; i < citySize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < citySize; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur == HOUSE) housePositions.add(new Position(i, j));
                else if(cur == CHICKEN) chickenPositions.add(new Position(i, j));
            }
        }

        findClosedDown(0, 0, new ArrayList<>());
        findMinChickenDistance();

        System.out.println(minChickenDistance);

    }

    //폐업 시킬 치킨 집 고르기
    private static void findClosedDown(int count, int start, List<Position> current) {

        if(count == maxNumOfChicken) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < chickenPositions.size(); i++) {
            current.add(chickenPositions.get(i));
            findClosedDown(count+1, i+1, current);
            current.remove(current.size() - 1);
        }
    }


    //최소 치킨 거리 계산
    private static void findMinChickenDistance() {

        int curChickenDistance;

        for (List<Position> combination : combinations) {

            curChickenDistance = 0;
            for(Position housePosition : housePositions) {

                PriorityQueue<Integer> queue = new PriorityQueue<>();
                for(Position chickenPosition : combination) {

                    queue.add(housePosition.calDistance(chickenPosition));
                }

                curChickenDistance += queue.peek();
            }

            if(curChickenDistance < minChickenDistance) minChickenDistance = curChickenDistance;
        }
    }
}
