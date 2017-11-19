package medium;

import java.util.Arrays;

public class Lit377 {

    private int[] dp;
    // nums 正整数 且 不含重复元素
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }


    private int helper(int[] nums, int target){
        if(dp[target] != -1)
            return dp[target];

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(target >= nums[i]){
                res += helper(nums, target - nums[i]);
            }
        }

        dp[target] = res;
        return res;
    }

    public int combinationSum4_2(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        // 排序
        Arrays.sort(nums);
        return dfs(0, target, nums);
    }

    private int dfs(int sum, int target, int[] nums){
        if(sum == target){
            return 1;
        } else {
            int total = 0;
            for(int i = 0; i < nums.length && sum + nums[i] <= target; i++){
                total += dfs(sum + nums[i], target, nums);
            }
            return total;
        }
    }

    public static void main(String[] args){
        Lit377 lit = new Lit377();
//        System.out.println(lit.combinationSum4(new int[]{1,2,3}, 4));
        System.out.println(lit.combinationSum4(new int[]{1,2,3}, 32));
    }
}
