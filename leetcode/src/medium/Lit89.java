package medium;

import java.util.*;

public class Lit89 {

    // Gray Code 是一串二进制字符串，要求响铃的数字之间只有一个bit的差别
    // n = 2, 00 01 11 10
    public List<Integer> grayCode2(int n){
        List<Integer> res = new LinkedList<>();

        // Idea:
        // a ^ b % (2^i) == 0
        int len = (int)Math.pow(2,n);
        Set<Integer> set = new HashSet<>();
        int nums = 0;
        res.add(nums);
        set.add(nums);
        while(set.size() < len){
            for(int i = 0; i <= len; i++){
                if(set.contains(i))
                    continue;
                if(isok(nums ^ i,n)){
                    nums = i;
                    set.add(i);
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }

    private boolean isok(int xor,int n){

        for(int i = 0; i < n; i++)
            if (xor == Math.pow(2,i))
                return true;

        return false;
    }

    /*
    n = 0: 0
    n = 1: 0 | 1
    n = 2: 00, 01 | 11, 10
    n = 3: 000, 001, 011, 010 | 110, 111, 101, 100
    110 = 100 + 010 = 110
    111 = 100 + 011 = 111
    101 = 100 + 001 = 101
    100 = 100 + 000 = 100
    f(n) = f(n-1) | 2 ^ (n-1) + f(n-1)^(-1)逆序
    */
    public List<Integer> grayCode(int n){
        List<Integer> res = new ArrayList<>();
        res.add(0);

        // 注意下标
        for(int i = 1; i <= n; i++){
            int size = res.size();
            int base = 1 << (i-1);  // i的上一个
            for(int j = size - 1; j >= 0; j--){
                res.add(base + res.get(j));
            }
        }

        return res;
    }

    public static String intTobinary(int i){
        String res = "";
        while(i != 0){
            int mod = i % 2;
            res += (char) (mod + '0');
            i /= 2;
        }

        return res;
    }


    public static void main(String[] args){
        Lit89 lit = new Lit89();
        List<Integer> res = lit.grayCode(3);
        for(int i : res)
            System.out.println(i + ": " + intTobinary(i));
    }
}
