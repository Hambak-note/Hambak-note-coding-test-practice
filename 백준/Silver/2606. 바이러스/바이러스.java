

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int numberOfComputers;
    private static int numberOfConnections;
    private static Map<Integer, List<Integer>> connectionsMap = new HashMap();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfComputers = Integer.parseInt(br.readLine());
        numberOfConnections = Integer.parseInt(br.readLine());

        visited = new boolean[numberOfComputers + 1];

        initConnectionsMap(br);
        System.out.println(findVirusComputer());
    }

    private static void initConnectionsMap(BufferedReader br) throws IOException {
        StringTokenizer st = null;
        int key, value;

        for(int i = 0; i < numberOfConnections; i++) {
            st = new StringTokenizer(br.readLine());
            key = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            connectionsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
            connectionsMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
    }

    private static int findVirusComputer() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int infectedComputerCount = 0;

        while(!queue.isEmpty()) {

            int key = queue.poll();
            if(!connectionsMap.containsKey(key)) continue;

            List<Integer> computers = connectionsMap.get(key);
            for (Integer computer : computers) {
                if(!visited[computer]) {
                    queue.add(computer);
                    visited[computer] = true;
                    infectedComputerCount++;
                }
            }
        }

        return infectedComputerCount;
    }
}
