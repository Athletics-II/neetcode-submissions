class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, boolean[] picks, List<Integer> subset) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
        }

        for (int i=0; i<nums.length; i++) {
            if (!picks[i]) {
                subset.add(nums[i]);
                picks[i] = true;
                backtrack(nums, picks, subset);

                subset.removeLast();
                picks[i] = false;          
            }
        }

    }
}
