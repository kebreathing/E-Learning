package medium;

import java.util.*;

public class Lit524 {

    // 从序列d中，删除s中最少字母
    // 有顺序之说
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;

            if (i == dictWord.length() && dictWord.length() >= longest.length())
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                    longest = dictWord;
        }
        return longest;
    }

    public static void main(String[] args){

        List<String> d = new ArrayList<>();
        String[] strs = new String[]{"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"};
        for(String s : strs) d.add(s);

        Lit524 lit = new Lit524();
        System.out.println(lit.findLongestWord("aewfafwafjlwajflwajflwafj", d));
    }
}
