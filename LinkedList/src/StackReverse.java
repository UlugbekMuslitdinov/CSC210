import java.util.Stack;

public class StackReverse {
    private Stack<String> stack = new Stack<String>();
    private Stack<String> reversedStack = new Stack<String>();

    public void reverse(String s) {
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.substring(i, i + 1));
        }
        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }
    }

    public void push(String s) {
        stack.push(s);
    }

    public String pop() {
        return reversedStack.pop();
    }
}