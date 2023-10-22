import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    
    private static final Integer START_HOUR = 9;
    private static final Integer START_MINUTE = 0;
    
    public String solution(int n, int t, int m, String[] timetable) {
        
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        List<LocalTime> busTimeList = new ArrayList<>();
        List<LocalTime> timetableList = new ArrayList<>();

        //버스 시간  추가
        LocalTime busTime = LocalTime.of(START_HOUR, START_MINUTE);
        for (int i = 0; i < n; i++) {
            LocalTime newBusTime = busTime.plusMinutes(i * t);
            busTimeList.add(newBusTime);
        }

        //timetable 시간 형식으로 추가
        for(int i = 0; i < timetable.length; i++) {
            timetableList.add(LocalTime.parse(timetable[i], formatter));
        }

        //timetableList 정렬
        Collections.sort(timetableList);

        //마지막 버스 이전까지 크루가 탑승했을 경우를 계산하는 로직
        for(int i = 0; i < n-1; i++) {

            LocalTime currentBusTime = busTimeList.get(i);

            for(int j = 0; j < m; j++) {
                if(!timetableList.isEmpty()
                        && ( timetableList.get(0).isBefore(currentBusTime) || timetableList.get(0).equals(currentBusTime))) {
                    timetableList.remove(0);
                }
            }
        }

        LocalTime lastBusTime = busTimeList.get(n-1);

        if(timetableList.size() < m) {
            return lastBusTime.format(formatter);
        }

        if(timetableList.get(m-1).isAfter(lastBusTime)) {
            return lastBusTime.format(formatter);
        }

        return timetableList.get(m-1).minusMinutes(1).format(formatter);
    }
}
