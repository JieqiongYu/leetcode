/**
* [LeetCode 824] Goat Latin
* A sentence S is given, composed of words separated by spaces. 
* Each word consists of lowercase and uppercase letters only.
*
* We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
*
* The rules of Goat Latin are as follows:
* 1) If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
*       For example, the word 'apple' becomes 'applema'.
* 2) If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, 
* then add "ma".
*       For example, the word "goat" becomes "oatgma".
* 3) Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
*       For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
* Return the final sentence representing the conversion from S to Goat Latin. 
* 
* Example 1:
* Input: "I speak Goat Latin"
* Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
* 
* Example 2: 
* Input: "The quick brown fox jumped over the lazy dog"
* Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
* 
* Notes: 
* 1) S contains only uppercase, lowercase and spaces. Exactly one space between each word.
* 2) 1 <= S.length <= 150.
*/
class Solution {
    public String toGoatLatin(String S) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    
        String[] sArray = S.split(" ");
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
    
        for (int i = 0; i < sArray.length; i++) {
            if (set.contains(Character.toLowerCase(sArray[i].charAt(0)))) {
                sb.append(sArray[i].substring(0, sArray[i].length())).append("ma");
            } else {
                sb.append(sArray[i].substring(1, sArray[i].length())).append(sArray[i].charAt(0)).append("ma");
            }
      
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            
            result.add(sb.toString());
            sb.setLength(0);
        }

        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < result.size(); i++) {
            answer.append(result.get(i)).append(" ");
        }
    
        return answer.toString().trim();
    }
}