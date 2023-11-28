import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    private static LinkedList<Character> inputList = new LinkedList<>();
    private static int m;
    private static String command;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        m = Integer.parseInt(br.readLine());

        for(int i = 0; i < input.length(); i++) inputList.add(input.charAt(i));

        ListIterator<Character> iter = inputList.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }


        while(m-- > 0) {

            command = br.readLine();
            char c = command.charAt(0);


            switch(c) {
                case 'L':
                    if(iter.hasPrevious()) {
                        iter.previous();
                    }

                    break;
                case 'D':
                    if(iter.hasNext()) {
                        iter.next();
                    }

                    break;
                case 'B':
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    iter.add(t);

                    break;
                default:
                    break;
            }

        }

        for (char value :inputList){
            bw.write(value);
        }
        bw.flush();
        bw.close();
    }
}
