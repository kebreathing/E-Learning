package easy;

public class Lit724 {

    //  判断是否存在下标i，左边所有元素之和等于右边所有元素之和
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int[] left = nums.clone();
        int[] right= nums.clone();
        for(int i = 1, j = nums.length - 2; i < nums.length && j >= 0; i++, j--){
            left[i] += left[i-1];
            right[j]+= right[j+1];
        }

        for(int i = 0; i < nums.length; i++)
            if(left[i] == right[i])
                return i;

        return -1;
    }

    public static void main(String[] args){
        Lit724 lit = new Lit724();
        System.out.println(lit.pivotIndex(new int[]{-1,-1,-1,0,1,1}));
        System.out.println(lit.pivotIndex(new int[]{-1,-1,0,1,1,-1}));
        System.out.println(lit.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
