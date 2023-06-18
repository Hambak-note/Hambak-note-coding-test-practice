import java.util.*;
import java.util.stream.IntStream;


class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        
        Stack<Integer> deliveryStack = convertArrayToStack(deliveries);
        Stack<Integer> pickupStack = convertArrayToStack(pickups);
        
        
        answer = doDeliveryAndPickup(deliveryStack, pickupStack, cap);
        
        return answer;
    }
    
    private Stack<Integer> convertArrayToStack(int[] inputArray) {
        
        int numberOfHouses = inputArray.length;
        Stack<Integer> convertedStack = new Stack<>();
        
        for(int i = 0; i < numberOfHouses; i++) {
            
            for(int j = 0; j < inputArray[i]; j++) {
                
                convertedStack.push(i+1);
            }
        }
        
        return convertedStack;
    }
    
    private long doDeliveryAndPickup(Stack<Integer> deliveryStack, Stack<Integer> pickupStack, int cap) {
        
        long totalDistance = 0;
        
        while( !deliveryStack.isEmpty() || !pickupStack.isEmpty() ) {
            
            int deliveryDestination = deliveryStack.isEmpty() ? 0 : deliveryStack.peek();
            int pickupDestination = pickupStack.isEmpty() ? 0 : pickupStack.peek();
            
            IntStream.range(0, cap).forEach(i -> {
                if(!deliveryStack.isEmpty()) deliveryStack.pop();
                if(!pickupStack.isEmpty()) pickupStack.pop();
            });
        
            if(deliveryDestination > pickupDestination) {
                
                totalDistance += deliveryDestination*2L;
                continue;
            }
            
            totalDistance += pickupDestination*2L;
        }
        
        return totalDistance;
    }
    
}