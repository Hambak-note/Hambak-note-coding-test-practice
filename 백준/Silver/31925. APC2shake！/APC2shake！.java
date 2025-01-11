import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        List<Participant> qualified = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            String name = info[0];
            String status = info[1];
            String icpc = info[2];
            int shake = Integer.parseInt(info[3]);
            int apc = Integer.parseInt(info[4]);
            
            if (status.equals("jaehak") &&          
                icpc.equals("notyet") &&            
                (shake > 3 || shake == -1)) {       
                qualified.add(new Participant(name, apc));
            }
        }
        
        Collections.sort(qualified, (p1, p2) -> p1.apc - p2.apc);
        
        int selectedCount = Math.min(10, qualified.size());
        List<String> selected = new ArrayList<>();
        

        for (int i = 0; i < selectedCount; i++) {
            selected.add(qualified.get(i).name);
        }
        
        Collections.sort(selected);
        
        bw.write(selectedCount + "\n");
        for (String name : selected) {
            bw.write(name + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    static class Participant {
        String name;
        int apc;
        
        Participant(String name, int apc) {
            this.name = name;
            this.apc = apc;
        }
    }
}