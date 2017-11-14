package medium;

public class Lit540 {

    public int singleNonDuplicate(int[] nums) {
        int single = nums[0];
        for(int i = 1; i < nums.length; i++)
            single ^= nums[i];
        return single;
    }
}
