/**
* Given a collection of distinct numbers, return all possible permutations.
*
* For example,
* [1,2,3] have the following permutations:
* [
*  [1,2,3],
*  [1,3,2],
*  [2,1,3],
*  [2,3,1],
*  [3,1,2],
*  [3,2,1]
* ]
*
* https://leetcode.com/problems/permutations/description/
*/
class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> permutation = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		dfs(nums, set, result, permutation);
		return result;
	}

	private void dfs(int[] nums, Set<Integer> set, List<List<Integer>> result, List<Integer> permutation) {
		if (permutation.size() == nums.length) {
			result.add(new ArrayList<Integer>(permutation));
		}

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				continue;
			}
			permutation.add(nums[i]);
			set.add(nums[i]);
			dfs(nums, set, result, permutation);
			set.remove(nums[i]);
			permutation.remove(permutation.size() - 1);
		}
	}
}
