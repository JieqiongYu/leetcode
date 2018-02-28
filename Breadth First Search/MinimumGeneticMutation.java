/**
 * [LeetCode][433] Minimum Genetic Mutation.
 * 
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 * 
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character 
 * changed in the gene string.
 * 
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 * 
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". 
 * If there is no such a mutation, return -1.
 * 
 * Note:
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * 
 * Example 1:
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * return: 1
 * 
 * Example 2:
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * return: 2
 * 
 * Example 3:
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * return: 3
 * 
 * https://leetcode.com/problems/minimum-genetic-mutation/description/
 */
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) {
            return -1;
        }
        
        Set<String> bankSet = new HashSet<>();
        bankSet.addAll(Arrays.asList(bank));
        
        bankSet.add(start);
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        set.add(start);
        
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                String dna  = queue.poll();
                for (String nextDNA : getNextDNA(dna, bankSet)) {
                    if (set.contains(nextDNA)) {
                        continue;
                    }
                    if (end.equals(nextDNA)) {
                        return length;
                    }
                    queue.offer(nextDNA);
                    set.add(nextDNA);
                }
            }
        }
        
        return -1;
        
    }
    
    private List<String> getNextDNA(String dna, Set<String> bankSet) {
        List<String> nextDNAList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < dna.length(); j++) {
                String nextDNA = replace(dna, i, j);
                if (bankSet.contains(nextDNA)) {
                    nextDNAList.add(nextDNA);
                }
            }
        }
        return nextDNAList;
    }
    
    private String replace(String dna, int i, int j) {
        char[] dnaChar = dna.toCharArray();
        switch(i) {
            case 0:
                dnaChar[j] = 'A';
                break;
            case 1: 
                dnaChar[j] = 'C';
                break;
            case 2: 
                dnaChar[j] = 'G';
                break;
            default:
                dnaChar[j] = 'T';
        }
        
        return new String(dnaChar);
    }
}