class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int res=0, l=0;
        for (int r=0; r<s.length(); r++) {
            if (mp.containsKey(s.charAt(r))) {
                l = Math.max(l, mp.get(s.charAt(r))+1);
            }
            mp.put(s.charAt(r), r);
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
