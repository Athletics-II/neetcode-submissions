class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int res=0, prevEnd=intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            int currStart=intervals[i][0], currEnd=intervals[i][1];
            if (currStart < prevEnd) {
                prevEnd = Math.min(prevEnd, currEnd);
                res++;
            } else {
                prevEnd = currEnd;
            }
        }
        return res;
    }
}
