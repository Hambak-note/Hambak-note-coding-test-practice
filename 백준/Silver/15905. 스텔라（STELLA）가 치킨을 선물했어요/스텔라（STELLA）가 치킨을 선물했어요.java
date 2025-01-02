
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static List<Person> persons;

    static class Person {
        int solveCount;
        int penalty;

        public Person(int solveCount, int penalty) {
            this.solveCount = solveCount;
            this.penalty = penalty;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        persons = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Person person = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            persons.add(person);
        }

        persons.sort((p1, p2) -> {
            if(p1.solveCount != p2.solveCount) {
                return p2.solveCount - p1.solveCount;
            }
            return p1.penalty - p2.penalty;
        });

        int count = 0;
        if ( n >= 5 ) {
            Person findPerson = persons.get(4);
            for(int i = 5; i < n; i++) {
                if (persons.get(i).solveCount == findPerson.solveCount) {
                    count++;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
