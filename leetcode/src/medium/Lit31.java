package medium;

import java.util.ArrayList;

public class Lit31 {

    // nums: 输入的数组
    // 将该数组重新组织成他下一个比他大的值
    // 1. 升序： 直接交换最后两元素
    // 2. 逆序： 直接将数组逆序
    // 3. 非单一序列：找出最后一个峰值的下标
    // 3-1. 如果最后元素个数小于等于2 或 最后元素序列为逆序
    // ---------------------------------------------
    // 从后往前查找：
    // if nums[i] > nums[i-1], swap(i,i-1)
    // if nums[i] == nums[i-1], i--
    // 还要补充 left 与 right 和 最后元素的值 (相同)
    // 但是最终还是fail： 1,3,2 -> 2,3,1  --> 2,1,3
    // 思路是类似的: 但是他只执行了两次
    // --------------------------------------------
    // Example:
    // 1637899954
    // 1. find 8
    // 2. find the last 9
    // 3. swap 1637 /8/ 99 /9/ 54
    // 4. reverse 16379-45899
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int len = nums.length;
        int index = len - 1;
        while(index > 0){
            // 1 3 2
            // stop: index = 1(3)
            if(nums[index-1] < nums[index])
                break;
            index--;
        }

        if(index == 0){
            // 逆序
            reverse(nums,0, len-1);
            return;
        } else {
            // val = 0(1)
            int val = nums[index-1];
            int j = len - 1; // 最后一个元素
            while(j >= index){
                // j = 2(2) <- 2 > 1
                if(nums[j] > val)
                    break;
                j--;
            }
            // 找到一个比val大的值，交换
            // from 132 to 231
            swap(index-1, j, nums);
            // from 231 to 213 (后面元素再逆序)
            reverse(nums,index,len-1);
        }

    }

    private void reverse(int[] nums,int i,int j){
        for(; i < j; i++, j--){
            swap(i,j,nums);
        }
    }

    private void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args){
        Lit31 lit = new Lit31();
//        lit.nextPermutation(new int[]{1,2,3,4,5,6});
//        lit.nextPermutation(new int[]{6,5,4,3,2,1});
//        lit.nextPermutation(new int[]{});
//        lit.nextPermutation(new int[]{1});
        lit.nextPermutation(new int[]{1,3,2});
//        lit.nextPermutation(new int[]{1,3,4,5,7,7,7,7,5,4});
//        lit.nextPermutation(new int[]{1,3,4,4,4,3,6,7,5});
    }
}
