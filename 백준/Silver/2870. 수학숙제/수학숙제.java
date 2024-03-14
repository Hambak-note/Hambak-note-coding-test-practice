import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList< String > stringArrayList = new ArrayList< String >();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            String tmp = "";
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) >= '0' && str.charAt(j) <= '9'){
                    tmp += str.charAt(j);
                }else{
                    if(tmp.length() == 0)continue;
                    String ret = delete0(tmp);
                    stringArrayList.add(ret);
                    tmp = "";
                }
            }
            if(tmp.length() > 0){
                stringArrayList.add(delete0(tmp));
            }
        }
        stringArrayList.sort(new StrComparator());
        for(String s : stringArrayList){
            System.out.println(s);
        }
    }

    public static String delete0(String s){
        StringBuilder sb = new StringBuilder(s);

        while (true){
            if(sb.charAt(0) == '0' && sb.length() != 1){
                sb.deleteCharAt(0);
            }else{
                break;
            }
        }

        return sb.toString();
    }
}

class StrComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() == o2.length()){
            return o1.compareTo(o2);
        }
        return o1.length() - o2.length();
    }
}