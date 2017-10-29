package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lit523 {

    // 判断nums中是否有和为k的倍数的子数组
    // k > 0 : 正常判断
    // k == 0: 判断是有连续的多个相同0元素
    // k < 0 : 将 k = -k;
    // Fail!!
    public boolean checkSubarraySum_fail(int[] nums, int k) {
        if(nums == null || nums.length <= 1) return false;
        if(isContinues(k,nums))              return true;
        if(k == 0)                           return false;
        if(k  < 0) k = -1 * k;
        List<Integer> nlist = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int mod = nums[i] % k;
            if(mod != 0) nlist.add(mod);
        }

        // 不存在单个元素整除k
        // 跳过了中间可能 == k 的取值
        while(nlist.size() > 1){
            List<Integer> l = new ArrayList<>(nlist);
            nlist.clear();

            int begin = 0, end = 0, sum = 0;
            while(end < l.size()){
                if(begin == end){
                    sum = l.get(begin);
                    end++;
                    continue;
                }

                while(end < l.size() && (sum += l.get(end)) < k) {
                    end++;
                }

                int mod = sum % k;
                if(mod == 0) return true;
                nlist.add(mod);
                begin = end;
            }
        }

        return (nlist.size() != 1)? true : (nlist.get(0) % k == 0);
    }

    private boolean isContinues(int k, int[] nums){
        for(int i = 0; i < nums.length - 1; i++)
            if(nums[i] == nums[i+1])
                return true;
        return false;
    }

    // The main idea is that (x + n*k) mod k = x ,which x can be 0,1,...,k-1.!!
    public boolean checkSubarraySum(int[] nums, int k){
        // Map 记录的是k从0 - k-1的所有取值的前一个值
        // 后面的语法是什么意思 = 内置函数
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(){{put(0,-1);}};
        int runningSum = 0;

        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i];
            if(k != 0) runningSum %= k;

            // 获得上一个取值出现的位置
            // 相同的 x! runningSum 再次出现值为 x!
            // 存在 x + n*k mod k = x !
            // 其中 n*k 由中间元素加和并模k而来！
            Integer prev = map.get(runningSum);

            if(prev != null){
                // 为了保证数组的长度至少为 2
                if(i - prev > 0) return true;
            }
            else map.put(runningSum,i);
        }
        return false;
    }

    public static void main(String[] args){

        int[] nums = {1};
        int[] nums1 = {23,2,4,6,7};
        int[] nums2 = {23,2,6,4,7};
        int[] nums4 = {23,2,6,4,7};
        int[] nums3 = {0,0};
        int[] nums5 = {0,1,0};
        int[] nums6 = {1,2,3};
        Lit523 lit = new Lit523();

//        System.out.println(lit.checkSubarraySum(nums, 0));
//        System.out.println(lit.checkSubarraySum(nums1, 6));
//        System.out.println(lit.checkSubarraySum(nums2, 6));
//        System.out.println(lit.checkSubarraySum(nums3, 0));
//        System.out.println(lit.checkSubarraySum(nums4, 9));
//        System.out.println(lit.checkSubarraySum(nums5, -1));
        System.out.println(lit.checkSubarraySum(nums6, 5));
    }
}
