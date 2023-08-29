package HP35;

public class Stack {
    public int[] stack = new int[8];
    int stackPointer = 0;

    void push(int i) {
        if (stackPointer > stack.length){
            throw new IndexOutOfBoundsException("Stack Overflow");
        }
        stack[stackPointer] = i;
        stackPointer++;
    }

    public int pop(){
        if (stackPointer < 1 ){
            throw new IndexOutOfBoundsException("Stack NOflow");
        }
        stackPointer--;
        return stack[stackPointer + 1];
    }
}
