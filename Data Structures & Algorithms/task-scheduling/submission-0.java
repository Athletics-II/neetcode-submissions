class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f>0) pq.add(f);
        }

        int time=0;
        Queue<int[]> q = new LinkedList<>();
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (pq.isEmpty()) {
                time = q.peek()[1];
            } else {
                int task = pq.poll()-1;
                if (task>0) {
                    q.offer(new int[]{task, time+n});
                }
            }

            if (!q.isEmpty() && q.peek()[1]==time) {
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}
