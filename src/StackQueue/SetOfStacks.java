package StackQueue;
import java.util.Stack;
import java.util.ArrayList;

/**
 * Created by jli on 11/6/15.
 */
public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.size() == 0;
    }

    public void push(int v) {

    }

    public int pop() {
        return 1;
    }


}
