class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (a[0] - b[0])
        );
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            maxHeap.offer(new int[]{e.getValue(), e.getKey()});
            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[] res = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = maxHeap.poll()[1];
        }

        return res;
    }
}
