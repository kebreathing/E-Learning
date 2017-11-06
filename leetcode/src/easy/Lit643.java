package easy;

public class Lit643 {

    // 求和最大的长度为k的子序列的平均值
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0.0;
        int val = 0;
        for(int i = 0; i < k; val += nums[i++]);

        int i = 0, j = k;
        double max = val;
        while(j < nums.length){
            val = val - nums[i] + nums[j];
            max = Math.max(max,val);
            i++; j++;
        }

        return max / k;
    }
}
