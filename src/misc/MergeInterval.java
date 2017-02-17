package misc;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 * Created by jli on 1/6/16.
 */
public class MergeInterval {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
//        if (intervals == null || intervals.size() <= 1) {
//            return intervals;
//        }
//
//        Collections.sort(intervals, new IntervalComparator());
//
//        ArrayList<Interval> rst = new ArrayList<Interval>();
//        Interval last = intervals.get(0);
        return null;

    }

    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}

