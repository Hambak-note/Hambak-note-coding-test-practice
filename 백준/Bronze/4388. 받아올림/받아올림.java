import java.io.*;
import java.util.*;

public class Main {

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.lines()
                .takeWhile(line -> !Arrays.stream(line.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .allMatch(n -> n == 0))
                .forEach(line -> {
                    String[] nums = line.split("\\s+");
                    int num1 = Integer.parseInt(nums[0]);
                    int num2 = Integer.parseInt(nums[1]);
                    System.out.println(countCarry(num1, num2));
                });
    }

    private static int countCarry(int num1, int num2) {
        int carry = 0;
        int carryCount = 0;

        while(num1 > 0 || num2 > 0) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            int sum = digit1 + digit2 + carry;

            carry = sum / 10;
            if (carry > 0) carryCount++;

            num1 /= 10;
            num2 /= 10;
        }

        return carryCount;
    }
}
