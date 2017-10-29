package medium;

import java.util.LinkedList;
import java.util.List;

public class Lit228 {
    // 将连续的元素合并
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if(nums == null || nums.length == 0) return res;

        int begin = 0, end = 0, lastidx = -1, cur = nums[0];
        while(end < nums.length){

            if(begin == end){
                cur = nums[begin];
                end++;
                continue;
            }

            while(end < nums.length && cur + 1 == nums[end]) { cur++; end++; }
            res.add(summary(begin,end-1,nums));
            lastidx = end - 1;
            begin = end;
        }
        if(lastidx != nums.length - 1)
            res.add(summary(nums.length-1,nums.length-1,nums));
        return res;
    }

    private String summary(int begin, int end, int[] nums){
        if(begin == end) return nums[begin] + "";
        else             return nums[begin] + "->" + nums[end];
    }


    public static void main(String[] args){
        int[] nums = {0,1,2,4,5,7};
        int[] nums1 = {0,1,2,4,5,7,8,9,10,11};
        int[] nums2 = {0,2,4,6,8,10,12};
        Lit228 lit = new Lit228();
//        lit.summaryRanges(nums);
//        lit.summaryRanges(nums1);
        lit.summaryRanges(nums2);
    }
}
