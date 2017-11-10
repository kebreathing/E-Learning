package easy;

import java.util.HashSet;
import java.util.Set;

public class Lit633 {
    // 判断是否存在两个数： a,b
    // 使得 a^2 + b^2 = c
    // 允许存在多个
    public boolean judgeSquareSum(int c) {
        // 如何计算
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i <= Math.sqrt(c); i++){
            if(set.contains(c - i*i) || (c - i*i) == i*i)
                return true;
            else
                set.add(i*i);
        }
        return false;
    }


    public static void main(String[] args){
        Lit633 lit = new Lit633();
        System.out.println(lit.judgeSquareSum(5));
        System.out.println(lit.judgeSquareSum(1));
        System.out.println(lit.judgeSquareSum(2));
        System.out.println(lit.judgeSquareSum(0));
    }
}
