package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/22 19:02
 */
public class Lit409 {
    // 字符串中的字母s，组成最长回文序列
    public int longestPalindrome(String s) {
        if(s == null) return 0;

        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.get(ch) == 2){
                map.put(ch, 0);
                len += 2;
            }
        }

        return len == s.length()? len : len + 1;
    }

    public static void main(String[] args){
        Lit409 lit = new Lit409();
        System.out.println(lit.longestPalindrome("aaaaaaa"));
        System.out.println(lit.longestPalindrome("cccccc"));
        System.out.println(lit.longestPalindrome("abccccdd"));
    }
}
