package easy;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/5 19:02
 */
public class Lit342 {
    // 不用循环的方式，判断该数是不是4的幂
    // 因为4的话，基本上所有的1都在奇数微商
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }
}
