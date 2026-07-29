class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] presum = new int[nums.length];
        presum[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            presum[i] = presum[i-1] * nums[i];
        }

        int[] suffixsum = new int[nums.length];
        suffixsum[nums.length-1] = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            suffixsum[i] = suffixsum[i+1] * nums[i];
        }

        int[] res = new int[nums.length];
        res[0] = suffixsum[1];
        res[nums.length-1] = presum[nums.length-2];
        for (int i=1; i<nums.length-1; i++) {
            res[i] = presum[i-1] * suffixsum[i+1];
        }
        return res;
    }
}  
