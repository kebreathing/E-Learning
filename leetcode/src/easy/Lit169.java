package easy;

public class Lit169 {
    // 找到出现个数为 n/2 的元素
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for(int n : nums){
            if(count == 0){
                candidate = n; count = 0;
            }

            if(n == candidate){
                count++;
            } else {
                count--;
            }
        }

        // 检验
        count = 0;
        for(int n : nums)
            if(n == candidate)
                count++;

        return (count > nums.length/2)?candidate:0;
    }
}
