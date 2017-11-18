package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lit204 {

    // 计算 n 以下的素数个数
    // 暴力破解法：会超时
    public int countPrimes(int n) {
        // 优势在于不用每一个都去计算
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false){
                count++;
                for(int j = 2; j * i < n; j++){
                    notPrime[i* j] = true;
                }
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        if(n <= 1) return 0;
        List<Integer> prime = new ArrayList<>();
        for(int i = 2; i < n; i++){
            if(prime.isEmpty()) {
                prime.add(i);
                continue;
            }
            boolean isprime = true;
            for(int p: prime){
                if(i % p == 0){
                    isprime = false;
                    break;
                }
            }

            if(isprime) prime.add(i);
        }

        return prime.size();
    }

    public static void main(String[] args){
        Lit204 lit = new Lit204();
        System.out.println(lit.countPrimes(2));
        System.out.println(lit.countPrimes(10));
        System.out.println(lit.countPrimes(1000));
        System.out.println(lit.countPrimes(10000));
    }
}
