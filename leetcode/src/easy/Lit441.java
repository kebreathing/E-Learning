package easy;

public class Lit441 {
    // 将硬币按阶梯数量排列
    // n = 8
    // 1
    // 2
    // 3
    // 2 X 不可以
    // return 3 层

    // 解一元二次方程
    public int arrangeCoins(long n) {
        System.out.println((double)(0.25 + 2*n));
        System.out.println(Math.sqrt(1.0/4.0 + 2*n));
        return (int)Math.floor(Math.sqrt(1.0/4.0 + 2*n) - 0.5);
    }

    public int arrangeCoins2(int n){
        if(n == 0) return n;

        int stairs = 0;
        int levels = -1;
        while(stairs <= n){
            n -= stairs;
            stairs++;
            levels++;
        }
        return levels;
    }

    public static void main(String[] args){
        Lit441 lit = new Lit441();
        System.out.println(lit.arrangeCoins(1));
        System.out.println(lit.arrangeCoins(4));
        System.out.println(lit.arrangeCoins(8));
        System.out.println(lit.arrangeCoins(123));
        System.out.println(lit.arrangeCoins(1804289383));
    }
}
