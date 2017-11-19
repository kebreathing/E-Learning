package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/19 19:08
 */
public class Lit729 {

    // 实现一个日期预约表
    // start end 表示已经被预约的时间
    // 如果该日期已经被预约不能够预约成功，return false
    // 否则 return true
    // 半开半闭区间
    // 如何搜索
    List<int[]> events = null;
    public Lit729() {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if(events.isEmpty()){
            events.add(new int[]{start, end});
            return true;
        } else {
            // events 不为空
            // binary search
            int i = 0, j = events.size() - 1;
            while(i < j){
                int mid = i + (j-i) / 2;
                int[] mid_date = events.get(mid);
                // 重写规则
                if(mid_date[0] <= start && start < mid_date[1])
                    return false;
                if(mid_date[0] < end && end < mid_date[1])
                    return false;
                if(mid_date[0] >= start && mid_date[1] <= end)
                    return false;
                if(end <= mid_date[0]){
                    j = mid - 1;
                } else if(start >= mid_date[1]){
                    i = mid + 1;
                }
            }

            // 获得该事件应该插入的位置
            int[] cur = events.get(i);
            if(start >= cur[1] || end <= cur[0]){
                events.add(new int[]{start, end});
                Collections.sort(events, new DateComparator());
                return true;
            }
            return false;
        }
    }

    class DateComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[0], o2[0]);
        }
    }

    public static void main(String[] args){
        Lit729 lit = new Lit729();
        System.out.println(lit.book(47, 50));
        System.out.println(lit.book(33, 41));
        System.out.println(lit.book(39, 45));
        System.out.println(lit.book(33, 42));
        System.out.println(lit.book(25, 32));
        System.out.println(lit.book(26, 35));
        System.out.println(lit.book(19, 25));
        System.out.println(lit.book(3, 8));
        System.out.println(lit.book(8, 13));
        System.out.println(lit.book(18, 27));
    }
}

//        System.out.println(lit.book(10, 20));   // true
//        System.out.println(lit.book(10, 20));   // false
//        System.out.println(lit.book(15, 25));   // false
//        System.out.println(lit.book(20, 25));   // true
