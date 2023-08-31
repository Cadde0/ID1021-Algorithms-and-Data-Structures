package HP35;

public class StaticStack extends Stack{
    private int[] stack = new int[1024];
    private int stackPointer = 0;

    public void push(int x) {
        if (stackPointer > stack.length){
            throw new IndexOutOfBoundsException("Stack Overflow");
        }
        stack[stackPointer++] = x;
    }

    public int pop(){
        if (stackPointer < 1 ){
            throw new IndexOutOfBoundsException("Stack NOflow");
        }

        return stack[--stackPointer];
    }
}
