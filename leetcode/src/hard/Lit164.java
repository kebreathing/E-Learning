package hard;

import java.util.Arrays;

public class Lit164 {

    // 无序数组，找到该数组排序后的相邻元素的最大差值
    // 桶排序是O(N)的算法
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;

        int min = nums[0];
        int max = nums[0];
        for(int i : nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }

        // Minimum Possible gap, ceiling of the integer division
        // 最小可能的gap
        int gap = (int) Math.ceil((double)(max-min)/(nums.length-1));
        // 桶的长度会因为分组而减少
        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMin,Integer.MAX_VALUE);
        Arrays.fill(bucketMax,Integer.MIN_VALUE);

        // Put numbers into buckets
        for(int i : nums){
            if(i == min || i == max)
                continue;

            int idx = (i-min)/gap; // 找到下标
            bucketMin[idx] = Math.min(i,bucketMin[idx]); // 桶里最小
            bucketMax[idx] = Math.max(i,bucketMax[idx]); // 桶里最大
            //  Q: 不一定连续呢？
            //  A: 桶内连续元素之差肯定不会是最大的，最大的就分桶
        }

        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        // previous 设为 min 的原因: 算法第一次运算是 min - min，然后更新 previous = max
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++){
            // No Elements in the bucket
            if(bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE)
                continue;

            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap,bucketMin[i] - previous);

            // update previous bucket value
            // 因为需要元素相邻，所以才要不断更新
            previous = bucketMax[i];
        }

        // 最大 Gap 只有可能出现的两桶之间
        // 桶内的元素相邻值必定不是最大的
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;

    }

//        Time Limit Exceed.
//        Arrays.sort(nums);
//        int maxdir = 0;
//        for(int i = 1; i < nums.length; i++){
//            maxdir = Math.max(maxdir,nums[i] - nums[i-1]);
//        }
//        return maxdir;

    public static void main(String[] args){

    }
}
