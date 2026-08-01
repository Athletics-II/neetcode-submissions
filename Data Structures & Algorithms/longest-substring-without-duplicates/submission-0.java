class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int res=0, l=0;
        for (int r=0; r<s.length(); r++) {
            while (st.contains(s.charAt(r))) {
                st.remove(s.charAt(l));
                l++;
            }
            st.add(s.charAt(r));
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
