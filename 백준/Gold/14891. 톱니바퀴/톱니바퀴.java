

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    private static final int N = 0;
    private static final int S = 1;
    private static final int CLOCKWISE = 1;
    private static final int COUNTER_CLOCKWISE = -1;
    private static final int NOT_ROTATE = 0;
    private static final int NUMBER_OF_GEARWHEEL = 4;

    private static int numberOfTurns;
    private static int rotateGearNumber;
    private static int rotateDirection;

    static class GearWheel {

        List<Integer> gears;

        public GearWheel(List<Integer> gears) {
            this.gears = gears;
        }

        public int getThreeClock() {
            return gears.get(2);
        }

        public int getNineClock() {
            return gears.get(6);
        }

        public int getTwelveClock() {
            return gears.get(0);
        }

        public void rotateClockwise() {

            int lastGear = gears.get(7);
            gears.remove(7);
            gears.add(0, lastGear);
        }

        public void rotateCounterClockwise() {

            int firstGear = gears.get(0);
            gears.remove(0);
            gears.add(firstGear);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<GearWheel> gearWheels = new ArrayList<>();

        for(int i = 0; i < NUMBER_OF_GEARWHEEL; i++) {
            List<Integer> gears = new ArrayList<>();
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                gears.add(input.charAt(j) - 48);
            }
            gearWheels.add(new GearWheel(gears));
        }

        numberOfTurns = Integer.parseInt(br.readLine());


        for(int i = 0; i < numberOfTurns; i++) {
            st = new StringTokenizer(br.readLine());
            rotateGearNumber = Integer.parseInt(st.nextToken())-1;
            rotateDirection = Integer.parseInt(st.nextToken());

            int[] rotationDirections = getRotationDirections(gearWheels);
            rotate(rotationDirections, gearWheels);
        }

        int result = calGearWheelsSum(gearWheels);
        System.out.println(result);
    }


    static private int[] getRotationDirections(List<GearWheel> gearWheels) {

        int[] rotationDirections = new int[NUMBER_OF_GEARWHEEL];
        rotationDirections[rotateGearNumber] = rotateDirection;

        //기준점 왼쪽 톱니 회전 방향 구하기
        int curGearNumber = rotateGearNumber;
        while(curGearNumber > 0) {

            int leftGearNumber = curGearNumber - 1;

            int curGearNineClock = gearWheels.get(curGearNumber).getNineClock();
            int leftGearThreeClock = gearWheels.get(leftGearNumber).getThreeClock();

            if(curGearNineClock == leftGearThreeClock) {
                break;
            } else {
                rotationDirections[leftGearNumber] = -(rotationDirections[curGearNumber]);
            }

            curGearNumber--;
        }

        //기준점 오른쪽 톱니 회전 방향 구하기
        curGearNumber = rotateGearNumber;

        while(curGearNumber < NUMBER_OF_GEARWHEEL-1) {
            int rightGearNumber = curGearNumber+1;

            int curGearThreeClock = gearWheels.get(curGearNumber).getThreeClock();
            int rightGearNineClock = gearWheels.get(rightGearNumber).getNineClock();

            if(curGearThreeClock == rightGearNineClock) {
                break;
            } else {
                rotationDirections[rightGearNumber] = -(rotationDirections[curGearNumber]);
            }

            curGearNumber++;
            rightGearNumber++;
        }

        return rotationDirections;
    }

    static private void rotate(int[] rotationDirections, List<GearWheel> gearWheels) {

        int gearNumber = 0;
        for (int rotationDirection : rotationDirections) {
            GearWheel gearWheel = gearWheels.get(gearNumber++);
            if(rotationDirection == CLOCKWISE) gearWheel.rotateClockwise();
            else if (rotationDirection == COUNTER_CLOCKWISE) gearWheel.rotateCounterClockwise();
        }
    }

    static private int calGearWheelsSum(List<GearWheel> gearWheels) {

        int sum = 0;

        int sumPoint = 1;
        for (GearWheel gearWheel : gearWheels) {

            int twelveClock = gearWheel.getTwelveClock();
            if(twelveClock == S) {
                sum += sumPoint;
            }
            sumPoint *= 2;
        }

        return sum;
    }

}
