import java.util.Stack;


class Solution {
        public String solution(int n, int k, String[] cmd) {

            int tableSize = n;
            int location = k;
            Stack<Integer> remove = new Stack<>();

            for (int i = 0; i < cmd.length; i++) {
                char curCmd = cmd[i].charAt(0);

                if (curCmd == 'D') {
                    location += Integer.parseInt(cmd[i].substring(2));
                    continue;
                }
                
                if(curCmd == 'U') {
                    location -= Integer.parseInt(cmd[i].substring(2));
                    continue;
                }

                if (curCmd == 'C') {
                    remove.add(location);
                    tableSize--;
                    if(location == tableSize) location--;
                    continue;
                }
                
                if(remove.pop() <= location) location++;
                tableSize++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tableSize; i++) {
                sb.append("O");
            }
            
            while(!remove.isEmpty()) {
                sb.insert(remove.pop().intValue(), "X");
            }
            
            return sb.toString();
        }
    }