import java.util.*;
/*
* today: 오늘 날짜
* terms: 약관의 유효기간
* privacies: 수집된 개인 정보
*/



class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        HashMap<String, Integer> termsMap = changeTermsToMap(terms);
        HashMap<Integer, String> destructionDateMap = getDestuctionDate(termsMap, privacies);
        int[] answer = getPersonalInformationNumberToBeDestroyted(today, destructionDateMap);
        
        return answer;
    }
        
    
    /* 파기해야 할 개인 정보의 번호를 반환(오름차순으로 정렬하여)*/
    private int[] getPersonalInformationNumberToBeDestroyted(String today, HashMap<Integer, String> destructionDateMap) {
        ArrayList<Integer> destroyDateList = new ArrayList<>();
        
        for(Integer key : destructionDateMap.keySet()) {
            
            if(compareTwoDateForDestroy(today, destructionDateMap.get(key))) {
                destroyDateList.add(key);
            }
        }        
        
        return destroyDateList.stream().mapToInt(i->i).toArray();
        
    }
    
    /* 전달 받은 두개의 년월일을 비교하는 함수 */
    private boolean compareTwoDateForDestroy(String today, String destructionDate) {
        
        String[] splitedToday = today.split("\\.");
        String[] splitedDestructionDate = destructionDate.split("\\.");
        
        //년도 비교
        if(Integer.parseInt(splitedToday[0]) > Integer.parseInt(splitedDestructionDate[0])) return true;
        if(Integer.parseInt(splitedToday[0]) < Integer.parseInt(splitedDestructionDate[0])) return false;
        
        //월 비교
        if(Integer.parseInt(splitedToday[1]) > Integer.parseInt(splitedDestructionDate[1])) return true;
        if(Integer.parseInt(splitedToday[1]) < Integer.parseInt(splitedDestructionDate[1])) return false;
        
        //일 비교
        if(Integer.parseInt(splitedToday[2]) >= Integer.parseInt(splitedDestructionDate[2])) return true;
        
        
        return false;
    }
    
    /* 전달 받은 개인 정보의 파기 일자를 계산 */
    private HashMap<Integer, String> getDestuctionDate(HashMap<String, Integer> terms, String[] privacies) {
        
        HashMap<Integer, String> destructionDateMap = new HashMap<Integer, String>();
        
        int num = 0;
        for(String privacy : privacies) {
                  
            num++;
            String[] splitedPrivacy = privacy.split(" ");
            String collectionDate = splitedPrivacy[0];
            String termsType = splitedPrivacy[1];
        
            HashMap<String, Integer> yearMonthDayMap = seperationYearMonthDay(collectionDate);
            
            int expirationPeriod = terms.get(termsType);
            
            int month = yearMonthDayMap.get("MONTH") + (expirationPeriod % 12);
            int year = yearMonthDayMap.get("YEAR") + expirationPeriod / 12;
            
            if(month > 12) {
                year += (month / 12);
                month = month % 12;
            }
            
            String destructionDate = year + "." + month + "." + yearMonthDayMap.get("DAY");
            destructionDateMap.put(num, destructionDate);
        }
        
        return destructionDateMap;
    
    }
    
    /* 전달된 년원일을 분리하는 함수 */
    private HashMap<String, Integer> seperationYearMonthDay(String yearMonthDay) {
        
        HashMap<String, Integer> yearMonthDayMap = new HashMap<String, Integer>();
        
        String[] splitedYearMonthDay = yearMonthDay.split("\\.");
        
        yearMonthDayMap.put("YEAR", Integer.parseInt(splitedYearMonthDay[0]));
        yearMonthDayMap.put("MONTH", Integer.parseInt(splitedYearMonthDay[1]));
        yearMonthDayMap.put("DAY", Integer.parseInt(splitedYearMonthDay[2]));
        
        return yearMonthDayMap;
    }
    
    
    /* terms를 Map 저장 */
    private HashMap<String, Integer> changeTermsToMap(String[] terms) {
        
        HashMap<String, Integer> termsMap = new HashMap<String, Integer>();
        
        for(int i = 0; i < terms.length; i++) {
            
            String[] splitedTerm = terms[i].split(" ");
            String termsType = splitedTerm[0];
            int expirationPeriod = Integer.parseInt(splitedTerm[1]);
            
            termsMap.put(termsType, expirationPeriod);
        }
        
        return termsMap;
    } 
    
    
    
    
}