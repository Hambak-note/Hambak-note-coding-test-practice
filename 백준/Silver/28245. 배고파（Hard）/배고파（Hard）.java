import java.io.*;
import java.util.*;

class index{
    int x;
    int y;
    public index(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder("");
        ArrayList<Long> arr=new ArrayList<>();
        ArrayList<Long> sum=new ArrayList<>();
        HashMap<Long,index> map=new HashMap<>();
        int n=Integer.parseInt(br.readLine());
        long temp=0;
        for(long i=1; i<=1000000000000000000l; i*=2){
            arr.add(i);
        }

        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<arr.size(); j++){
                temp=arr.get(i)+arr.get(j);
                if(map.get(temp)==null){
                    sum.add(temp);
                    map.put(temp,new index(i,j));
                }
            }
        }
        Collections.sort(sum);
        for(int i=0; i<n; i++){
            long find=Long.parseLong(br.readLine());
            for(int j=1; j<sum.size(); j++){
                if(sum.get(j)>find){
                    temp= sum.get(j)-find >= find-sum.get(j-1) ? sum.get(j-1) : sum.get(j);
                    break;
                }
            }
            bw.write(map.get(temp).x+" "+map.get(temp).y+"\n");
        }
        bw.flush();
    }

}