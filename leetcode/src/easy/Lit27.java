package easy;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/4 18:07
 */
public class Lit27 {

    // 直接在数组中删除指定元素，返回其长度
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;

        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] == val) continue;
            nums[i] = nums[j];
            i++;
        }

        return i;
    }

    public static void main(String[] args){
        Lit27 lit = new Lit27();
        System.out.println(lit.removeElement(new int[]{3,2,2,2,3,3}, 3));
    }
}
