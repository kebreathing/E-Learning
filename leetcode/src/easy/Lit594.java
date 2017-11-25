package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/25 9:25
 */
public class Lit594 {

    // 找到最长的和谐子序列
    // 子序列：最大和最小值相差为1
    public int findLHS(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+ 1);
        }

        int max = Integer.MIN_VALUE;
        for(int key : map.keySet()){
            if(map.containsKey(key-1)){
                max = Math.max(max, map.get(key) + map.get(key-1));
            }

            if(map.containsKey(key+1)){
                max = Math.max(max, map.get(key) + map.get(key+1));
            }
        }

        return max == Integer.MIN_VALUE? 0 : max;
    }
}
