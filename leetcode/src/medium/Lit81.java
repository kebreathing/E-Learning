package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/22 13:11
 */
public class Lit81 {

    // 将递增数组左移n位（旋转），查找是否存在target
    // 有三种情况
    // 0 1 2 3(mid) 4 5 6   begin < mid < end -> end = mid
    // 4 5 6 0(pivot) 1 2 3 begin > mid && mid < end -> begin = mid
    // 2 3 4 5 6 0(pivot) 1 begin < mid && mid > end -> begin = mid
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int len = nums.length, begin = 0, end = len - 1;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            // 直接在过程中查找是否存在
            if (nums[mid] == target)
                return mid;

            if (nums[begin] < nums[mid] && nums[mid] < nums[end])
                end = mid;
            else if (nums[begin] > nums[mid] && nums[mid] < nums[end])
                end = mid;
            else if (nums[begin] < nums[mid] && nums[mid] > nums[end])
                begin = mid;
            else if(end - begin == 1){
                break;
            }
        }

        // Chech if begin is pivot
        int pivot = 0;
        if(nums[end] < nums[begin]) pivot = end;
        else                        pivot = begin;
        if(target >= nums[pivot] && target <= nums[len-1]){
            for(int i = pivot; i < len; i++)
                if(nums[i] == target)
                    return i;
        } else {
            for(int i = 0; i < pivot; i++)
                if(nums[i] == target)
                    return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Lit81 lit = new Lit81();
//        System.out.println(lit.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 6));
//        System.out.println(lit.search(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3}, 6));
//        System.out.println(lit.search(new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6}, 6));
//        System.out.println(lit.search(new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6}, 10));
        System.out.println(lit.search(new int[]{1}, 1));
        System.out.println(lit.search(new int[]{1}, -1));
    }
}
