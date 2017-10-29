package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lit491 {
    // 先找到所有的递增子序列
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> eles = new ArrayList<>();
        find(0,nums,eles,res);
        return new ArrayList<>(res);
    }

    private void find(int index,int[] nums, List<Integer> eles, Set<List<Integer>> res){
        if(eles.size() >= 2){
            res.add(new ArrayList<>(eles));
        }
        for(int i = index; i < nums.length; i++){
            if(eles.size() == 0 || eles.get(eles.size()-1) <= nums[i]){
                eles.add(nums[i]);
                find(i+1,nums,eles,res);
                eles.remove(eles.size()-1);
            }
        }
    }
}
