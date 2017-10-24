package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lit628 {

    private int _prod = Integer.MIN_VALUE;
    // 求数组中三个数字相乘的最大乘积
    // nums： [-1000,1000]
    // 最大乘积不超过Integer

    public int maximumProduct(int[] nums){
        int len = nums.length;

        Arrays.sort(nums);

        int zero = 0;
        while(zero < len && nums[zero] < 0) zero++;
        // 全负数
        if(zero == len)                 return nums[len-1] * nums[len-2] * nums[len-3];
        // 全正数
        if(zero == 0 && nums[0] >= 0)   return nums[len-1] * nums[len-2] * nums[len-3];
        // 一个负数
        if(zero == 1)                   return nums[len-1] * nums[len-2] * nums[len-3];

        // 负数不只有一个
        // 两负一正 三正
        int a = nums[len-1] * nums[len-2] * nums[len-3];
        int b = nums[0] * nums[1] * nums[len-1];
        return Math.max(a,b);
    }

    // 暴力破解法：效率低
    public int maximumProduct2(int[] nums) {
        // sort the Array
        Arrays.sort(nums);

        // dfs
        dfs(0,1,3,nums);
        return _prod;
    }

    private void dfs(int idx,int prod, int n,int[] nums){
        if(n == 1){
            _prod = Math.max(_prod, prod * nums[idx]);
        } else {
            for(int i = idx; i < nums.length; i++){
                dfs(i+1,prod * nums[i],n-1,nums);
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        Lit628 lit = new Lit628();
        System.out.println(lit.maximumProduct(nums));
    }
}
