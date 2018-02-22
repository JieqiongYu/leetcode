/**
 * 
 * [LeetCode][187]Repeated DNA Sequences
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * 
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> hash = new HashSet<>();
        Set<String> dna = new HashSet<>();
        
        for (int i = 9; i < s.length(); i++) {
            String target = s.substring(i-9, i+1);
            int encode = encoded(target);
            if (hash.contains(encode)) {
                dna.add(target);
            } else {
                hash.add(encode);
            }
        }
        
        return new ArrayList<String>(dna);
    }
    
    private int encoded(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                sum = sum * 4;
            } else if (s.charAt(i) == 'C') {
                sum = sum * 4 + 1;
            } else if (s.charAt(i) == 'G') {
                sum = sum * 4 + 2;
            } else {
                sum = sum * 4 + 3;
            }
        }
        return sum;
    }
}