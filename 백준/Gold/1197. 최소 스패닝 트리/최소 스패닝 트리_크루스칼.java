import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*정점의 개수*/
    private static int v;

    /*간선의 개수*/
    private static int e;

    /*간선에 대한 정보*/
    private static int[][] edgeInfo;

    private static int[] parent;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edgeInfo = new int[e][3];

        for(int i = 0; i < e; i++) {

            st = new StringTokenizer(br.readLine());

            //정점을 0번부터 시작하게 위해서 -1을 해줌
            edgeInfo[i][0] = Integer.parseInt(st.nextToken()) - 1;
            edgeInfo[i][1] = Integer.parseInt(st.nextToken()) - 1;
            edgeInfo[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edgeInfo, (int[] e1, int[] e2) -> e1[2] - e2[2]);

        parent = new int[v];

        for(int i = 0; i < v; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int[] edge : edgeInfo) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int fromParent = findParent(from);
            int toParent = findParent(to);

            if(fromParent == toParent) continue;

            result += cost;
            parent[toParent] = fromParent;
        }

        System.out.println(result);

    }

    static private int findParent(int node) {
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
}
