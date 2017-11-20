package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/20 20:06
 */
public class Lit413 {

    // 找出 A 中的具有相同间隔的片段，子序列
    // 子序列的长度必须大于等于3
    public int numberOfArithmeticSlices(int[] A) {
        // 不满足条件
        if(A == null || A.length < 3) return 0;

        int count = 0;
        int diff = A[1] - A[0];
        for(int left = 0, right = 2; right < A.length; right++){
            if(A[right] - A[right-1] != diff){
                // 找到不相同的位置
                left = right - 1;
                diff = A[right] - A[right-1];
            } else if(right - left + 1 >= 3){
                count += right - left + 1 - 2;
            }
        }

        return count;
    }

    public static void main(String[] args){
        Lit413 lit = new Lit413();
//        System.out.println(lit.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
//        System.out.println(lit.numberOfArithmeticSlices(new int[]{7, 7, 7, 7}));
        System.out.println(lit.numberOfArithmeticSlices(new int[]{1,2,3,4,5}));
        System.out.println(lit.numberOfArithmeticSlices(new int[]{1,1,2,3,4,5,7,9}));
    }
}
