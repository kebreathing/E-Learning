package easy;

public class Lit39 {

    // 如果一个数的因子只有2，3，5的话，这个数就是ugly number
    public boolean isUgly(int num){
        while(num != 1 && num % 2 == 0) num /= 2;
        while(num != 1 && num % 3 == 0) num /= 3;
        while(num != 1 && num % 5 == 0) num /= 5;
        return num == 1;
    }

    public static void main(String[] args){
        Lit39 lit = new Lit39();
        System.out.println(lit.isUgly(189));
    }
}
