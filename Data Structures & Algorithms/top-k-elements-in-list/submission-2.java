class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];
        for (int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            mp.put(n, mp.getOrDefault(n, 0)+1);
        }

        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            freq[e.getValue()].add(e.getKey());
        }

        int[] res = new int[k];
        int idx=0;
        for (int i=freq.length-1; i>=0; i--) {
            for (int n : freq[i]) {
                res[idx] = n;
                idx+=1;
            }
            if (idx == k) return res;
        }
        return res;
    }
}
