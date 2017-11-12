package easy;

import java.util.HashSet;
import java.util.Set;

public class Lit202 {

    // 元素拆分加和直至最后等于1
    public boolean isHappy(int n) {
        int[] squrts = new int[10];
        for(int i = 0; i < squrts.length; i++)
            squrts[i] = i * i;

        Set<Integer> set = new HashSet<>();
        while(n != 1){
            int m = n, sum = 0;
            while(m > 0){
                sum += squrts[m % 10];
                m /= 10;
            }
            n = sum;
            if(set.contains(sum))
                return false;
            set.add(sum);
        }

        return true;
    }

    public static void main(String[] args){
        Lit202 lit = new Lit202();
        System.out.println(lit.isHappy(19));
    }
}
