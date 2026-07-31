class Solution {
    public String longestPalindrome(String s) {
        int residx=0, reslen=0;
        char[] arr = s.toCharArray();

        for (int i=0; i<arr.length; i++) {
            // odd
            int l=i, r=i;
            while (l>=0 && r<arr.length && arr[l]==arr[r]) {
                if (r-l+1 > reslen) {
                    residx=l;
                    reslen=r-l+1;
                }
                l--;
                r++;
            }

            // even
            l=i;
            r=i+1;
            while (l>=0 && r<arr.length && arr[l]==arr[r]) {
                if (r-l+1 > reslen) {
                    residx=l;
                    reslen=r-l+1;
                }
                l--;
                r++;
            }
        }
        return s.substring(residx, residx+reslen);
    }
}
