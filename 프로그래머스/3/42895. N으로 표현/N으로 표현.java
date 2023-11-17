import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
        
        List<Set<Integer>> nListSet = new ArrayList<>();
        
        for(int i = 0; i < 9; i++) {
            nListSet.add(new HashSet<>());
        }
        
        nListSet.get(1).add(N);
        
        for(int i = 2; i < 9; i++) {
            
            Set<Integer> nSet = nListSet.get(i);
            
            for(int j = 1; j <= i; j++) {
                
                Set<Integer> preNumSet = nListSet.get(j);
                Set<Integer> postNumSet = nListSet.get(i-j);
                
                for(int preNum : preNumSet) {
                    
                    for(int postNum : postNumSet) {
                        
                        nSet.add(preNum + postNum);
                        nSet.add(preNum - postNum);
                        nSet.add(preNum * postNum);
                        
                        if(preNum != 0 && postNum != 0) nSet.add(preNum / postNum);
                    }
                }
            }
            
            nSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for(Set<Integer> nSet : nListSet) {
            
            if(nSet.contains(number)) return nListSet.indexOf(nSet);
        }
        
        return -1;
    }
}