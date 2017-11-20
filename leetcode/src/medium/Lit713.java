package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/20 19:36
 */
public class Lit713 {

    // 统计数组nums中，连续子数组元素之和小于k的（不能等于）
    public int numSubarrayProductLessThanK(int[] nums, int k){
        if(k < 2) return 0;

        int result = 0;
        int product = 1;
        for(int i = 0, right = 0; right < nums.length; right++){
            product *= nums[right];
            while(i < nums.length && product >= k){
                product /= nums[i++];
            }
            result += right - i + 1; // 等同于 1 + 2 + 3 + 4 和初始的结果是一样的
        }

        return result;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;

        // 暴力破解法: Time limit exceed!
        long count = 0;
        int begin = 0, end = 0, len = nums.length;
        while(begin < len){
            // 开始统计
            int product = 1;
            while(end < len && product * nums[end] < k){
                product *= nums[end];
                count++;
                end++;
            }

            // 统计结束的条件： end >= len || product >= k
            if(end >= len && product < k){
                // 后面的所有元素都不需要再进行遍历，因为元素相乘都小于k
                // 元素从begin+1开始
                int rest_len = nums.length - begin - 1;
                count += ((long)(1+rest_len) * (long)rest_len) / 2;
                break;
            }
            begin++;
            end = begin;
        }

        return (int)count;
    }

    public static void main(String[] args){
        Lit713 lit = new Lit713();
        System.out.println(lit.numSubarrayProductLessThanK(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 9));
    }
}
