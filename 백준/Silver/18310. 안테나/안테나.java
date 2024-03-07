

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int numberOfHouses;
    private static List<Integer> inputHouses;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfHouses = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        inputHouses = new ArrayList<>();
        for (int i = 0; i < numberOfHouses; i++) {
            inputHouses.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(inputHouses);

        System.out.println(getAntennaInstallationPosition());
    }

    private static int getAntennaInstallationPosition() {

       int midPos = inputHouses.size() / 2;
        int curAntennaPos = inputHouses.get(midPos);

        int curDistance = 0;
        for (Integer inputHouse : inputHouses) {
            curDistance += Math.abs(curAntennaPos - inputHouse);
        }
        
        if(inputHouses.size() == 1) return curAntennaPos;

        int prevAntennaPos = inputHouses.get(midPos-1);
        int prevDistance = 0;
        for (Integer inputHouse : inputHouses) {
            prevDistance += Math.abs(prevAntennaPos - inputHouse);
        }

        if(prevDistance <= curDistance) return prevAntennaPos;

       return curAntennaPos;
    }
}
