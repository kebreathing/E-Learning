package easy;

import medium.TreeNode;

public class Lit437 {

    private int count = 0;
    // 不需要从root出发，也不需要到达叶子节点，只要和为sum即可
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;

        // 再递归
        search(root, 0, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    private void search(TreeNode root, int sum, int target){
        if(root == null)
            return;

        if(sum+root.val == target)
            count++;
        search(root.left, sum + root.val, target);
        search(root.right, sum +root.val, target);
    }
}
