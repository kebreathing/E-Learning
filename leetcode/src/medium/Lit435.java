package medium;

import java.util.*;

public class Lit435 {

    // 数组的题目是弱项！
    // 删除最小数量的 interval 让剩下的 intervals 不重叠
    // [1,2] [1,3] [1,4] [2,3] [3,4]
    // [1,2] [1,6] [2,5]
    // [1,2] [1,6] [3,4]
    // [1,2] [1,6] [2,10] [3,7] [4,8] [7,9]
    // [1,10] [2,4] [5,9]
    // 排序 分类 递归判断大小
    public int eraseOverlapIntervals(Lit264.Interval[] intervals) {
        // Interval 排序
        Map<Integer,Integer> map = new HashMap<>();
        for(Lit264.Interval inl : intervals){
            if(!map.containsKey(inl.start))
                map.put(inl.start,inl.end);
            else
                map.put(inl.start, Math.min(inl.end, map.get(inl.start)));
        }

        // 保留 start 的最小元素
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for(int key : map.keySet())
            starts.add(key);

        Collections.sort(starts);
        for(int key : starts)
            ends.add(map.get(key));

        // 只要存在包含的行为，就要删除
        int counter = 0;
        int size = starts.size();
        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
                if(ends.get(i) > starts.get(j)){
                    // 包含 [1,10] [2,8]
                    counter++;
                    break;
                }
            }
        }
        // 总的长度 - 过滤后的数组大小 + 要删除的个数
        int del = counter + intervals.length - starts.size();
        return del;
    }


    // 思路都是：选取最小的！
    public int eraseOverlapIntervals2(Lit264.Interval[] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }

    class myComparator implements Comparator<Lit264.Interval> {
        public int compare(Lit264.Interval a, Lit264.Interval b) {
            return a.end - b.end;
        }
    }
    public static void main(String[] args){
        Lit264.Interval[] intervals = {
                new Lit264.Interval(3,4),
                new Lit264.Interval(1,4),
                new Lit264.Interval(1,3),
                new Lit264.Interval(1,2),
                new Lit264.Interval(2,3)
        };

        Lit435 lit = new Lit435();
        lit.eraseOverlapIntervals(intervals);
    }
}


