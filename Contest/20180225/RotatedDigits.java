class Solution {
    private Set<Integer> goodNumbers;
    private Set<Integer> identicalNumbers;
    public int rotatedDigits(int N) {
        goodNumbers = new HashSet<>();
        identicalNumbers = new HashSet<>();
        goodNumbers.add(2);
        goodNumbers.add(5);
        goodNumbers.add(6);
        goodNumbers.add(9);
        
        identicalNumbers.add(0);
        identicalNumbers.add(1);
        identicalNumbers.add(8);
        
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if(validNumbers(i)) {
                count++;
            }
            if (validIdenticalNumbers(i)) {
                count--;
            }
        }
        
        return count;
    }
    
    private boolean validNumbers(int number) {
        while (number > 0) {
            int digit = number % 10;
            if (!goodNumbers.contains(digit) && !identicalNumbers.contains(digit)) {
                return false;
            }
            
            number /= 10;
        }
        return true;
    }
    
    private boolean validIdenticalNumbers(int number) {
        while (number > 0) {
            int digit = number % 10;
            if (!identicalNumbers.contains(digit)) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}