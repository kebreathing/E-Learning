package medium;

import java.util.ArrayList;
import java.util.List;

public class Lit229 {

    // 找出nums中元素个数大于[n/3]的所有元素: 0 1 2
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for(int n : nums) {
            if (n == candidate1)
                count1++;
            else if (n == candidate2)
                count2++;
            else if (count1 == 0){
                candidate1 = n; count1 = 1;
            } else if(count2 == 0){
                candidate2 = n; count2 = 1;
            } else {
                count1--; count2--;
            }
        }

        // 统计个数
        int c1 = 0, c2 = 0;
        for(int n : nums){
            if(n == candidate1)      c1++;
            else if(n == candidate2) c2++;
        }

        if(c1 > nums.length/3) res.add(candidate1);
        if(c2 > nums.length/3) res.add(candidate2);
        return res;
    }

    public static void main(String[] args){
        Lit229 lit = new Lit229();
        System.out.println(lit.majorityElement(new int[]{1,2}));
    }
}
