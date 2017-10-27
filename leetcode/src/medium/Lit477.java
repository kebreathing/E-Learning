package medium;

public class Lit477 {

//    Elements of the given array are in the range of 0 to 10^9
//    Length of the array will not exceed 10^4.

    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // 超时
//        int dict = 0;
//        for(int i = 0; i < nums.length; i++)
//            for(int j = i + 1; j < nums.length; j++)
//                dict += Long.bitCount(nums[i] ^ nums[j]);
//        return dict;

        // int 类型 32bits
        // 每次只对每一位做 0 和 1 的统计，两类数量相乘
        int total = 0;
        for(int j = 0; j < 32; j++){
            int bitCount = 0;
            for(int i = 0; i < nums.length; i++){
                // 右移 == 删除最后1位， 和1做 &（与操作）
                // &： 1 & 1 = 1, 1 & 0 = 0, 0 & 0 = 0。同真为1，其余为0
                // 统计 1 的个数
                bitCount += (nums[i] >> j) & 1;
            }
            total += bitCount * (nums.length - bitCount);
        }
        return total;
    }
}
