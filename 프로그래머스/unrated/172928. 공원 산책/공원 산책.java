class Solution {
    
    private static final char START = 'S';
    private static final char ROAD = 'O';
    private static final char OBSTACLE = 'X';
    private static final char NORTH = 'N';
    private static final char SOUTH = 'S';
    private static final char WEST = 'W';
    private static final char EAST = 'E';
  public  int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        int[] currentPoint = findStartPoint(park);
        for(int i = 0; i < routes.length; i++) {
            currentPoint = commandExecution(park, routes[i], currentPoint);
        }

        answer = currentPoint;

        return answer;
    }

    //시작 위치를 찾는 함수
    private static int[] findStartPoint(String[] park) {

        int[] startPoint = new int[2];

        for(int i = 0; i < park.length; i++) {

            if(park[i].indexOf(START) >= 0){
                startPoint[0] = i;
                startPoint[1] = park[i].indexOf(START);
                return startPoint;
            }
        }

        return startPoint;
    }

    //하나의 명령을 수행하는 함수
    private  int[] commandExecution(String[] park, String route, int[] currentPoint) {

        char direction = route.charAt(0);
        int moveCount = Character.getNumericValue(route.charAt(2));
        int[] movePoint = new int[2];

        if(direction == NORTH) {
            movePoint[0] = currentPoint[0]- moveCount;
            movePoint[1] = currentPoint[1] ;
            if(isCommandExecutable(park, currentPoint, movePoint)) return movePoint;
        }

        if(direction == SOUTH) {
            movePoint[0] = currentPoint[0]+ moveCount;
            movePoint[1] = currentPoint[1] ;
            if(isCommandExecutable(park, currentPoint, movePoint)) return movePoint;

        }

        if(direction == WEST) {
            movePoint[0] = currentPoint[0] ;
            movePoint[1] = currentPoint[1]- moveCount ;
            if(isCommandExecutable(park, currentPoint, movePoint)) return movePoint;
        }

        if(direction == EAST) {
            movePoint[0] = currentPoint[0] ;
            movePoint[1] = currentPoint[1] + moveCount;
            if(isCommandExecutable(park, currentPoint, movePoint)) return movePoint;
        }

        return currentPoint;
    }

    //명령을 수행할 수 없는 경우 확인
    private boolean isCommandExecutable(String[] park, int[] currentPoint, int[] movePoint) {

        //공원을 벗어나는 지 확인
        if(movePoint[0] < 0 || movePoint[1] < 0 ) return false;
        if(park.length <= movePoint[0] || park[0].length() <= movePoint[1]) return false;

        //장애물을 만나는 지 확인
        for(int i = currentPoint[0]; i <= movePoint[0]; i++) {

            for(int j = currentPoint[1]; j <= movePoint[1]; j++) {
                if(park[i].charAt(j) == OBSTACLE) return false;
            }
        }
        
                for(int i = movePoint[0]; i <= currentPoint[0]; i++) {

            for(int j = movePoint[1]; j <= currentPoint[1]; j++) {
                if(park[i].charAt(j) == OBSTACLE) return false;
            }
        }

        return true;
    }
}