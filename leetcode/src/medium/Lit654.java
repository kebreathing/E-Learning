package medium;

public class Lit654 {

    // 给定数组，构建树
//    The root is the maximum number in the array.
//    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        return constructMBT(0,nums.length-1,nums);
    }

    private TreeNode constructMBT(int begin, int end,int[] nums){
        if(begin == end)
            return new TreeNode(nums[begin]);
        if(begin > end || end < begin)
            return null;

        int maxidx = begin;
        int maxval = Integer.MIN_VALUE;
        for(int i = begin; i <= end; i++){
            if(maxval < nums[i]){
                maxval = nums[i];
                maxidx = i;
            }
        }

        // 获得最大值
        TreeNode root = new TreeNode(nums[maxidx]);
        root.left = constructMBT(begin,maxidx-1,nums);
        root.right= constructMBT(maxidx+1,end,nums);
        return root;
    }

    public static void main(String[] args){

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}