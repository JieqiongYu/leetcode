/**
* Given a collection of numbers that might contain duplicates,
* return all possible unique permutations.
*
* For example,
* [1,1,2] have the following unique permutations:
* [
*   [1,1,2],
*   [1,2,1],
*   [2,1,1]
* ]
*
* https://leetcode.com/problems/permutations-ii/description/
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        dfs(nums, new ArrayList<Integer>(), result, visited);
        return result;
    }

    private void dfs(int[] nums, List<Integer> permutation, List<List<Integer>> result, int[] visited) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<Integer>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i] == 1) {
                continue;
            }

            if (i != 0 && nums[i] == nums[i-1] && visited[i-1] == 0) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = 1;
            dfs(nums, permutation, result, visited);
            visited[i] = 0;
            permutation.remove(permutation.size() - 1);
        }

    }
}


// version 2
public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		
		Arrays.sort(nums);
		int[] visited = new int[nums.length];
		dfs(nums, new ArrayList<Integer>(), result, visited);
        
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> item : result) {
            ans.add(item);
        }
        
		return ans;
	}

	private void dfs(int[] nums, List<Integer> permutation, Set<List<Integer>> result, int[] visited) {
		if (permutation.size() == nums.length) {
			result.add(new ArrayList<Integer>(permutation));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if(visited[i] == 1) {
				continue;
			}
			// if (i != 0 && nums[i] == nums[i-1] && visited[i-1] == 0) {
			// 	continue;
			// }

			permutation.add(nums[i]);
			visited[i] = 1;
			dfs(nums, permutation, result, visited);
			visited[i] = 0;
			permutation.remove(permutation.size() - 1);
		}
	}
}