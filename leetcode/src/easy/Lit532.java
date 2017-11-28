package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lit532 {

    // 找pair，定义为nums内两元素之差为k
    // 返回唯一键值对个数
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        int cnt = 0;
        for(int n : map.keySet()){
            if(k == 0){
                if(map.get(n) > 1) {
                    cnt++;
                    map.put(n, 0);
                }
            } else {
                int a = n - k; // n - m = k
                int b = n + k; // m - n = k
                if (map.containsKey(a) && map.get(a) > 0)
                    cnt++;
                if (map.containsKey(b) && map.get(b) > 0)
                    cnt++;
                map.put(n, 0);
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Lit532 lit = new Lit532();
//        System.out.println(lit.findPairs(new int[]{3,1,4,1,5}, 2));
//        System.out.println(lit.findPairs(new int[]{3,1,4,1,5}, 0));
        System.out.println(lit.findPairs(new int[]{1,1,1,2,1}, 0));
    }
}
