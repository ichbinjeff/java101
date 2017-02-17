package StackQueue;

/**
 * Created by jli on 11/5/15.
 */
public class ThreeStacks {
    int stackSize = 100;
    int[] buffer = new int[stackSize * 3];
    int[] stackPointer = {-1, -1, -1};

    public void push(int stackNum, int value) throws Exception {
        if (stackPointer[stackNum] + 1 > stackSize) {
            throw new Exception("Out of space.");
        }
        stackPointer[stackNum] ++;
        buffer[absTopOfStack(stackNum)] = value;
    }

    public int pop(int stackNum) throws Exception {
        if (stackPointer[stackNum] == -1) {
            throw new Exception("Trying to pop an empty stack.");
        }
        int value = buffer[absTopOfStack(stackNum)];
        buffer[absTopOfStack(stackNum)] = 0;
        stackPointer[stackNum] --;
        return value;
    }

    public int peek(int stackNum) {
        int index = absTopOfStack(stackNum);
        return buffer[index];
    }

    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    public int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }
}
