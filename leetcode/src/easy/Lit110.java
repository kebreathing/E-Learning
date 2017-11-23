package easy;

import medium.TreeNode;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/23 10:40
 */
public class Lit110 {

    // 判断是否是深度平衡的平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        // 自底向上? 我觉得不是
        int left = depth(root.left);
        int right= depth(root.right);

        return Math.abs(left - right) <=1 && isBalanced(root.left) && isBalanced(root.right);

    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right= depth(root.right);
        return Math.max(left, right) + 1;
    }
}
