package medium;

import java.util.*;

public class Lit384 {
    // 打乱顺序 -> 恢复
    // Set 的实现是按照特点规律的!
    private int[] origin = null;
    private Random random;

    public Lit384(int[] nums) {
        if(nums == null) return;
        origin = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return  origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(origin == null) return null;
        int[] a = origin.clone();
        for(int j = 1; j < a.length; j++){
            int i = random.nextInt(j+1);
            swap(i,j,a);
        }
        return a;
    }

    private void swap(int i,int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
