

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        int numberOfFilename;
        String pattern;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfFilename = Integer.parseInt(br.readLine());
        pattern = br.readLine();
        Pattern regexPattern = Pattern.compile(makeRegexPattern(pattern));

        while (numberOfFilename-- > 0) {

            String filename = br.readLine();
            Matcher matcher = regexPattern.matcher(filename);

            boolean isMatch = matcher.matches();

            if(isMatch) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }

    private static String makeRegexPattern(String pattern) {

        return pattern.replace("*", ".*");
    }
}