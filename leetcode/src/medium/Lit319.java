package medium;

import java.util.Arrays;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/7 13:44
 */
public class Lit319 {
    // 初始化所有的灯都是关的
    // 第一轮：打开所有的灯
    // 第二轮：打开或关闭所有2的倍数的灯
    public int bulbSwitch(int n) {
        // 穷举：超时
//        boolean[] onoff = new boolean[n+1];
//        Arrays.fill(onoff, true);
//        for(int i = 2; i <= n; i++){
//            for(int j = 1; i * j <= n; j++){
//                    onoff[i*j] = !onoff[i*j];
//            }
//        }
//
//        int on = 0;
//        for(boolean status : onoff)
//            if (status)
//                on++;
//        return on - 1;
        // 看每一个i有多少个因子
        // 1： 1
        // 2： 1
        // 3： 1
        // 除1外，素数只有都是关闭
        // 4： 1-4 2 开
        // 9:  1-9 3 开
        // 36: 1-36 2-18 3-12 4-9 6
        // 所以：只要能够开方的，最后都是开
        // 1^2 2^2 3^2 4^2 5^2 6^2
        // 其余都是关
        // 偶数个因子：关闭
        // 奇数个因子：开启
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args){
        Lit319 lit = new Lit319();
        System.out.println(lit.bulbSwitch(36));
    }
}
