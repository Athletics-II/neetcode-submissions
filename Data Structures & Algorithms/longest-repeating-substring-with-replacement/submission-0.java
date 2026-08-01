class Solution {
    public int characterReplacement(String s, int k) {
        HashSet<Character> st = new HashSet<>();
        for (char c : s.toCharArray()) {
            st.add(c);
        }
        int res=0;
        for (char c : st) {
            int window=0, l=0;
            for (int r=0; r<s.length(); r++) {
                if (s.charAt(r) == c) {
                    window++;
                }
                while (window + k < (r-l+1)) {
                    if (s.charAt(l)==c) window--;
                    l++;
                }
                res = Math.max(res, r-l+1);
            }
        }
        return res;
    }
}
