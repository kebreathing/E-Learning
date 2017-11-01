package medium;

import java.util.HashSet;
import java.util.Set;

public class Lit676 {

    // 实际上就是暴力破解法
    // 另一种办法就是拆分，取出每个 i 作为key，其余的作为value
    private Set<String> set;
    /** Initialize your data structure here. */
    public Lit676() {
        set = null;
        set = new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        if(dict == null || dict.length == 0) return;
        for(String word : dict)
            set.add(word);
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(set.isEmpty()) return false;
        if(word == null || word.length() == 0) return false;

        char[] chs = word.toCharArray();
        for(int i = 0; i < chs.length; i++){
            char c = chs[i];
            for(char ch = 'a'; ch <= 'z'; ch++){
                if(ch == c) continue;
                chs[i] = ch;
                if(set.contains(new String(chs)))
                    return true;
            }
            chs[i] = c;
        }
        return false;
    }

    public static void main(String[] args){
        Lit676 lit = new Lit676();
        lit.buildDict(new String[]{"hello","hallo","leetcode"});
        System.out.println(lit.search("hello"));
        System.out.println(lit.search("hhllo"));
        System.out.println(lit.search("hallo"));
        System.out.println(lit.search("leetcode"));
    }
}
