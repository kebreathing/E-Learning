package medium;

import java.util.ArrayList;
import java.util.List;

public class Lit313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> res = new ArrayList<>();

        // Initial
        res.add(1);
        int[] idxes = new int[primes.length];
        while(res.size() < n){

            // 找到相乘之后 比目前最后一个大的值
            // 凡是值小的，其下标也必然小
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < primes.length; i++){
                if(min > res.get(idxes[i]) * primes[i]){
                    min = res.get(idxes[i]) * primes[i];
                }
            }

            // 值相同的，下标++
            for(int i = 0; i < primes.length; i++){
                if(min == res.get(idxes[i]) * primes[i]){
                    idxes[i]++;
                }
            }

            res.add(min);
        }
        return res.get(res.size()-1);
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 13, 19};
        Lit313 lit = new Lit313();
        System.out.println(lit.nthSuperUglyNumber(6,nums));
    }
}
