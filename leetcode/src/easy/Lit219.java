package easy;

import java.util.HashMap;
import java.util.Map;

public class Lit219 {

    // 找到是否存在 nums[i] = nums[j] 且  0 < j - i <= k
    // j != i
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        if(k == 0) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
            else if(i - map.get(nums[i]) <= k)
                return true;
            else
                map.put(nums[i], i);
        }

        return false;
    }
}
