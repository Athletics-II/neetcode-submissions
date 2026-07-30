class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq 
            = new PriorityQueue<>((a,b) -> b-a);
        for (int n : stones) {
            pq.offer(n);
        }
        while (pq.size() > 1) {
            int s1=pq.poll(); //largest
            int s2=pq.poll(); //second largest
            if (s1>s2) pq.offer(s1-s2);
        }

        pq.offer(0);
        return pq.peek();
    }
}
