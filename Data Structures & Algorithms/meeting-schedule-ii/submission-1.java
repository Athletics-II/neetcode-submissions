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
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for (int i=0; i<intervals.size(); i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int toStart=0, toEnd=0, current=0, rooms=0;
        while (toStart <= intervals.size()-1) {
            if (starts[toStart] < ends[toEnd]) {
                toStart+=1;
                current+=1;
            } else {
                toEnd+=1;
                current-=1;
            }
            rooms = Math.max(current, rooms);
        }

        return rooms;
    }
}
