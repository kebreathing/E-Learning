package courses;

import java.util.Scanner;

public class MaxContinuesSebArray {
    // 求和最大的连续子数组
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }


        int maxsum = nums[0], maxhere = nums[0];
        for(int i = 1; i < n; i++){
            if(maxhere <= 0)
                maxhere = nums[i];
            else
                maxhere += nums[i];

            if(maxhere > maxsum)
                maxsum = maxhere;
        }

        System.out.println(maxsum);
        sc.close();
    }
}
