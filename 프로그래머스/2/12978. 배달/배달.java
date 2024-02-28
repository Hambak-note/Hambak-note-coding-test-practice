import java.util.Arrays;

import static java.lang.Math.*;

class Solution {

        private final int INF = 100000001;
        private int timeTable[][];

        private int from;
        private int to;
        private int time;


        public int solution(int N, int[][] road, int K) {
            int answer = 0;

            timeTable = new int[N+1][N+1];

            for(int i = 1; i < timeTable.length; i++) {
                Arrays.fill(timeTable[i], INF);
            }

            for(int i = 0; i < road.length; i++) {
                from = road[i][0];
                to = road[i][1];
                time = road[i][2];

                timeTable[from][to] = min(timeTable[from][to], time);
                timeTable[to][from] = min(timeTable[to][from], time);
            }

            for(int i = 1; i <= N; i++) {
                timeTable[i][i] = 0;
            }

            for(int mid = 1; mid <= N; mid++) {
                for(from = 1; from <= N; from++) {
                    for(to = 1; to <= N; to++) {
                        timeTable[from][to] = min(timeTable[from][to], timeTable[from][mid] + timeTable[mid][to]);
                    }
                }
            }

            for(to = 1; to <= N; to++) {
                if(timeTable[1][to] > K) continue;
                answer++;
            }

            return answer;
        }
    }