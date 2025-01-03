import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static int t, n;
    private static List<Integer> tuple;

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());


        while(t-- > 0) {

            n = Integer.parseInt(br.readLine());
            tuple = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

            boolean isZero = false;
            boolean isLoop = false;
            int count = 0;
            while(!isZero && !isLoop) {

                if(count >= 1000) {
                    isLoop = true;
                    continue;
                }

                if(isAllNumberEqual(tuple)) {
                    isZero = true;
                    continue;
                }

                tuple = makeNextTuple(tuple);
                count++;
            }

            if(isLoop) {
                System.out.println("LOOP");
            }

            if(isZero) {
                System.out.println("ZERO");
            }
        }
    }

    private static List<Integer> makeNextTuple(List<Integer> tuple) {
        List<Integer> newTuple = IntStream.range(0, tuple.size() - 1)
                .mapToObj(i -> Math.abs(tuple.get(i) - tuple.get(i + 1)))
                .collect(Collectors.toList());

        newTuple.add(Math.abs(tuple.get(n-1) - tuple.get(0)));
        return newTuple;
    }

    private static Boolean isAllNumberEqual(List<Integer> tuple) {
        return tuple.stream().allMatch(x -> x.equals(tuple.get(0)));
    }
}
