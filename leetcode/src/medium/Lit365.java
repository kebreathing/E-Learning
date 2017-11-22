package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/22 18:04
 */
public class Lit365 {

    // 用两个瓶子x和y，测量 z 升水
    // 判断x和y是否能够测量
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == z || y == z || (x+y) == z)
            return true;
        if(x + y < z)
            return false;

        return z % GCD(x,y) == 0;
    }

    private int GCD(int x, int y){
        return y == 0? x : GCD(y, x % y);
    }
}
