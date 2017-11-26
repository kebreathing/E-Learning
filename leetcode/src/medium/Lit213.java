package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/26 19:50
 */
public class Lit213 {

    // 盗窃现在不是从一条街道上了
    // 变成了一个环状，第一个和最后一个相连
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int lo, int hi){
        int include = 0, exclude = 0;
        for(int j = lo; j <= hi; j++){
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(e, i);
        }

        return Math.max(include, exclude);
    }

    public static void main(String[] args){
        Lit213 lit = new Lit213();
        System.out.println(lit.rob(new int[]{1,2,3,4,5,6,7,8}));
    }
}
