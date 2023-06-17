import java.util.*;

class Solution {
    
    private static final int[] DISCOUNT_RATE = {10, 20, 30, 40};
    private static int EMOTICON_PLUS_SERVICE_SUBSCRIBER;
    private static int EMOTICON_SALES;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int startRateIndex = 0;
        int[] rates = new int[emoticons.length];
        int[] answer;
        
        recursiveFunctionForCalculateAnswer(emoticons, users, startRateIndex, rates);
        
        answer = new int[]{EMOTICON_PLUS_SERVICE_SUBSCRIBER, EMOTICON_SALES};
        
        return answer;
    }
    
    
    private void recursiveFunctionForCalculateAnswer(int[] emoticons, int[][] users, int rateIndex, int[] rates) {
        
        if(rateIndex == emoticons.length) {
            udapteMaximumResult(emoticons, users, rates);
            return;
        }
        
        
        for(int rate : DISCOUNT_RATE) {
            
            rates[rateIndex] = rate;
            recursiveFunctionForCalculateAnswer(emoticons, users, rateIndex + 1, rates);
        }
        
    }
    
    private void udapteMaximumResult ( int[] emoticons, int[][] users, int[] rates) {
        
        int serviceSubscriber = 0;
        int totalEmoticonSales = 0;
        
        for ( int[] user : users ) {
            
            int emticonSales = 0;
            int userRate = user[0];
            int userPrice = user[1];
            
            for(int i = 0; i < rates.length; i++ ) {
                
                if( rates[i] >= userRate ) {
                    
                    emticonSales += emoticons[i] * (100-rates[i]) / 100;
                }
                
                if(emticonSales >= userPrice) {
                    serviceSubscriber += 1;
                    emticonSales = 0;
                    break;
                }
            }
            
               totalEmoticonSales += emticonSales;
            
        }
        
        if( serviceSubscriber > EMOTICON_PLUS_SERVICE_SUBSCRIBER ) {
            EMOTICON_PLUS_SERVICE_SUBSCRIBER = serviceSubscriber;
            EMOTICON_SALES = totalEmoticonSales;
            return;
        }
        
        if( serviceSubscriber == EMOTICON_PLUS_SERVICE_SUBSCRIBER ) {
            EMOTICON_SALES = Math.max(totalEmoticonSales, EMOTICON_SALES);
        }
        
    }

    
}