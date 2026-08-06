class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, target, 0, 0, subset);
        return res;
        
    }

    public void dfs(int[] nums, int target, int i, int total, List<Integer> subset) {
        if (target==total) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for (int j=i; j<nums.length; j++) {
            if (total+nums[j] > target) return;

            subset.add(nums[j]);
            dfs(nums, target, j, total+nums[j], subset);

            subset.removeLast();
        }

    }
}
