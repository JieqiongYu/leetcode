/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * 
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 * https://leetcode.com/problems/moving-average-from-data-stream/description/
 */
class MovingAverage {
    
    private double previousSum = 0.0;
    private Queue<Integer> currentWindow;
    private int maxSize;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        currentWindow = new LinkedList<>();
        maxSize = size;
    }
    
    public double next(int val) {
        if (currentWindow.size() == maxSize) {
            previousSum -= currentWindow.remove();
        }
        
        previousSum += val;
        currentWindow.add(val);
        return previousSum / currentWindow.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */