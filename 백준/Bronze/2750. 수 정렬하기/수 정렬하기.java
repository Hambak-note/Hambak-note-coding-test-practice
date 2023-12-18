

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    private static int testCase;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while (testCase-- > 0) {

            list.add(Integer.parseInt(br.readLine()));

        }

        Collections.sort(list);
        for (Integer value : list) {
            System.out.println(value);
        }

    }
}
