package medium;

import java.util.HashMap;
import java.util.Map;

public class Lit220 {

    // 重复元素的定义
    // i != j, |nums[i] - nums[j]| <= t, |i-j} <= k
    // 注意的是取值！！Int 还是 Long!
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;

        Map<Long, Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // bucket 思想：相减是一个范围的话，将这个范围变成一个桶扔进去
            long remapped_num = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remapped_num / ((long)t+1);

            // 存在于同一个桶
            if(map.containsKey(bucket))
                return true;
            // 和前一个桶对比
            if(map.containsKey(bucket-1) && remapped_num - map.get(bucket - 1) <= t)
                return true;
            // 和后一个桶对比
            if(map.containsKey(bucket+1) && map.get(bucket+1) - remapped_num <= t)
                return true;

            // 如果已经存储k个元素还没出现重复元素
            // 删除 i - k 下标的元素
            if(map.entrySet().size() >= k){
                long lastBuck = ((long) nums[i-k] - Integer.MIN_VALUE) / ((long)t+1);
                map.remove(lastBuck);
            }
            map.put(bucket, remapped_num);
        }
        return false;
    }
}
