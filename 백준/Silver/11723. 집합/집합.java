import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int opCount = Integer.parseInt(br.readLine());

        List<Integer> valueList = new ArrayList<>();
        for(int i = 0; i < opCount; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String op = st.nextToken();
            if(op.equals("all")) {
                valueList = new ArrayList<>();
                for(int j = 0; j <= 20; j++) {
                    valueList.add(j);
                }
                continue;
            }
            if(op.equals("empty")) {
                valueList = new ArrayList<>();
                continue;
            }
            
            Integer value = Integer.parseInt(st.nextToken());
            if(op.equals("add")) {
                valueList.add(value);
                continue;
            }
            if(op.equals("remove")) {
                valueList.remove(value);
                continue;
            }
            if(op.equals("check")) {
                boolean hasValue = valueList.contains(value);
                if(hasValue) sb.append("1" + "\n");
                else sb.append("0" + "\n");
                continue;
            }
            if(op.equals("toggle")) {
                boolean hasValue = valueList.contains(value);
                if(hasValue) valueList.remove(value);
                else valueList.add(value);
            }
        }

        System.out.println(sb.toString());
    }
}