/**
 * [LeetCode][225] Implement Stack using Queues.
 * 
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, 
 * peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. 
 * You may simulate a queue by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations 
 * will be called on an empty stack).
 * 
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 */
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int size;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        size = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (q1.isEmpty()) {
            q2.offer(x);
        } else {
            q1.offer(x);
        }
        size++;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int result;
        if (q1.isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                q1.offer(q2.poll());
            }
            result = q2.poll();
        } else {
            for (int i = 0; i < size - 1; i++) {
                q2.offer(q1.poll());
            }
            result = q1.poll();
        }
        size--;
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        if (size == 0) {
            return -1;
        }
        int result = pop();
        if (q1.isEmpty()) {
            q2.offer(result);
        } else {
            q1.offer(result);
        }
        size++;
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */