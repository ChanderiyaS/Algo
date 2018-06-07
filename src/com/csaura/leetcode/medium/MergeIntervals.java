package com.csaura.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 */


class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() ==0)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start == i2.start ? i1.end - i2.end  : i1.start-i2.start;
            }
        });

        List<Interval> ans = new ArrayList<>();
        int start = intervals.get(0).start ,end = intervals.get(0).end;

        for(Interval i : intervals){
            if(i.start <= end){

                end = Math.max(end,i.end);
            }
            if(i.start > end){
                //System.out.println(i.start + " -- " + i.end);
                ans.add(new Interval(start,end));
                start = i.start;
                end = i.end;
            }
        }
        ans.add(new Interval(start,end));
        return ans;
    }
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
