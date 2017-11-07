package easy;

public class Lit674 {

    // 最长连续递增序列
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int count = 0;
        int i = 0, j = 0;
        while(j < nums.length && count < (nums.length - i)){
            while(j + 1 < nums.length && nums[j] < nums[j+1]) j++;
            count = Math.max(count, j - i + 1);
            j++;
            i = j;
        }

        return count;
    }

    public static void main(String[] args){
        Lit674 lit = new Lit674();
        System.out.println(lit.findLengthOfLCIS(new int[] {1,2,3,4,5,6,7}));
        System.out.println(lit.findLengthOfLCIS(new int[] {1,1,1,1,1,1}));
        System.out.println(lit.findLengthOfLCIS(new int[] {1,2,3,4,5,6,1,2,3,4,5}));

    }
}
