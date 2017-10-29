package hard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Unsolved!
public class Lit719 {
    public int smallestDistancePair(int[] nums, int k) {
        // 暴力破解法
        int idx = 0;
        Arrays.sort(nums);
        List<Integer> unique = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(unique.isEmpty())
                unique.add(nums[i]);
            else if(nums[i] != unique.get(unique.size()-1))
                unique.add(nums[i]);
        }

        // 如果 nums 中不存在重复元素，以上操作（除排序外； Waste Time!
        // nums 共有 nums.length - 1 * nums.length / 2 对
        // 经过缩减之后，k 的取值范围就变小，容易出现问题。
        List<Integer> diff = new ArrayList<>();
        for(int i = 0; i < unique.size(); i++){
            for(int j = i + 1; j < unique.size(); j++){
                diff.add(unique.get(j) - unique.get(i));
            }
        }

        Collections.sort(diff);
        return diff.get(k-1);
    }
}
