package medium;

public class Lit75 {

    // 颜色排序：同色的排在相邻位置
    // 颜色共有三种：0 1 2
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int[] cnts = new int[3];
        for(int n : nums)
            cnts[n]++;

        int index = 0;
        for(int i = 0; i < cnts.length; i++)
            for(int j = 0; j < cnts[i]; j++)
                nums[index++] = i;


    }

    private void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args){
        Lit75 lit = new Lit75();
//        lit.sortColors(new int[]{0,0});
//        lit.sortColors(new int[]{0,0,0,1,1,2,2});
        lit.sortColors(new int[]{0,2,2,1,1,0,2,1});
    }
}
