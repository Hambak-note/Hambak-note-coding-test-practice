import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    private static final char LEFT = '<';
    private static final char RIGHT = '>';
    private static final char BACK_SPACE = '-';


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {

            String input = br.readLine();
            LinkedList<Character> ll = new LinkedList<>();
            ListIterator<Character> iter = ll.listIterator();



            for(int i = 0; i < input.length(); i++) {

                char cur = input.charAt(i);

                if(cur == LEFT) {
                    if(iter.hasPrevious()) {
                        iter.previous();
                    }
                    continue;
                }

                if(cur == RIGHT) {
                    if(iter.hasNext()) {
                        iter.next();
                    }
                    continue;
                }

                if(cur == BACK_SPACE) {
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    continue;
                }

                iter.add(cur);
            }

            for(char value : ll) {
                bw.write(value);
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
    }
}
