import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());

        int one = second / 100;
        int two = (second % 100) / 10;
        int three = second % 10;

        System.out.println(first * three);
        System.out.println(first * two);
        System.out.println(first * one);
        System.out.println(first * second);
    }
}