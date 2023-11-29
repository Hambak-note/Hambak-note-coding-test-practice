

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int a; //수열의 크기
    private static int[] arr;
    private static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        a = Integer.parseInt(br.readLine());
        arr = new int[a];
        result = new int[a];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++) arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        for(int i = a-1; i >= 0; i--) {

            while(!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            if(stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();

            stack.push(arr[i]);
        }

        for(int i = 0; i < result.length; i++) sb.append(result[i]+" ");
        System.out.println(sb);
    }
}
