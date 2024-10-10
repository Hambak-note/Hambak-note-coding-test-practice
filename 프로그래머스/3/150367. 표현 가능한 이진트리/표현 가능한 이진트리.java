public class Solution {

    public int[] solution(long[] numbers) {

        int len = numbers.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {

            long cur = numbers[i];
            String binary = parseBinary(cur);
            boolean possibleBinaryTree = isPossibleBinaryTree(binary);
            if(possibleBinaryTree) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }


    private boolean isPossibleBinaryTree(String binary) {
        boolean isPossible = true;

        int mid = (binary.length() - 1) / 2;
        char root = binary.charAt(mid);
        String left = binary.substring(0, mid);
        String right = binary.substring(mid + 1);

        if(root == '0'
                && (left.charAt((left.length()-1)/2)=='1' || right.charAt((right.length()-1)/2)=='1')){
            return false;
        }
        
        if(left.length() >= 3) {
            isPossible = isPossibleBinaryTree(left);
            if(isPossible) isPossible = isPossibleBinaryTree(right);
        }

        return isPossible;
    }

    private String parseBinary(long number) {

        String binary = Long.toBinaryString(number);
        StringBuilder sb = new StringBuilder();
        if(!isFullBinaryTreeLength(binary.length())) {
            int zerosToAdd = nextFullBinaryTreeLength(binary.length()) - binary.length();
            for(int i = 0; i < zerosToAdd; i++) {
                sb.append('0');
            }
        }

        sb.append(binary);
        return sb.toString();
    }

    private boolean isFullBinaryTreeLength(int size) {

        if(size == 1) return true;

        int power = 1;
        while( power - 1 < size) power *= 2;

        return (power - 1) == size;
    }

    private int nextFullBinaryTreeLength(int size) {
        int power = 1;
        while(power - 1 < size) {
            power *= 2;
        }

        return power - 1;
    }
}
