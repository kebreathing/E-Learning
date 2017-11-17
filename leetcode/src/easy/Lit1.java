package easy;

import java.util.HashMap;
import java.util.Map;

public class Lit1 {

    // 找到两元素之和为 target， 返回下标
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else{
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
