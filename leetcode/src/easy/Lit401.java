package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/5 10:39
 */
public class Lit401 {

    // 二进制手表
    // 上4个灯：表示时间
    // 下6个等表示分钟
    // 输入灯的个数，求解可能的取值
    // 输出格式注意
    public List<String> readBinaryWatch(int num) {
        List<String > res = new ArrayList<>();
        if(num == 0) return res;

        int[] nums1 = new int[]{8, 4, 2, 1};
        int[] nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for(int i = 0; i <= num; i++){
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for(int num1: list1) {
                if(num1 >= 12) continue;
                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums,int count){
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res){
        if(count == 0){
            res.add(sum);
            return;
        }

        for(int i = pos; i < nums.length; i++){
            generateDigitHelper(nums, count-1, i+1, sum + nums[i], res);
        }
    }
}