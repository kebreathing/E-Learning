package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/30 19:15
 */
public class Lit114 {

    // 将BST拉扯成递增的linkedlist
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right= root.right;

        flatten(left);
        flatten(right);
        root.left = null;

        // 左子树最右点的right指向原有的右子树
        root.right = left;
        TreeNode cur = root;
        while(cur.right != null) cur = cur.right;
        cur.right = right;
    }


}
