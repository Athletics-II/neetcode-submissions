class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=1, total=0;
        for (int i : piles) {
            if (i>max) max=i;
            total+=i;
        }
        int l=1;
        while (l<max) {
            int mid = l+(max-l)/2, t=0;
            for (int i : piles) {
                t+= Math.ceil((double)i/mid);
            }

            if (t <= h) {
                max = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
}
