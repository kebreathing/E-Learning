package easy;

import medium.TreeNode;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/28 20:16
 */
public class Lit687 {

    private int longest = 0;
    // 在Tree中找到最长的含有相同元素的路径
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left != null)
            longestUnivaluePath(root.left);
        if(root.right != null)
            longestUnivaluePath(root.right);
        univalPath(root);
        return longest;
    }

    private int univalPath(TreeNode root){
        if(root == null)
            return 0;
        int left = 0, right = 0;
        if(root.left != null && root.left.val == root.val)
            left = univalPath(root.left) + 1;
        if(root.right!= null && root.right.val == root.val)
            right = univalPath(root.right) + 1;
        // 注意返回的不是左子树+右子树的路径长，而是两者之间最长的一段
        longest = Math.max(longest, left + right);
        return Math.max(left, right);
    }
}
