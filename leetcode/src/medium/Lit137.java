package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/21 22:04
 */
public class Lit137 {
    // nums 中所有元素除了某一个之外，都出现三次
    // 只有一个元素只出现了一次

    // 如何不用统计的方式去做？
    // 不适用额外的内存空间实现搜索
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int res = nums[0];
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                res = key;
                break;
            }
        }
        return res;
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int j = 0; j < nums.length; j++){
                if(((nums[j] >> i) & 1) == 1){
                    sum++;
                    sum %= 3;
                }
            }

            if(sum != 0){
                // | 可以理解为是加上去
                ans |= sum << i;
            }
        }
        return ans;
    }
}
