import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        List<String> words = splitWord(paragraph, banned);
        return countMostCommonWord(words);
        
    }
    
    private List<String> splitWord(String paragraph, String[] banned) {
            String[] words = paragraph
                    .replaceAll("[^a-zA-Z]", " ")
                    .toLowerCase()
                    .split("\\s+");

            List<String> filteredWords = new ArrayList<>();

            Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

            for(String word : words) {
                if( !bannedSet.contains(word)) {
                    filteredWords.add(word);
                }
            }

            return filteredWords;
        }

        private String countMostCommonWord(List<String> words) {

            Map<String, Integer> wordFrequency = new HashMap<>();

            for(String word : words) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0)+1);
            }

            int maxFrequency = 0;
            String mostCommonWord = null;

            for (String key : wordFrequency.keySet()) {
                int curFrequency = wordFrequency.get(key);
                if(maxFrequency < curFrequency) {
                    maxFrequency = curFrequency;
                    mostCommonWord = key;
                }
            }

            return mostCommonWord;
        }
}