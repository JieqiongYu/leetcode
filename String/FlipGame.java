/**
* You are playing the following Flip Game with your friend:
* Given a string that contains only these two characters: + and -,
* you and your friend take turns to flip two consecutive "++" into "--".
* The game ends when a person can no longer make a move and
* therefore the other person will be the winner.
*
* Write a function to compute all possible states of the string after one valid move.
*
* For example, given s = "++++", after one move, it may become one of the following states:
*
* [
*   "--++",
*   "+--+",
*   "++--"
* ]
* If there is no valid move, return an empty list [].
*
* https://leetcode.com/problems/flip-game/description/
*/
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == '+') {
                sb = sb.append(s.substring(0, i-1))
                        .append("--")
                        .append(s.substring(i + 1, s.length()));
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        return result;
    }
}
