class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> sqrs = new HashMap<>();

        for (int r=0; r<9; r++) {
            for (int c=0; c<9; c++) {
                char x = board[r][c];
                if (x == '.') continue;
                String key = (r/3)+","+(c/3);
                if (rows.computeIfAbsent(r, k->new HashSet<>()).contains(x) || cols.computeIfAbsent(c, k->new HashSet<>()).contains(x) || sqrs.computeIfAbsent(key, k->new HashSet<>()).contains(x)) {
                    return false;
                }

                rows.get(r).add(x);
                cols.get(c).add(x);
                sqrs.get(key).add(x);
            }
        }
        return true;
    }
}
