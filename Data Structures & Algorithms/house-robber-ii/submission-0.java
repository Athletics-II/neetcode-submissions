class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0], 
        Math.max(findMax(Arrays.copyOfRange(nums,0,nums.length-1)), 
        findMax(Arrays.copyOfRange(nums,1,nums.length))));
    }

    private int findMax(int[] nums) {
        int prev=0, curr=0;
        for (int num : nums) {
            int profit = Math.max(prev+num, curr);
            prev = curr;
            curr = profit;
        }
        return curr;
    }
}
