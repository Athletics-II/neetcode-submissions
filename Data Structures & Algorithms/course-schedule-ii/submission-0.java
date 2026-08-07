class Solution {
    public int[] findOrder(int required, int[][] prerequisites) {
        int[] indegree = new int[required], res = new int[required];
        //adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<required; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<required; i++) {
            if (indegree[i]==0) {
                q.add(i);
            }
        }

        int finished=0;
        while (!q.isEmpty()) {
            int node = q.poll();
            res[required-finished-1]=node;
            finished++;
            for (int n : adj.get(node)) {
                indegree[n]--;
                if (indegree[n]==0) {
                    q.add(n);
                }
            }
        }
        if (finished!=required) return new int[0];

        return res;
    }
}
