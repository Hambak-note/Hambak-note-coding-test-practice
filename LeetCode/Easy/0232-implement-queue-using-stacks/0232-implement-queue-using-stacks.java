import java.util.Stack;


class MyQueue {

        Stack<Integer> mainStack;
        Stack<Integer> supportStack;

        public MyQueue() {
            mainStack = new Stack<>();
            supportStack = new Stack<>();
        }

        public void push(int x) {

            mainStack.push(x);
        }

        public int pop() {
            
            if(supportStack.isEmpty()) {
                while(!mainStack.isEmpty()) {
                    supportStack.push(mainStack.pop());
                }
            }
            return supportStack.pop();
        }

        public int peek() {
            if(supportStack.isEmpty()) {
                while(!mainStack.isEmpty()) {
                    supportStack.push(mainStack.pop());
                }
            }
            return supportStack.peek();
        }

        public boolean empty() {
            return mainStack.isEmpty() && supportStack.isEmpty();
        }
    }