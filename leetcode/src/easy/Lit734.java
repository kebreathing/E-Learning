package easy;

import java.util.*;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/30 19:58
 */
public class Lit734 {

    // 判断两字符串是否相似
    // 相似的词不传递，但是对称
    // 长度必须相同
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null && words2 == null) return true;
        if(words1 == null || words2 == null || words1.length != words2.length) return false;

        // Count
        Map<String, Set<String>> similar = new HashMap<>();
        for(int i = 0; i < pairs.length; i++){
            if(!similar.containsKey(pairs[i][0]))
                similar.put(pairs[i][0], new HashSet<>());
            if(!similar.containsKey(pairs[i][1]))
                similar.put(pairs[i][1], new HashSet<>());
            similar.get(pairs[i][0]).add(pairs[i][1]);
            similar.get(pairs[i][1]).add(pairs[i][0]);
        }

        // 判断是否相同
        for(int i = 0; i < words1.length; i++){
            String s1 = words1[i];
            String s2 = words2[i];

            // 判断similar中是否存在
            if(s1.equals(s2)) continue;
            if(similar.containsKey(s1) && similar.containsKey(s2)
                    && similar.get(s1).contains(s2)) continue;
            return false;
        }

        return true;
    }
}
