package medium;

import java.util.Arrays;

public class Lit324 {
    // 将序列按: nums[0] < nums[1] > nums[2] < nums[3] 顺序进行排序
    // 只能满足首项满足条件才可以
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;

        int len = nums.length;
        int begin = 0, end = 0;
        boolean isac = true; // 判断是不是升序
        while(begin < len && end < len){

            while(isac && end < len && nums[begin] >= nums[end]) end++;
            // swap
            if(isac && end < len && nums[begin] < nums[end]){
                swap(++begin,end,nums);
                end = begin;
                isac = !isac;
                continue;
            }

            while(!isac && end < len && nums[begin] <= nums[end]) end++;
            // swap
            if(!isac && end < len && nums[begin] > nums[end]){
                swap(++begin,end,nums);
                end = begin;
                isac = !isac;
                continue;
            }
        }

        if(isac && begin != len-1 && nums[len-2] > nums[len-1]) swap(len-2,len-1,nums);
        if(!isac && begin != len-1 && nums[len-2] < nums[len-1]) swap(len-2,len-1,nums);
    }



    private void swap(int i,int j,int[] nums){
        if(i == j) return;
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void wiggleSort2(int[] nums){
        Arrays.sort(nums);
        int n = nums.length, mid = n%2==0?n/2-1:n/2;
        int[] temp = Arrays.copyOf(nums, n);
        int index = 0;
        for(int i=0;i<=mid;i++){
            nums[index] = temp[mid-i];
            if(index+1<n)
                nums[index+1] = temp[n-i-1];
            index += 2;
        }
    }

    public static void main(String[] args){
//        int[] nums = {1,1,2,1,2,2,1};
//        int[] nums = {1,2,1,2,1,1,2};
//        int[] nums = {1, 5, 1, 1, 6, 4};
        int[] nums = {1, 3, 2, 2, 3, 1};

        Lit324 lit = new Lit324();
        lit.wiggleSort(nums);

        for(int i : nums)
            System.out.print(i + " ");
    }
}
