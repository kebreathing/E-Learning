package hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 找到字符串s中包含words数组内所有单词连接的子字符串的下标
public class Lit30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0)  return res;

        // 统计个数
        Map<String, Integer> counter = new HashMap<>();
        for(String w : words) counter.put(w,counter.containsKey(w) ? counter.get(w) + 1: 1);

        int L = words[0].length();
        int N = s.length() - L * words.length;
        // 最后检验的下标
        for(int i = 0; i <= N; i++){
            Map<String, Integer> copy = new HashMap<String, Integer>(counter);
            for(int j = 0; j < words.length; j++){
                String word = s.substring(i + j * L ,i + j * L + L); // 单词的长度
                if(copy.containsKey(word)){
                    int count = copy.get(word);
                    if(count == 1) copy.remove(word);
                    else           copy.put(word,count-1);
                    if(copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                }
            }

            if(copy.isEmpty()) i += L * words.length - 1;
        }

        return res;
    }

    public static void main(String[] args){
        Lit30 lit = new Lit30();
        List<Integer> res = lit.findSubstring("barfoothefoobarman",new String[]{"foo","bar"});
        for(int i : res)
            System.out.println(i);
    }
}
