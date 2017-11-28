package courses.java;

import java.util.HashSet;
import java.util.Set;

public class FindPrimes {

    public void findPrimes(int num){
        Set<Integer> primes = new HashSet<>();
        for(int i = 1; i < num; i++){
            boolean isprime = true;
            for(int j = 2; j < i; j++){
                if(i % j == 0) {
                    isprime = false;
                    break;
                }
            }
            if(isprime) primes.add(i);
        }

        // 判断是否存在两素数的乘积
        for(int p : primes){
            if(num % p == 0 && primes.contains(num / p)){
                System.out.println("(" + p + "," + (num/p) + ")");
            }
        }
    }

    public static void main(String[] args){
        FindPrimes fp = new FindPrimes();
        fp.findPrimes(3599);
        fp.findPrimes(35);
    }
}
