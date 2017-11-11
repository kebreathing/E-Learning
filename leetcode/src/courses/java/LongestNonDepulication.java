package courses.java;

import java.util.*;

public class LongestNonDepulication {

    public static int longest(String str){
        if(str == null || str.length() == 0) return 0;

        int len = str.length();
        int begin = 0, end = 0, counter = 0;
        Map<Character,Integer> map = new HashMap<>();

        // 应该要跳到出现重复字母的位置
        while(end < len){
            map.clear();
            while(end < len && !map.containsKey(str.charAt(end))) {
                map.put(str.charAt(end),end);
                end++;
            }

            if(end >= len) break;

            // end 是重复的元素
            int pre = map.get(str.charAt(end));
            counter = Math.max(counter, map.size());
            begin = pre+1;
            end = begin;
        }

        return Math.max(counter, end - begin);
    }

    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       while(sc.hasNext()){
           String str = sc.nextLine();
           System.out.println(longest(str));
       }
       sc.close();
    }
}
