class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
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

        for (int j=i; j<nums.length; j++) {
            if (j>i && nums[j]==nums[j-1]) continue;
            if (total+nums[j] > target) break;

            subset.add(nums[j]);
            backtrack(nums, target, j+1, total+nums[j], subset);

            subset.removeLast();
        }
    }
}
