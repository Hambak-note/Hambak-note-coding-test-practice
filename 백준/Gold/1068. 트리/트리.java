

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int deleteNodeIdx;
    private static Node[] nodes;
    private static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];

        for(int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
                continue;
            }
            nodes[parent].child.add(nodes[i]);
        }

        deleteNodeIdx = Integer.parseInt(br.readLine());

        answer = 0;

        if(deleteNodeIdx != root) {
            deleteNode(root);
            dfs(root);
        }

        System.out.println(answer);
    }

    private static void dfs(int idx) {

        if (nodes[idx].child.size() == 0) {
            answer++;
            return;
        }

        for(Node child : nodes[idx].child) {
            dfs(child.idx);
        }

    }

    private static void deleteNode(int idx) {
        for(Node child : nodes[idx].child) {
            if(child.idx == deleteNodeIdx) {
                nodes[idx].child.remove(child);
                return;
            }
            deleteNode(child.idx);
        }
    }

    static class Node {
        int idx;
        ArrayList<Node> child = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }

        public ArrayList<Node> getChild() {
            return child;
        }
    }
}
