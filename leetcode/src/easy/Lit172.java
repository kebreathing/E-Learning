package easy;

public class Lit172 {
    // 计算 n！ 中尾部有多少个0
    public int trailingZeroes(int n) {
        // 阶乘中 #5 < #2， #表示数量
        return n == 0? 0 : n/5 + trailingZeroes(n/5);
    }
    public static void main(String[] args){

    }
}
