package StackQueue;
import java.util.Stack;
/**
 * Created by shli15 on 10/18/16.
 */
public class SortStack {
    public void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        sort(stack);
        insert(top, stack);
    }

    private void insert(int top, Stack<Integer> stack) {
        if (stack.isEmpty() || top > stack.peek()) {
            stack.push(top);
        } else {
            int tmp = stack.pop();
            insert(top, stack);
            stack.push(tmp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(2);
        stack.push(4);

        SortStack ss = new SortStack();
        ss.sort(stack);
        System.out.print("done");
    }
}
