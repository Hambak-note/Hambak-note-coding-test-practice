
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{Integer.MAX_VALUE, 0});

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {

            int h = Integer.parseInt(st.nextToken());
            while(stack.peek()[0] < h) {
                stack.pop();
            }

            sb.append(stack.peek()[1]+" ");
            stack.push(new int[]{h, i});
        }
        System.out.println(sb);
    }
}
