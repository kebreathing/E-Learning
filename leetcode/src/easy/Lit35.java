package easy;

public class Lit35 {

    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;

        int begin = 0, end = nums.length - 1;
        while(begin < end){
            int mid = begin + (end - begin) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        if(nums[begin] <  target) return begin + 1;
        else                           return begin;

    }
}
