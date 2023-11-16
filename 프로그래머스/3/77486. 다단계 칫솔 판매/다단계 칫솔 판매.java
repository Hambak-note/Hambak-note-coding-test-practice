import java.util.*;

class Solution {
    
    private static final int PROFIT_PER_UNIT = 100;
    
    static class SalesPerson {
        
        String name;
        SalesPerson parent;
        int sellAmount;
        
        public SalesPerson(String name, SalesPerson parent, int sellAmount) {
            this.name = name;
            this.parent = parent;
            this.sellAmount = sellAmount;
        }
        
        public void calMultiLevelAmount(int amount) {
            int parentAmount = amount / 10;
            this.sellAmount += (amount - parentAmount);
            if(this.parent != null && parentAmount >= 1) {
                this.parent.calMultiLevelAmount(parentAmount);
            }
        }
    }
    
    
    
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        Map<String, SalesPerson> childParentMap = new HashMap<>();
        
        for(String name : enroll) {
            childParentMap.put(name, new SalesPerson(name, null, 0));
        }
        
        for(int i = 0; i < referral.length; i++) {
            
            if(!referral[i].equals("-")) {
                childParentMap.get(enroll[i]).parent = childParentMap.get(referral[i]);
            }
        }
        
        for(int i = 0; i < seller.length; i++) {
            
            childParentMap.get(seller[i]).calMultiLevelAmount(amount[i]*PROFIT_PER_UNIT);
        }
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = childParentMap.get(enroll[i]).sellAmount;
        }
        
        
        return answer;
    }
}