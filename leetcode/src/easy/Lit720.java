package easy;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Lit720 {

    // TreeSet 是有序的Set，对元素的操作时间复杂度为O(logn)
    // 数组排序，可知元素长度及字符排序结果
    // 删除最后一个元素，判断其前一个元素是否存在！
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new TreeSet<>();
        String res = "";
        for(String w : words){
            if(w.length() == 1 || set.contains(w.substring(0,w.length()-1))){
                res = w.length() > res.length() ? w : res;
                set.add(w);
            }
        }
        return res;
    }
}
