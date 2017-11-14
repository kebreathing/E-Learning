package medium;

public class Lit494 {
    // 给定目标值 S， 对于nums中的元素只能使用 - 或 +
    // Idea: DFS
    // init: sum = 0
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(0,0,nums,S);
    }

    private int dfs(int index, int sum, int[] nums, int target){
        if(index == nums.length && sum != target){
            return 0;
        } else if(index == nums.length && sum == target){
            return 1;
        } else {
            int a = dfs(index + 1, sum + nums[index], nums, target);
            int b = dfs(index + 1, sum - nums[index], nums, target);
            return a + b;
        }
    }

    public static void main(String[] args){
        Lit494 lit = new Lit494();
        System.out.println(lit.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
