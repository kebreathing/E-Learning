package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/21 22:25
 */
public class Lit260 {

    // nums 中 len(nums) - 2的元素出现2次
    // 只有2个元素出现一次
    // 求出这两个元素
    public int[] singleNumber(int[] nums) {
        // 第一次遍历可以获得两元素的 XOR值
        // XOR的结果 使所有元素中各比特位1的数量位奇数的元素
        // 最高赞数的答案是 diff &= -diff 什么意思？
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        // 负数在二进制中的表达：先求反码（取反），求补码（反码+1）
        // 该数的二进制和其补码求和&操作，是什么意思？找到不同的位置么？
        // 分组？
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            // 这个已经是在分组了！！
            if ((num & diff) == 0) // the bit is not set
                // 此组为：该位置为1的
                rets[0] ^= num;
            else // the bit is set
                // 此组为：不为1的
                rets[1] ^= num;

        }
        return rets;
    }

    public static void main(String[] args){
        Lit260 lit = new Lit260();
        System.out.println(lit.singleNumber(new int[]{1,2,1,3,2,5}));
    }
}
