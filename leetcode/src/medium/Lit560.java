package medium;

public class Lit560 {

    // 只满足于正数序列
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int begin = 0, end = 0, target = 0, counter = 0;
        while(end < nums.length){
            if(begin == end) target = 0;

            while(end < nums.length && (target += nums[end]) < k) end++;

            if(end >= nums.length && target < k) break;
            if(target == k) counter++;
            target -= nums[begin++];
            if(begin > end) end = begin;
        }

        return counter;
    }


    public static void main(String[] args){
        Lit560 lit = new Lit560();
//        System.out.println(lit.subarraySum(new int[]{1,1,1}, 0));
//        System.out.println(lit.subarraySum(new int[]{1,2,3}, 3));
        System.out.println(lit.subarraySum(new int[]{-1,-1,1}, 0));
    }
}
