/*
* - 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받는다
* - 선물을 주고받은 기록이 하나도 없거나 같다면, 선물 지수가 더 큰 사람이 작은사람에게 하나 받는다.
* - 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값
* - 위의 경우 선물 지수도 같다면 다음 달에 선물을 주고 받지 않음
* - 목적: 선물을 가장 많은 받은 사람이 받을 선물의 수를 알고 싶다.
*/

import java.util.*;

// 이름이 ab일 경우 abc나 cab 이런 친구들도 있어서 틀리는 경우입니다~

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        int answer = Integer.MIN_VALUE;
        HashMap<String, Person> personMap = initPersonMap(friends);
        claGiveAndReceivePerson(gifts, personMap);
        
        int received = Integer.MIN_VALUE;
        for(int i = 0; i < friends.length; i++) {
            received = getNumberOfGiftsReceived(personMap.get(friends[i]), friends, personMap);
            if(received > answer) answer = received;
        }
        
        return answer;
    }

    
    private HashMap<String, Person> initPersonMap(String[] friends) {
        
        HashMap<String, Person> personMap = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            personMap.put(friends[i], new Person(friends[i]));
        }
        
        return personMap;
    }
    
    private void claGiveAndReceivePerson(String[] gifts, HashMap<String, Person> personMap) {
        
        for(int i = 0; i < gifts.length; i++) {
            
            String[] splited = gifts[i].split(" ");
            String from = splited[0];
            String to = splited[1];
            
            Person fromPerson = personMap.get(from);
            Person toPerson = personMap.get(to);
            
            fromPerson.addGive(to);
            toPerson.addReceive(from);
        }
    }
    
    
    private int getNumberOfGiftsReceived(Person person, String[] friends, HashMap<String, Person> personMap) {
        
        int numberOfGiftsReceived = 0;
        
        HashMap<String, Integer> giveMap = person.getGiveMap();
        HashMap<String, Integer> receiveMap = person.getReceiveMap();
        
        for(int i = 0; i < friends.length; i++) {
            
            if(friends[i].equals(person.getName())) continue;

            boolean give = giveMap.containsKey(friends[i]);
            boolean receive = receiveMap.containsKey(friends[i]);
            
            int personGiftPoint = person.getGiftPoint();
            int targetGiftPoint = personMap.get(friends[i]).getGiftPoint();
            
            //둘 다 선물을 주고 받지 않은 경우 -> 선물 지수가 높은 쪽이 받는다. 근데 당사자가 선물 지수가 제일 높음
            if(!give && !receive) {
                
                if(personGiftPoint > targetGiftPoint) {
                    numberOfGiftsReceived++;
                    continue;
                }
                
                continue;
            }
            
            //나만 준 경우
            if(give && !receive) {
                numberOfGiftsReceived++;
                continue;
            }
            
            //서로 준 경우
            if(give && receive) {
                if(giveMap.get(friends[i]) > receiveMap.get(friends[i])) {
                    numberOfGiftsReceived++;
                    continue;
                }
                
                if(giveMap.get(friends[i]) == receiveMap.get(friends[i])) {
                    if(personGiftPoint > targetGiftPoint) {
                        numberOfGiftsReceived++;    
                        continue;
                    }
                }
            }
        }
        
        return numberOfGiftsReceived;
    }
}

class Person {
    
    String name;
    // int totalGiveCnt;
    // int totalReceiveCnt;
    HashMap<String, Integer> giveMap;
    HashMap<String, Integer> receiveMap;
    int giftPoint;
    
    
    public Person(String name) {
        this.name = name;
        giveMap = new HashMap<>();
        receiveMap = new HashMap<>();
        giftPoint = 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public HashMap<String, Integer> getGiveMap() {
        return this.giveMap;
    }
    
    public HashMap<String, Integer> getReceiveMap() {
        return this.receiveMap;
    }
    
    public int getGiftPoint() {
        calGiftPoint();
        return this.giftPoint;
    }
    
    public void addGive(String to) {
        giveMap.put(to, giveMap.getOrDefault(to, 0) + 1);
    }
    
    public void addReceive(String from) {
        receiveMap.put(from, receiveMap.getOrDefault(from, 0) + 1);
    }
    
    private void calGiftPoint() {
        
        int giveCnt = calTotalGiveCnt();
        int receiveCnt = calTotalReceiveCnt();
        this.giftPoint = giveCnt - receiveCnt;
    }
    
    private int calTotalGiveCnt() {
        
        int giveCnt = 0;
        for(String key : giveMap.keySet()) {
            giveCnt += giveMap.get(key);
        }
        return giveCnt;
    }
    
    private int calTotalReceiveCnt() {
        int receiveCnt = 0;
        for(String key : receiveMap.keySet()) {
            receiveCnt += receiveMap.get(key);
        }
        return receiveCnt;
    }
}