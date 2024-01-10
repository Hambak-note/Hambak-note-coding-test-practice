class Solution {

        public String[] letters = {
                "", "",
                "abc", "def", "ghi", "kjl",
                "mno", "pqrs", "tuv", "wxyz"};

        public List<String> result;
        public List<String> letterCombinations(String digits) {

            result = new ArrayList<>();

            if(digits.length() > 0) {
                calculateCombination(0, new StringBuilder(), digits.toCharArray());
            }

            return result;
        }

        private void calculateCombination(int pickCount, StringBuilder sb, char[] digitArr) {

            if (pickCount == digitArr.length) {
                result.add(sb.toString());
                return;
            }

            char[] letterArr = letters[Character.getNumericValue(digitArr[pickCount])].toCharArray();

            for (int i = 0; i < letterArr.length; i++) {
                sb.append(letterArr[i]);
                calculateCombination(pickCount + 1, sb, digitArr);
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }