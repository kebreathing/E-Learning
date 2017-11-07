package hard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// 很厉害！！
// Binary search 的变型！
// Kth 可以用二分查找的办法！！
public class Lit719 {

    // 二分搜索法  Binary Search
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        // 最小距离
        int low = nums[1] - nums[0];
        for(int i = 1; i < nums.length - 1; i++)
            low = Math.min(low, nums[i+1] - nums[i]);

        // 最大距离
        int high = nums[nums.length - 1] - nums[0];
        while(low < high){
            // Binary Search!
            // mid : 是取值！不是下标
            // 原本的下标：变成了pairs的个数
            int mid = low + (high - low) / 2;
            if(countPairs(nums, mid) < k){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // 原始的计算
    // mid 是指定的值，两数只差小于等于 mid
    private int countPairs2(int[] a, int mid) {
        int n = a.length, res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            // a 是递增数组
            // 找到 a[j] - a[i] <= mid 的个数
            while (j < n && a[j] - a[i] <= mid) j++;
            // 获得个数，实际上的个数是  j-i+1（从i+1到j)
            res += j - i - 1;
        }
        return res;
    }

    // 参数：数组 + 中间大小元素
    // 目标：计算比mid的值小的对数
    private int countPairs(int[] a, int mid){
        int n = a.length, res = 0;
        for(int i = 0; i < n; i++){
            // a[j] - a[i] <= mid
            // a[j] = a[i] + mid 找到a[j]最大的下标，并统计个数
            res += upperBound(a, i, n-1, a[i] + mid) - i - 1;
        }
        return res;
    }

    // 直接二分查找：Direct Binary Search
    private int upperBound(int[] a, int low, int high, int key){
        if(a[high] <= key) return high + 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(a[mid] <= key){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
