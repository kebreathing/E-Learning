package medium;

import java.util.HashSet;
import java.util.Set;

public class Lit421 {

    // 找出数组中两元素XOR的最大值
    // 两元素不相邻!
    // bit manipulation 位操作
    // 不断缩减的过程：从最左到最右筛选的结果，从高位到低位
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i); // 求或：最左的位
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);// 各元素与mask求和
            }

            /* Use 0 to keep the bit, 1 to find XOR
             * 0 ^ 0 = 0
             * 0 ^ 1 = 1
             * 1 ^ 0 = 1
             * 1 ^ 1 = 0
             */
            int tmp = max | (1 << i); // in each iteration, there are pair(s) whoes Left bits can XOR to max
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)){
                    max = tmp;
                    break;
                }
            }
        }

        return max;
    }
}
