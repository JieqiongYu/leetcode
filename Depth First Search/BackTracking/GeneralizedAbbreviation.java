public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> answer = new ArrayList<>();
        dfs(answer, new StringBuilder(), word, 0, 0);
        return answer;
    }

    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void dfs(List<String> answer, StringBuilder builder, int i, int k) {
        int len = builder.length(); // keep the length of builder
        if (i == word.length()) {
            if (k != 0) {
                builder.append(k); // append the last k if non zero
                answer.add(builder.toString());
            } else {
                dfs(answer, builder, word, i+1, k+1);

                if (k != 0) {
                    builder.append(k);
                builder.append(word.charAt(i));
                dfs(answer, builder, word, i+1, 0);
                }
                builder.setLength(len);
            }
        }
    }
}