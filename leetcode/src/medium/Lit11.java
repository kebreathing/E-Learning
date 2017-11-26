package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/26 18:58
 */
public class Lit11 {

    // 求坐标中最大面积
    // 找到两条直线，使其中形成的容器面积最大
    // O(n^2): 暴力破解法
    public int maxArea(int[] height) {
        int max = 0;
        int low = 0, high = height.length - 1;
        while(low < high){
            max = Math.max(max, (high - low) * (Math.min(height[high], height[low])));
            if(height[low] < height[high])
                low++;
            else
                high--;
        }

        return max;
    }

    public static void main(String[] args){
        Lit11 lit = new Lit11();
        System.out.println(lit.maxArea(new int[]{3,3,3,2,3}));
    }
}
