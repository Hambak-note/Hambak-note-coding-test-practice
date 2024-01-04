import java.util.LinkedList;
import java.util.Queue;

class MyStack {

        private Queue<Integer> mainQueue;
        private Queue<Integer> supportQueue;


        public MyStack() {
            mainQueue = new LinkedList<>();
            supportQueue = new LinkedList<>();
        }

        public void push(int x) {
            mainQueue.add(x);

            while(!supportQueue.isEmpty()) {
                mainQueue.add(supportQueue.poll());
            }

            Queue<Integer> temp = mainQueue;
            mainQueue = supportQueue;
            supportQueue = temp;
        }

        public int pop() {
            return supportQueue.poll();
        }

        public int top() {
            return  supportQueue.peek();
        }

        public boolean empty() {
            return supportQueue.isEmpty();
        }
    }