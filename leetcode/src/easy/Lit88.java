package easy;

public class Lit88 {

    // 将两个有序数组合并到nums1中
    // nums1 : 1 3 4 6 8
    // nums2 : 1 2 3 4 5
    // nums1 : 从前往后不可行，从后往前！
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || nums2.length == 0 || n == 0) return;
        int idx = m + n - 1;
        int i = m - 1, j = n - 1;
        while(idx >= 0){
            while(i >= 0 && j >= 0 && nums1[i] >= nums2[j]) {
                nums1[idx--] = nums1[i--];
            }

            while(j >= 0 && i >= 0 && nums1[i] < nums2[j]){
                nums1[idx--] = nums2[j--];
            }

            while(i >= 0 && j < 0) nums1[idx--] = nums1[i--];
            while(j >= 0 && i < 0) nums1[idx--] = nums2[j--];
        }
    }
}
