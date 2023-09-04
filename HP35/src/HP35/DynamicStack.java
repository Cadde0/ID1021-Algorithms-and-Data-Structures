package HP35;

public class DynamicStack extends Stack{

    int size = 4;
    private int[] stack = new int[size];
    private int stackPointer = 0;

    private void increase(){
        size = size * 2;
        int[] bigStack = new int[size];
        for( int i = 0; i < stack.length; i++) {
            bigStack[i] = stack[i];
        }
        stack = bigStack;
    }

    private void decrease(){
        size = size / 2;
        int[] tinyStack = new int[size];
        for( int i = 0; i < tinyStack.length; i++) {
            tinyStack[i] = stack[i];
        }
        stack = tinyStack;
    }

    public void push(int x) {
        if (stackPointer == stack.length){
            throw new IndexOutOfBoundsException("Stack Overflow");
        } else if (stackPointer == size - 1){
            increase();
        }
        stack[stackPointer++] = x;
    }

    public int pop(){
        if (stackPointer < 1 ){
            throw new IndexOutOfBoundsException("Stack NOflow");
        } else if (stackPointer + 1 == size / 4) {
            decrease();
        }
        return stack[--stackPointer];
    }
}
