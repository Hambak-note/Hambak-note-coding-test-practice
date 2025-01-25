import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        IntStream.range(0, t)
                .mapToObj(i -> {
                    try {
                        return Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(n -> isBeautifulNumber(n) ? "Good Bye" : "BOJ 2022")
                .forEach(System.out::println);
    }

    private static boolean isBeautifulNumber(int n) {

        Set<Integer> divisors = IntStream.rangeClosed(1, n / 2)
                .filter(i -> n % i == 0)
                .boxed()
                .collect(Collectors.toSet());

        boolean isAbundant = divisors.stream()
                .mapToInt(Integer::intValue)
                .sum() > n;

        if(!isAbundant) return false;

        return divisors.stream()
                .allMatch(d -> {
                    int divSum = IntStream.rangeClosed(1, d / 2)
                            .filter(i -> d % i == 0)
                            .sum();
                    return divSum <= d;
                });
    }
}
