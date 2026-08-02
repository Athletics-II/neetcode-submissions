class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i=1; i<intervals.length; i++) {
            int s=intervals[i][0], e=intervals[i][1];
            int lastend=res.getLast()[1];
            if (s<=lastend) {
                res.getLast()[1] = Math.max(lastend, e);
            } else {
                res.add(new int[]{s, e});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
