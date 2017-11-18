package easy;

import java.util.HashMap;
import java.util.Map;

public class Lit290 {

    // 判断str中的单词是否是按pattern的模式进行的
    public boolean wordPattern(String pattern, String str) {
        if(str == null || str.length() == 0) return false;

        String[] strs = str.split(" ");
        if(strs.length != pattern.length()) return false;

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> cmap= new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(!map.containsKey(c) && !cmap.containsKey(strs[i])){
                map.put(c, strs[i]);
                cmap.put(strs[i], c);
            } else if(map.containsKey(c) && !cmap.containsKey(strs[i])){
                return false;
            } else if(!map.containsKey(c) && cmap.containsKey(strs[i])){
                return false;
            } else if(!map.get(c).equals(strs[i])){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){

    }
}
