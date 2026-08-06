class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());

        return res;
    }

    public void backtrack(int[] nums, int i, List<Integer> subset) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, i+1, subset);

        subset.removeLast();
        while (i<nums.length-1 && nums[i]==nums[i+1]) {
            i++;
        }

        backtrack(nums, i+1, subset);
    }
}
