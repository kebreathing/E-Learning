package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lit658 {

    // arr: A sorted Array
    // 找到和元素 x 最近的 k 个元素
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0 || k == 0) return res;

        // 思路：
        // 1. BS 找到元素位置
        // 2. 左右指针删减并加入
        int locate = locate(arr, x);
        int i = locate - 1, j = locate, val = x;
        while(res.size() < k){
            if(i < 0 && j >= arr.length){
                break;
            } else if(i == j){
                res.add(arr[i]); i--; j++;
            } else if(i < 0){
                res.add(arr[j++]);
            } else if(j >= arr.length){
                res.add(arr[i--]);
            } else {
                int left = val - arr[i];
                int right= arr[j] - val;
                if(left <= right){
                    res.add(arr[i--]);
                } else {
                    res.add(arr[j++]);
                }
            }
        }

        Collections.sort(res);
        return res;
    }

    private int locate(int[] arr, int k){
        int low = 0, high = arr.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == k)
                return mid;
            else if(arr[mid] > k){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args){
        Lit658 lit = new Lit658();
//        System.out.println(lit.findClosestElements(new int[]{1},1,0));
//        System.out.println(lit.findClosestElements(new int[]{1,2,3,4,5},3,4));
//        System.out.println(lit.findClosestElements(new int[]{1,2,3,4,5,6,7},5,6));
//        System.out.println(lit.findClosestElements(new int[]{1,2,3,4,5,6,7},5,10));
//        System.out.println(lit.findClosestElements(new int[]{1,2,3,4,6,7},5,4));
        System.out.println(lit.findClosestElements(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9},9,4));
    }
}
