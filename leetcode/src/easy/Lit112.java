package easy;

import medium.TreeNode;

public class Lit112 {

    // 判断从root到leaf是否存在节点和为sum的路径
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        return pathSum(root, sum);
    }

    private boolean pathSum(TreeNode root, int sum){
        if(root == null)
            return false;

        if(root.left == null && root.right == null)
            return (sum == 0)? true : false;

        return pathSum(root.left, sum - root.val) || pathSum(root.right, sum - root.val);
    }
}
