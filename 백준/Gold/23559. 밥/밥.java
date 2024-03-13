

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    private static final int MENU_A_COST = 5000;
    private static final int MENU_B_COST = 1000;

    static class Menu {
        private int tastyA;
        private int tastyB;
        private int satisfaction;

        public Menu(int tastyA, int tastyB, int satisfaction) {
            this.tastyA = tastyA;
            this.tastyB = tastyB;
            this.satisfaction = satisfaction;
        }

        public int getTastyA() {
            return tastyA;
        }

        public int getTastyB() {
            return tastyB;
        }


        public int getSatisfaction() {
            return satisfaction;
        }

    }


    public static void main(String[] args) throws IOException {

        int day;
        int money;
        int remainMoney;
        int remainDay;
        int maxSumTasty = 0;


        Comparator<Menu> tastyComparator = Comparator.comparingInt(Menu::getSatisfaction).reversed();
        PriorityQueue<Menu> satisfactionQueue = new PriorityQueue<>(tastyComparator);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        day = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());

        for(int i = 0; i < day; i++) {

            st = new StringTokenizer(br.readLine());

            int tastyA = Integer.parseInt(st.nextToken());
            int tastyB = Integer.parseInt(st.nextToken());
            int satisfaction = tastyA - tastyB;

            satisfactionQueue.add(new Menu(tastyA, tastyB, satisfaction));
        }

        remainDay = day;
        remainMoney = money;

        while (remainDay > 0 && isPossibleEatMenuA(remainDay, remainMoney)) {

            Menu menu = satisfactionQueue.peek();

            if(menu.getTastyB() > menu.getTastyA()) break;
            maxSumTasty += menu.getTastyA();
            remainMoney -= MENU_A_COST;
            remainDay -= 1;
            satisfactionQueue.poll();
        }

        while(remainDay > 0) {
            Menu menu = satisfactionQueue.poll();
            maxSumTasty += menu.getTastyB();
            remainMoney -= MENU_B_COST;
            remainDay -= 1;
        }

        System.out.println(maxSumTasty);
    }

    private static boolean isPossibleEatMenuA(int day, int money) {

        int remainMoney = money - MENU_A_COST;
        int remainDay = day - 1;

        return (remainDay * MENU_B_COST) <= remainMoney;
    }
}