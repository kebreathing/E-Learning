package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/4 18:46
 */
public class Lit442 {

    // 1 ≤ a[i] ≤ n (n = size of array)
    // 找到Nums中所有出现次数=2的元素
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;


        // 由于元素的取值范围都在 1 - n之间，所以可以直接交换顺序
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 == i || nums[i] == 0)
                continue;
            else if(nums[i] == nums[nums[i]-1]){
                res.add(nums[i]);
                nums[i] = 0;
            } else{
                // 元素不相同，交换
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args){
        Lit442 lit = new Lit442();
        System.out.println(lit.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}
