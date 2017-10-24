package medium;

public class Lit376 {

    // Wiggle Sequence 元素差正负交替
    // 我求的是子序列， 题目要求的是序列
    public int wiggleSubSequenceMaxLength(int[] nums) {
        if(nums == null) return 0;
        if(nums.length < 2) return nums.length;

        // Two pointers: begin & end
        int len = nums.length;
        int begin = 0, end = 0, maxlen = 0;
        while(begin < len && end < len){

           if(end == 0) {
               end++;
               continue;
           }

           // 满足条件的，正负替换
           while(end + 1 < len && (nums[end+1]-nums[end]) * (nums[end]-nums[end-1]) < 0){
               end++;
           }

           maxlen = Math.max(maxlen, end - begin + 1);
           begin = end;
           end++;
        }

        return maxlen;
    }

    // 非子序列
    public int wiggleMaxLength(int[] nums) {
        if(nums == null) return 0;
        if(nums.length < 2) return nums.length;

        int len = nums.length;
        int end = 0, p = 0, pp = 0, maxlen = 0;
        while(end < len){
            if(end == 0) {
                pp = p = end;
                maxlen++;
                end++;
                continue;
            }

            if(end + 1 < len){
                int right = nums[end + 1] - nums[end];
                int left = nums[end] - nums[p];
                if(right * left < 0){
                    pp = p;
                    p = end;
                    end++;
                    maxlen++;
                    continue;
                } else {
                    end++;
                }
            } else {
                // end == len - 1
                // previous 指的是上一个
                maxlen = ((nums[p] - nums[pp])*(nums[end] - nums[p]) < 0)?maxlen+1:maxlen;
                end++;
            }
        }

        // 判断升降序的问题
        if(maxlen == 1 && nums[0] == nums[len-1])      return maxlen;
        else if(maxlen == 1 && nums[0] != nums[len-1]) return maxlen+1;
        else                                           return maxlen;
    }

    public static void main(String[] args){
        int[] nums = {1,7,4,9,2,5};
        int[] nums1 = {1,4,7,2,5};
        int[] nums2 = {1,7,4,5,5};
        int[] nums3 = {1,17,5,10,13,15,10,5,16,8};
        int[] nums4 = {1,2,3,4,5,6,7,8,9};
        int[] nums5 = {-1,-2,-3,-4,-5,-6,-7,-8,-9};

        Lit376 lit = new Lit376();
//        System.out.println(lit.wiggleMaxLength(nums));
//        System.out.println(lit.wiggleMaxLength(nums1));
//        System.out.println(lit.wiggleMaxLength(nums2));
//        System.out.println(lit.wiggleMaxLength(nums3));
        System.out.println(lit.wiggleMaxLength(nums4));
        System.out.println(lit.wiggleMaxLength(nums5));
    }
}
