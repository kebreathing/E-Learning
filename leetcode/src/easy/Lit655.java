package easy;

public class Lit655 {

    // 是否可以通过修改一个元素使数组递增
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;                                                                    //the number of changes
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];                    //modify nums[i-1] of a priority
                else nums[i] = nums[i-1];                                                //have to modify nums[i]
            }
        }
        return cnt<=1;
    }

    public static void main(String[] args){
        Lit655 lit = new Lit655();
//        System.out.println(lit.checkPossibility(new int[]{4,2,3}));
        System.out.println(lit.checkPossibility(new int[]{-1,4,2,3}));
//        System.out.println(lit.checkPossibility(new int[]{1,2,3,4,5,6,76}));
//        System.out.println(lit.checkPossibility(new int[]{1,2,3,2,5,6,7}));
//        System.out.println(lit.checkPossibility(new int[]{1,3,2,4,5,6,4,8}));
    }
}
