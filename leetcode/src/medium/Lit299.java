package medium;

import java.util.HashMap;
import java.util.Map;

public class Lit299 {


    // 猜有多少个字母在正确的位置上，有多少个字母存在，但是位置错了
    public String getHint(String secret, String guess) {
        // 两字符串相同下标元素相减
        // 结果为 0， 相同元素在相同位置 BULL + 1
        // 结果不为0，统计双方个数
        int len = secret.length(), bulls = 0, cows = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        Map<Integer, Integer> mapg = new HashMap<>();
        for(int i = 0; i < len; i++){
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(s != g){
                maps.put(s, maps.containsKey(s)?maps.get(s) + 1: 1);
                mapg.put(g, mapg.containsKey(g)?mapg.get(g) + 1: 1);
            } else {
                bulls++;
            }
        }

        // 统计不相同的元素个数
        for(int ks : maps.keySet()){
            // 判断是否存在
            if(mapg.containsKey(ks)){
                cows += (maps.get(ks) > mapg.get(ks))? mapg.get(ks): maps.get(ks);
            }
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args){
        Lit299 lit = new Lit299();
//        System.out.println(lit.getHint("1123","0111"));
        System.out.println(lit.getHint("1807","7801"));
    }
}
