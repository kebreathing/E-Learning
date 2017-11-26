package easy;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/26 19:31
 */
public class Lit198 {
    // 盗窃
    // 相邻两家如果同时被盗则会报警
    // 求能够偷到的最大价值
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] rob = new int[nums.length];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++)
            rob[i] = Math.max(rob[i-2] + nums[i], rob[i-1]);

        return rob[nums.length-1];
    }

    public static void main(String[] args){
        Lit198 lit = new Lit198();
        System.out.println(lit.rob(new int[]{1,2,3,4,6,7,3,1,4,5,7,8,9}));
    }
}
