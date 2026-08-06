class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int target, int i, int total, List<Integer> subset) {
        if (total == target) {
            res.add(new ArrayList<>(subset));
            return;
        }

        if (total > target || i == nums.length) return;

        subset.add(nums[i]);
        backtrack(nums, target, i+1, total+nums[i], subset);
        while (i<nums.length-1 && nums[i]==nums[i+1]) {
            i++;
        }
        subset.removeLast();
        backtrack(nums, target, i+1, total, subset);
    }
}
