class Solution {

        public int solution(String[] board) {

            int oCount = countCharInArray('O', board);
            int xCount = countCharInArray('X', board);

            if(xCount > oCount) return 0;
            if(oCount - xCount > 1) return 0;

            if(isWin('O', board)) {
                if(oCount == xCount) return 0;
            }

            if(isWin('X', board)) {
                if(oCount == xCount+1) return 0;
                
            }
            
            return 1;
        }

        private int countCharInArray(char input, String[] board) {

            int count = 0;

            for(int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length(); j++) {
                    if(board[i].charAt(j) == input) count++;
                }
            }

            return count;
        }

        private boolean isWin(char input, String[] board) {

            //가로 탐색
            for(int i = 0; i < board.length;  i++) {
                if(board[i].charAt(0) == input
                        && board[i].charAt(1) == input
                        && board[i].charAt(2) == input) {
                    return true;
                }
            }

            //세로 탐색
            for(int i = 0; i < board.length ; i++) {
                if(board[0].charAt(i) == input
                        && board[1].charAt(i) == input
                        && board[2].charAt(i) == input) {
                    return true;
                }
            }

            //대각 탐색
            char base = board[1].charAt(1);
            if(board[0].charAt(0) == input
                    && board[1].charAt(1) == input
                    && board[2].charAt(2) == input) return true;

            if(board[0].charAt(2) == input
                    && board[1].charAt(1) == input
                    && board[2].charAt(0) == input) return true;

            return false;
        }


    }