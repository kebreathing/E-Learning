package easy;

import medium.TreeNode;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/20 10:09
 */
public class Lit543 {
    // 直径：求树的两节点之间最长距离
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root){
        if(root == null)
            return 0;

        int left = dfs(root.left);
        int right= dfs(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;

    }
}
