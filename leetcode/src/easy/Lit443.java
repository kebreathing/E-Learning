package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lit443 {
    // 字符串压缩
    // if freq == 1, 'a' 不需要加数字
    // if fre1 >  1, 'a', 'freq'
    // 还要修改原数组长度
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        List<Integer> cnts = new ArrayList<>();
        List<Character> chs = new ArrayList<>();

        int begin = 0, end = 0;
        while(end < chars.length){
            char ch = chars[begin];
            // 找到相同的元素
            while(end < chars.length && ch == chars[end])
                end++;
            chs.add(ch);
            cnts.add(end-begin);
            begin = end;
        }

        // 获得了所有元素，开始判断长度
        int compress = 0;
        List<Character> res = new LinkedList<>();
        for(int i = 0; i < chs.size();i++){
            if(cnts.get(i) == 1){
//                compress += 1;
                res.add(chs.get(i));
            } else {
                String len = cnts.get(i) + "";
//                compress += 1 + len.length();
                res.add(chs.get(i));
                for(int j = 0; j < len.length(); j++)
                    res.add(len.charAt(j));
            }
        }

        // 重新组合数组
        for(int i = 0; i < res.size(); i++)
            chars[i] = res.get(i);
        return res.size();
    }

    public static void main(String[] args){
        Lit443 lit = new Lit443();
        System.out.println(lit.compress(new char[]{'a','a','b'})); // a 2 b
        System.out.println(lit.compress(new char[]{'a','b','b'})); // a b 2
        System.out.println(lit.compress(new char[]{'a'}));         // a
        System.out.println(lit.compress(new char[]{'a','a','a','a','a'})); // a 5
        System.out.println(lit.compress(new char[]{'a','b','c','d'}));     // a b c d
        System.out.println(lit.compress(new char[]{'a','b','c','d','d','d','d','d','d','d','d','d','d'}));
        // a b c d 1 0
    }
}
