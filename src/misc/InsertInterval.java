package misc;

import java.util.ArrayList;
/**
 * Created by jli on 12/30/15.
 */
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (newInterval == null || newInterval == null) {
            return intervals;
        }

        ArrayList<Interval> rst = new ArrayList<Interval>();
        int pos = 0;

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                rst.add(interval);
                pos ++;
            } else if (newInterval.end < interval.start) {
                rst.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        rst.add(pos, newInterval);
        return rst;
    }
}
