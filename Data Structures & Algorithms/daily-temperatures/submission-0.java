class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{temperatures[0],0});
        
        for (int future=1; future<temperatures.length; future++) {
            int t = temperatures[future];

            while (!s.isEmpty() && t > s.peek()[0]) {
                int day = s.peek()[1];
                res[day] = future-day;
                s.pop(); // found warmer, no more use for that day
            }

            s.push(new int[]{t,future});
        }
        return res;
    }
}
