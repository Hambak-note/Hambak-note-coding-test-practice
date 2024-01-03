import java.util.*;


class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            List<String> sortedStrList = makeSortedStrList(strs);
            return makeGroupAnagramList(sortedStrList, strs);
        }

        private List<String> makeSortedStrList(String[] strs) {
            List<String> sortedStrList = new ArrayList<>();
            for (String str : strs) {
                char[] strCharArray = str.toCharArray();
                Arrays.sort(strCharArray);
                String sortedStr = new String(strCharArray);;
                sortedStrList.add(sortedStr);
            }

            return sortedStrList;
        }

        private List<List<String>> makeGroupAnagramList(List<String> list, String[] strs) {

            Map<String, List<String>> map = new HashMap<>();
            List<List<String>> resultList = new ArrayList<>();

            for(int i = 0; i < strs.length; i++) {

                if(map.containsKey(list.get(i))) {
                    map.get(list.get(i)).add(strs[i]);
                    continue;
                }
                List<String> addList = new ArrayList<>();
                addList.add(strs[i]);
                map.put(list.get(i), addList);
            }

            for (String key : map.keySet()) {
                resultList.add(map.get(key));
            }

            return resultList;
        }
    }