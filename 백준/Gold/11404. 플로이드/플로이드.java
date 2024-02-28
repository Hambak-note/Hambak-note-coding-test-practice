

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {

    private static final int INF = 10000000; //도달할 수 없다는 것을 표현하기 위한 값

    private static int n; //도시의 개수
    private static int m; //버스의 개수

    private static int from;
    private static int to;
    private static int cost;

    private static int distance[][];




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distance = new int[n+1][n+1];

        for(int i = 1; i < distance.length; i++) {
            Arrays.fill(distance[i], INF);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            distance[from][to] = min(distance[from][to], cost);
        }

        for(int i = 1; i <= n; i++) {
            distance[i][i] = 0;
        }

        for(int mid = 1; mid <= n; mid++) {
            for(from = 1; from <= n; from++ ) {
                for(to = 1; to <= n; to++) {
                    distance[from][to] = min(distance[from][to], distance[from][mid] + distance[mid][to]);
                }
            }
        }

        for(from = 1; from <= n; from++) {
            for(to = 1; to <= n; to++) {
                cost = distance[from][to];
                if(cost == INF) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(cost + " ");
            }
            System.out.println();
        }
    }
}
