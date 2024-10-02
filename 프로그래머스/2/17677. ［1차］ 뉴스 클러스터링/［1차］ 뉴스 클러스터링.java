import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;

            str1 = str1.toUpperCase();
            str2 = str2.toUpperCase();

            List<String> splitStr1 = new ArrayList<String>();
            List<String> splitStr2 = new ArrayList<String>();

            int numberOfIntersections = 0;
            int numberOfUnions = 0;
            double jacquardSimilarity;


            //불필요 문자 제거 및 문자열 나누기
            String subStr;
            for(int i = 0; i < str1.length()-1; i++){
                subStr = str1.substring(i, i+2);
                if(Pattern.matches("^[A-Z]*$", subStr)){
                    splitStr1.add(subStr);
                }
            }

            System.out.println(splitStr1.toString());

            for(int i = 0; i < str2.length()-1; i++){
                subStr = str2.substring(i, i+2);
                if(Pattern.matches("^[A-Z]*$", subStr)){
                    splitStr2.add(subStr);
                }
            }

            if(splitStr1.isEmpty() && splitStr2.isEmpty()) return 65536;

            int str1Length = str1.length();
            String tempStr;
            for(int i = 0; i < splitStr1.size(); i++){
                tempStr = splitStr1.get(i);
                if(splitStr2.contains(tempStr)){
                    splitStr2.remove(tempStr);
                    numberOfIntersections++;
                }
                numberOfUnions++;
            }


            numberOfUnions = numberOfUnions +  splitStr2.size();
            jacquardSimilarity = (double)numberOfIntersections / numberOfUnions;
            answer = (int) Math.floor(jacquardSimilarity * 65536);

            return answer;
        }
    }