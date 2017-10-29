package medium;

import java.math.BigInteger;

public class Lit306 {

    // 判断字符串 num 是不是 additive Sequence
    // Additive Sequence: f(n) + f(n+1) = f(n+2)
    // For example: 112358, 1, 1, 2, 3, 5, 8
    // 目标是： 生成第一项和第二项，遍历字符串，判断是否成立
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        // i 第一项的长度
        for(int i = 1; i <= n / 2; i++){
            // 第一位元素 = 0 == false
            if(num.charAt(0) == '0' &&  i > 1) return false;
            BigInteger x1 = new BigInteger(num.substring(0,i));

            // j 第二项的长度
            for(int j = 1; Math.max(j,i) <= n - i - j; j++){
                if(num.charAt(i) == '0' && j > 1) break;
                BigInteger x2 = new BigInteger(num.substring(i, i + j));
                if(isValid(x1,x2,j+i,num)) return true;
            }
        }

        return false;
    }

    // 加减在 isValid 里面用
    private boolean isValid(BigInteger x1, BigInteger x2,int start, String num){
        if(start == num.length()) return true;
        x2 = x2.add(x1);        // x2' = x1 + x2
        x1 = x2.subtract(x1);   // x1' = x2' - x1
        String sum = x2.toString(); // x3 = sum
        // num.startsWith 从 start 开始是不是存在 sum
        // 如果存在 sum，则开始遍历字符串
        return num.startsWith(sum, start) && isValid(x1,x2, start + sum.length(), num);
    }

    public static void main(String[] args){

    }
}
