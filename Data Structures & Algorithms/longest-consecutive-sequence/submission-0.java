class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int res = 0;
        for (int i : nums) {
            s.add(i);
        }
        for (int i : s) {
            if (!s.contains(i-1)) {
                int streak = 1;
                while (s.contains(i+streak)) {
                    streak++;
                }
                res = Math.max(res, streak);
            }
        }

        return res;
    }
}
