import java.util.*;
import java.io.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      List<Integer> inputs = IntStream.rangeClosed(1, 3)
          .mapToObj(i -> {
              try {
                  return Integer.parseInt(br.readLine());
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          })
          .collect(Collectors.toList());

      int sum = inputs.stream().mapToInt(Integer::intValue).sum();

      if (sum != 180) {
        System.out.println("Error");
      } else if ( inputs.stream().allMatch(angle -> angle == 60)) {
        System.out.println("Equilateral");
      } else if ( inputs.stream().distinct().count() == 2) {
        System.out.println("Isosceles");
      } else {
        System.out.println("Scalene");
      }
    }  
}