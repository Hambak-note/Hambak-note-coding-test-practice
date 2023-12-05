

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static int t; //테스트 케이스
    private static boolean isReversed = false;
    private static Deque<Integer> deque;
    private static final char REVERSE = 'R';
    private static final char DROP = 'D';


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {

            String commands = br.readLine();
            int arrCnt = Integer.parseInt(br.readLine());
            String input = br.readLine();
            boolean isError  = false;

            extractNumbers(input);

            for(int i = 0; i < commands.length(); i++) {

                char command = commands.charAt(i);
                isError = executeCommand(command);
                if(isError) break;
            }
            if(isError) System.out.println("error");
            else makePrintStringAndPrint(isReversed);
            isReversed = false;
        }
    }

    private static void extractNumbers(String input) {

        deque = new ArrayDeque<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()) {
            deque.add(Integer.parseInt(matcher.group()));
        }
    }

    private static boolean executeCommand(char command) {

        if(command == REVERSE) {
            isReversed = !isReversed;
            return false;
        }

        if(command == DROP) {

            if(deque.isEmpty()) return true;

            if(!isReversed) {
                deque.pollFirst();
                return false;
            }
            if(isReversed) {
                deque.pollLast();
            }
        }
        return false;
    }

    public static void makePrintStringAndPrint(boolean isReversed) {

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        if(deque.size() > 0) {

            if(!isReversed) {

                sb.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else {
                sb.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');
        System.out.print(sb);
    }
}
