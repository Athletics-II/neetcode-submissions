class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int nrs=grid.length, ncs=grid[0].length, fresh=0, time=0;
        Queue<int[]> q = new ArrayDeque<>();

        for (int r=0; r<nrs; r++) {
            for (int c=0; c<ncs; c++) {
                if (grid[r][c]==1) fresh++;
                if (grid[r][c]==2) q.offer(new int[]{r,c});
            }
        }

        while (fresh>0 && !q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] fruit = q.poll();
                int r=fruit[0], c=fruit[1];
                for (int[] dir : directions) {
                    int nr=r+dir[0], nc=c+dir[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc]=2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                    }
                } 
            }
            time++;
        }
        return fresh==0 ? time : -1;
    }
}
