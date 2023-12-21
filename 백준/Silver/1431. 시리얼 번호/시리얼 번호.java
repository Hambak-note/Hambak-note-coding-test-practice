import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static TreeMap<Integer, List<String>> input = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {

            //길이별 값 입력
            String input = br.readLine();
            addValue(input);
        }

        //길이 같은 경우에 2가지 조건에 의한 정렬
        sortAndPrintByTwoCondition();
    }

    private static void addValue(String value) {
        int length = value.length();
        input.computeIfAbsent(length, k -> new ArrayList<>()).add(value);
    }

    private static void sortAndPrintByTwoCondition() {

        StringBuilder sb = new StringBuilder();

        for (Integer key : input.keySet()) {
            if(input.get(key).size() == 1) {
                sb.append(input.get(key).get(0)).append('\n');
                continue;
            }

            List<String> list = input.get(key);
            Collections.sort(list,
                    Comparator
                            .comparingInt(Main::calculateSum)
                            .thenComparing(Comparator.naturalOrder()));

            for (String str : list) {
                sb.append(str).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static int calculateSum(String str){
        int sum = 0;
        for(char c : str.toCharArray()) {
            if(Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }

        return sum;
    }
}
