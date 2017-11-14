package easy;

public class Lit26 {

    // 删除有序数组中的重复元素
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ni = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == nums[ni]){
                continue;
            } else {
                nums[++ni] = nums[i];
            }
        }
        return ni+1;
    }
}
