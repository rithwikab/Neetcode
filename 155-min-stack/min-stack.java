class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        if(!min.isEmpty() && value > min.peek()) return;
        if(min.isEmpty() || min.peek() >= value)min.push(value);
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        if(!min.isEmpty() && min.peek() == temp) min.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }
    
    public int getMin() {
        if(min.isEmpty())return -1;
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */