package medium;

import java.util.HashMap;
import java.util.Map;

public class Lit567 {
    // 判断 s2 中是否存在 s1 的任意置换序列
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        Map<Character,Integer> counter = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            counter.put(c,counter.containsKey(c)?counter.get(c)+1:1);
        }

        // ab 0-1
        // eidbaooo 0-7
        // dl = 0-5
        for(int i = 0; i <= s2.length() - s1.length(); i++){
            Map<Character,Integer> copy = new HashMap<>(counter);
            for(int j = i; j < i + s1.length(); j++){
                char c = s2.charAt(j);
                if(!copy.containsKey(c))
                    break;
                copy.put(c,copy.get(c) - 1);
                if(copy.get(c) == 0)
                    copy.remove(c);
            }

            if(copy.isEmpty()) return true;
        }

        return false;
    }

    public static void main(String[] args){
        Lit567 lit = new Lit567();
        System.out.println(lit.checkInclusion("ab","eidbaooo"));
        System.out.println(lit.checkInclusion("ab","eidoooba"));
        System.out.println(lit.checkInclusion("ab","eidooo"));
    }
}
