class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());

        return res;
    }

    public void backtrack(int[] nums, int i, List<Integer> subset) {
        res.add(new ArrayList<>(subset));

        for (int j=i; j<nums.length; j++) {
            if (j>i && nums[j]==nums[j-1]) continue;
            subset.add(nums[j]);
            backtrack(nums,j+1,subset);
            subset.removeLast();
        }

    }
}

