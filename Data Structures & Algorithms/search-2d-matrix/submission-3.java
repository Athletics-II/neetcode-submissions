class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int top=0, bottom=m-1;
        while (top <= bottom) {
            int mid = (top+bottom)/2;
            if (target < matrix[mid][0]) {
                bottom = mid-1;
            } else if (target > matrix[mid][n-1]) {
                top = mid+1;
            } else break;
        }
        if (top > bottom) return false;

        int[] row = matrix[(top+bottom)/2];
        int left=0, right=n-1;
        while (left < right) {
            int mid = (left+right)/2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return row[left]==target;
    }
}
