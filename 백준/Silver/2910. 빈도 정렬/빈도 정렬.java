

import java.util.*;

public class Main {

    private static int N;
    private static int C;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();

        HashMap<Integer, NumberInfo> map = new HashMap<>();
        ArrayList<NumberInfo> list = new ArrayList<>();

        for (int idx = 0; idx < N; idx++) {
            int key = sc.nextInt();
            if(map.containsKey(key)) {
                map.get(key).increaseCount();
                continue;
            }
            map.put(key, new NumberInfo(key, idx));
            list.add(map.get(key));
        }

        Collections.sort(list);

        for (NumberInfo numberInfo : list) {
            numberInfo.print();
        }
//        System.out.println();
    }
}

class NumberInfo implements Comparable<NumberInfo> {

    private int number;
    private int idx;
    private int count;

    public NumberInfo(int number, int idx) {
        this.number = number;
        this.idx = idx;
        count = 1;
    }

    public void increaseCount() {
        this.count++;
    }


    @Override
    public int compareTo(NumberInfo o) {
        if(this.count == o.count)
            return this.idx - o.idx;
        return o.count - this.count;
    }

    public void print() {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++) {
            sb.append(number).append(' ');
        }
        System.out.print(sb);
    }
}

