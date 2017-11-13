package easy;

import java.util.HashMap;
import java.util.Map;

public class Lit205 {

    // 异构体，题目要求的是格式相同
    public boolean isIsomorphic2(String s, String t) {
        if(s == null && t == null) return true;
        Map<Character, Integer> counter = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            counter.put(sch, counter.containsKey(sch)? counter.get(sch)+1 : 1);
            counter.put(tch, counter.containsKey(tch)? counter.get(tch)-1 : -1);
            if(counter.containsKey(sch) && counter.get(sch) == 0) counter.remove(sch);
            if(counter.containsKey(tch) && counter.get(tch) == 0) counter.remove(tch);
        }

        return counter.isEmpty();
    }

    // 形式相同
    // 不能用map，map无法确定该位置下对应的值
    // abcdefe
    // febcab
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        // 记录各字母的上一个位置，如果相同则继续，如果不同就退出
        // 没想明白为什么使用Map不可以
//        Map<Character, Integer> scnter = new HashMap<>();
//        Map<Character, Integer> tcnter = new HashMap<>();
//        for(int i = 0; i < s.length(); i++){
//            char sch = s.charAt(i);
//            char tch = t.charAt(i);
//
//            if(!scnter.containsKey(sch) && !tcnter.containsKey(tch)){
//                scnter.put(sch, i);
//                tcnter.put(tch, i);
//            } else if(scnter.containsKey(sch)
//                    && tcnter.containsKey(tch) && scnter.get(sch) != tcnter.get(tch)){
//                return false;
//            } else if(!scnter.containsKey(sch) || !tcnter.containsKey(tch)){
//                return false;
//            } else {
//                scnter.put(sch, i);
//                tcnter.put(tch, i);
//            }
//        }
        // 必须要元素对应才可以，而不只是记录上一个元素出现的下标
        int[] m = new int[512];
        for(int i = 0; i < s.length(); i++){
            if(m[s.charAt(i)] != m[t.charAt(i)+256])
                return false;
            m[s.charAt(i)] = m[t.charAt(i)+256] = i + 1;
        }
        return true;
    }

    public static void main(String[] args){
        Lit205 lit = new Lit205();
//        System.out.println(lit.isIsomorphic("abcdefgh","bcadefgh"));
//        System.out.println(lit.isIsomorphic("abcdefgh","bcadesgh"));
//        System.out.println(lit.isIsomorphic("egg","add"));
//        System.out.println(lit.isIsomorphic("foo","bar"));
        System.out.println(lit.isIsomorphic("paper","title"));
    }
}
