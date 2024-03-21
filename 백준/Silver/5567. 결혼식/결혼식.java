
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int numberOfFriend;
    private static int listLen;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfFriend = Integer.parseInt(br.readLine());
        listLen = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Integer>[] friendList = new ArrayList[numberOfFriend+1];
        for(int i = 1; i < friendList.length; i++) {
            friendList[i] = new ArrayList<>();
        }

        for (int i = 0; i < listLen; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            friendList[node1].add(node2);
            friendList[node2].add(node1);
        }

        boolean[] invited = new boolean[numberOfFriend + 1];

        int result = 0;
        for (Integer friend : friendList[1]) {

            for (Integer friendAndFriend : friendList[friend]) {
                if(invited[friendAndFriend]) continue;
                invited[friendAndFriend] = true;
            }

            invited[friend] = true;
        }
        invited[1] = false;

        for (boolean b : invited) {
            if(b) result++;
        }


        System.out.println(result);
    }
}
