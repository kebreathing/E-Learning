package easy;

public class Lit461 {

    // HammingDistance 指的是两整数之间
    public int hammingDistance(int x, int y) {
        // while 2 逆序输出 二进制字符串
        int dict = 0;
        while(x != 0 && y != 0){
            if(x % 2 + y % 2 == 1){
                dict++;
            }
            x /= 2;
            y /= 2;
        }

        while(x != 0){
            if(x % 2 == 1){
                dict++;
            }
            x /= 2;
        }

        while(y != 0){
            if(y % 2 == 1){
                dict++;
            }
            y /= 2;
        }
        return dict;

        // return Integer.bitCount(x ^ y); 太强了！ XOR
        // return Integer.bitCount(x ^ y); 太强了！ XOR
    }

    public static void main(String[] args){
    }
}
