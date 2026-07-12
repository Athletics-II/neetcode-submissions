/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (Interval i : intervals) {
            mp.put(i.start, mp.getOrDefault(i.start, 0)+1);
            mp.put(i.end, mp.getOrDefault(i.end, 0)-1);
        }
        int current=0, rooms=0;
        for (int key : mp.keySet()) {
            current+=mp.get(key);
            rooms=Math.max(current, rooms);
        }

        return rooms;
    }
}
