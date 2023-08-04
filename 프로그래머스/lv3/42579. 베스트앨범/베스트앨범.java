

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Solution {

    static class Music {
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genresPlayCountMap = calculateGenresPlayCount(genres, plays);

        ArrayList<String> mostPlyGenresList = sortMostPlayGenres(genresPlayCountMap);

        ArrayList<Music> pickList = pickTwoSongListInGenres(genres, plays, mostPlyGenresList);

        int[] answer = pickList.stream()
                .mapToInt(music -> music.idx)
                .toArray();

        return answer;
    }

 
    private static Map<String, Integer> calculateGenresPlayCount(String[] genres, int[] plays) {

        HashMap<String, Integer> genresPlayMap = new HashMap<>();
        IntStream.range(0, genres.length)
                .forEach(i -> genresPlayMap.put(genres[i], genresPlayMap.getOrDefault(genres[i], 0) + plays[i]));

        return genresPlayMap;
    }

    private static ArrayList<String> sortMostPlayGenres(Map<String, Integer> genresPlayCountMap) {

        ArrayList<String> mostPlayGenresList = genresPlayCountMap
                .entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey) 
                .collect(Collectors.toCollection(ArrayList::new));

        return mostPlayGenresList;
    }

    /***
     *
     * @param genres
     * @param plays
     * @param mostPlayGenresList
     * @return 전달된 리스트 중에서 장르당 최대 2곡을 선택하여 내림차순으로 정렬한 리스트
     */

    private static ArrayList<Music> pickTwoSongListInGenres(String[] genres, int[] plays
                                                        , ArrayList<String> mostPlayGenresList) {

        ArrayList<Music> pickList =
                mostPlayGenresList.stream()
                        .flatMap(genre -> IntStream.range(0, genres.length)
                                .filter(i -> genres[i].equals(genre))
                                .mapToObj(i -> new Music(genre, plays[i], i))
                                .sorted((o1, o2) -> o2.play - o1.play)
                                .limit(2)
                    )
                    .collect(Collectors.toCollection(ArrayList::new));

        return pickList;
    }
}
