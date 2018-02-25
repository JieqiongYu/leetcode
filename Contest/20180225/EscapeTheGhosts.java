class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < ghosts.length; i++) {
            minDistance = Math.min(minDistance, getDistance(ghosts[i], target));
        }
        
        int[] origin = new int[]{0,0};
        int humanDistance = getDistance(origin, target);
        
        if (minDistance > humanDistance) {
            return true;
        } 
        
        return false;
    }
    
    private int getDistance(int[] source, int[] target) {
        return Math.abs(target[0] - source[0]) + Math.abs(target[1] - source[1]);
    }
}