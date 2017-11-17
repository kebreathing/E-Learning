package medium;

import java.util.*;

public class Lit15 {

    // Set 对 List 的元素也是可以唯一化的！
    // 已经非常剪枝了！
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while(lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum){
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) {
                break;
            } else if(i >= 1 && nums[i] == nums[i-1]){
                continue;
            } else{
                Set<List<Integer>> set = new HashSet<>();
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                dfs(i+1, nums[i], nums, list, set);
                res.addAll(set);
            }
        }
        return res;
    }

    private void dfs(int index, int sum, int[] nums, List<Integer> list, Set<List<Integer>> set){
        if(list.size() == 3 && sum == 0){
            set.add(new ArrayList<>(list));
        } else if(list.size() < 3){
            for(int i = index; list.size() < 3 && i < nums.length && sum <= 0 && sum + nums[i] <= 0; i++){
                sum += nums[i];
                list.add(nums[i]);
                dfs(i+1, sum, nums, list, set);
                list.remove(list.size()-1);
                sum -= nums[i];
            }
        }
    }

    public static void main(String[] args){
        Lit15 lit = new Lit15();
        System.out.println(lit.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
