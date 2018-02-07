/**
 * [LeetCode][599]Minium Index Sum of Two Lists
 * 
* Suppose Andy and Doris want to choose a restaurant for dinner,
* and they both have a list of favorite restaurants represented by strings.
*
* You need to help them find out their common interest with the least list index sum.
* If there is a choice tie between answers, output all of them with no order requirement.
* You could assume there always exists an answer.
*
* Example 1:
* Input:
* ["Shogun", "Tapioca Express", "Burger King", "KFC"]
* ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
* Output: ["Shogun"]
* Explanation: The only restaurant they both like is "Shogun".
*
* Example 2:
* Input:
* ["Shogun", "Tapioca Express", "Burger King", "KFC"]
* ["KFC", "Shogun", "Burger King"]
* Output: ["Shogun"]
* Explanation: The restaurant they both like and have the least index sum is
* "Shogun" with index sum 1 (0+1).
*
* Note:
* The length of both lists will be in the range of [1, 1000].
* The length of strings in both lists will be in the range of [1, 30].
* The index is starting from 0 to the list length minus 1.
* No duplicates in both lists.
* 
* https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
*/
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list1.length == 0 || list2 == null ||  list2.length == 0) {
            return new String[]{};
        }

        List<String> result = new ArrayList<>();

        int sum = -1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (sum == -1) {
                    sum = map.get(list2[i]) + i;
                    result.add(list2[i]);
                } else {
                    if (sum == (map.get(list2[i]) + i)) {
                        result.add(list2[i]);
                    } else if (sum > (map.get(list2[i]) + i)) {
                        sum = map.get(list2[i]) + i;
                        result.clear();
                        result.add(list2[i]);
                    } else {
                        continue;
                    }

                }
            }
        }

        String[] answer = new String[result.size()];
        int index = 0;
        for (String item : result) {
            answer[index++] = item;
        }

        return answer;
    }
}
