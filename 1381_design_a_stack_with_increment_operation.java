// @lc app=leetcode id=1381 lang=java

 class CustomStack {

    int[] array;
    int top;

    public CustomStack(int maxSize) {
        array = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if (isFull()) return;
        array[++top] = x;
    }
    
    public int pop() {
        if (isEmpty()) return -1;
        return array[top--];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == array.length - 1;
    }
    
    public void increment(int k, int val) {
        int end = k - 1;
        if (top < k - 1) end = top;
        for (int i = 0; i <= end; i++) {
            array[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
