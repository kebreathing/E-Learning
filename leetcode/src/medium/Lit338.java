package medium;

public class Lit338 {

    // 计算 0 到 num 的各个元素中二进制1的个数
    // 8
    // 0 1  2   3   4    5   6     7    8
    // 0 1 10  11  100  101  110  111  1000
    // 牛逼！！ 后面的元素肯定都是由前面组合而成
    // 所以只要看最后一位他与最后一位是否相同！！
    public int[] countBits(int num) {
        int[] bits = new int[num+1];

        for(int i = 1; i <= num; i++)
            bits[i] = bits[i >> 1] + (i & 1);
        return bits;
    }

    // 8 >> 1 = 4  8 & 1 = 0
    // 7 >> 1 = 3

    public static void main(String[] args){
        System.out.println(7 >> 1); // 3
    }
}
