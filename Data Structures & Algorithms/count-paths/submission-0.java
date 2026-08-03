class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);
        for (int i=m-2; i>=0; i--) {
            for (int j=n-2; j>=0; j--) {
                row[j] += row[j+1];
            }
        }
        return row[0];
    }
}
