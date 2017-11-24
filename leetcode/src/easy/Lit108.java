package easy;


import medium.TreeNode;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/22 18:19
 */
public class Lit108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return build(0, nums.length - 1, nums);
    }

    private TreeNode build(int low, int high, int[] nums){
        if(low > high) return null;

        int mid = low + (high - low) / 2;
        TreeNode left = build(low, mid - 1, nums);
        TreeNode right= build(mid+1, high, nums);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = left;
        root.right= right;
        return root;
    }
}
