package easy;

public class Lit231 {

    // 判断一个数是否为2的次幂
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        while(n != 1){
            if(n % 2 == 0){
                n /= 2;
            } else {
                return false;
            }
        }
        return true;
    }
}
