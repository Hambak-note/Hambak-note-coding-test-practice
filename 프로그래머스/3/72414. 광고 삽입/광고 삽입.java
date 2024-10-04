class Solution {
private final int MAX_TIME = 360000;

    /**
     *
     * @param play_time 죠르디의 동영상 재생시간 길이
     * @param adv_time 공익광고의 재생시간 길이
     * @param logs 시청자들이 해당 동영상을 재생했던 구간 정보
     * @return 공익광고가 들어갈 시작 시각
     *          - 누적 재생시간이 가장 많은 곳이 여러 곳이라면, 그 중에서 가장 빠른 시작 시각을 return
     */
    public String solution(String play_time, String adv_time, String[] logs) {

        int pt = timeToSecond(play_time);
        int at = timeToSecond(adv_time);
        int[] viewCnt = new int[MAX_TIME+1];

        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            int start = timeToSecond(log.substring(0, 8));
            int end = timeToSecond(log.substring(9, 17));
            viewCnt[start]++;
            viewCnt[end]--;
        }

        for (int i = 1; i <= MAX_TIME; i++) viewCnt[i] += viewCnt[i - 1];


        long curValue = 0;
        for (int i = 0; i < at; i++) curValue += viewCnt[i];
        long maxValue = curValue;

        int maxTime = 0;
        for(int i = 1; i <= MAX_TIME - at; i++) {
            curValue = curValue - viewCnt[i-1] + viewCnt[i + at -1];
            if(curValue > maxValue) {
                maxValue = curValue;
                maxTime = i;
            }
        }

        return secondToTime(maxTime);
    }

    private int timeToSecond(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 3600
                + Integer.parseInt(time.substring(3, 5)) * 60
                + Integer.parseInt(time.substring(6, 8));
    }

    private String secondToTime(int second) {

        StringBuilder sb = new StringBuilder();

        if((second/3600) < 10) sb.append("0");
        sb.append(String.valueOf(second/3600) + ":");

        second %= 3600;
        if((second/60) < 10) sb.append("0");
        sb.append(String.valueOf(second/60) + ":");

        second %= 60;
        if(second < 10) sb.append("0");
        sb.append(String.valueOf(second));

        return sb.toString();
    }
}