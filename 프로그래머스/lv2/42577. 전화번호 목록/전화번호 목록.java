import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
        public boolean solution(String[] phone_book) {

        Map<String, Integer> phoneNumberMap =
                Arrays.stream(phone_book)
                        .collect(HashMap::new, (map, key) -> map.put(key, 1), HashMap::putAll);

        boolean isPrefix = Arrays.stream(phone_book)
                .anyMatch(phone_num ->
                        IntStream.range(1, phone_num.length())
                                .anyMatch(j -> phoneNumberMap.containsKey(phone_num.substring(0, j)))
                );

        //접두사인 경우 false를 반환해야 하기 때문에 not 해준다.
        boolean answer = !isPrefix;

        return answer;
    }
    }