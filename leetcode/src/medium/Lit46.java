package medium;

import easy.Lit39;

import java.util.ArrayList;
import java.util.List;

public class Lit46 {

    // nums： 不含重复元素的数组
    // Aim: 生成所有排列组合
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> perm, List<List<Integer>> res){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(!visited[j]){
                visited[j] = true;
                perm.add(nums[j]);
                dfs(nums, visited, perm, res);
                perm.remove(perm.size()-1);
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args){
        Lit46 lit = new Lit46();
        List<List<Integer>> perms = lit.permute(new int[]{1,2,3});
    }

}
