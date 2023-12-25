

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> words = new HashSet<>();
        for(int i = 0; i < N; i++) {
            words.add(sc.next());
        }

        List<String> sortedWordList = sortByTwoCondition(words);

        for (String s : sortedWordList) {
            System.out.println(s);
        }


    }

    private static List<String> sortByTwoCondition(Set<String> wordList) {

        List<String> sortedWordList = new ArrayList<>(wordList);
        Collections.sort(sortedWordList, Comparator.comparing(String::length)
                .thenComparing(Comparator.naturalOrder()));

        return sortedWordList;
    }
}
