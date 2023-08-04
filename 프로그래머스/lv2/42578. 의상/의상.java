import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        //부위별로 의상의 개수를 저장하는 맵
        Map<String, Integer> clothesCountMap = countClothesByPart(clothes);

        int answer = getNumberOfPossibilities(clothesCountMap);

        return answer;
    }

    private Map<String, Integer> countClothesByPart(String[][] clothes) {

        Map<String, Integer> clothesCountMap = new HashMap<>();

        Arrays.stream(clothes)
                .forEach(cloth ->
                        clothesCountMap.put(cloth[1], clothesCountMap.getOrDefault(cloth[1], 0)+1));

        return clothesCountMap;
    }

    private int getNumberOfPossibilities(Map<String, Integer> map) {

        int answer =
                map.values().stream()
                        //부위별 의상에 1개씩 더한다.
                        .mapToInt(count -> count + 1)
                        //초기값을 1로 설정하여 스트림의 요소들을 모두 곱한다.
                        .reduce(1, (a, b) -> a * b);

        //모두 입지 않은 경우 1가지를 빼준다.
        answer = answer-1;

        return answer;
    }
}
