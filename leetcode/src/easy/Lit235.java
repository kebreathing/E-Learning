package easy;

import medium.TreeNode;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/28 20:43
 */
public class Lit235 {
    // 找到p和q最小的祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == null)    return q;
        if(q == null)    return p;
        if((p.val <= root.val && q.val >= root.val)
                || (p.val >= root.val && q.val <= root.val))
            return root;
        else if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
//        if(p.val > root.val && q.val > root.val)
        else
            return lowestCommonAncestor(root.right, p, q);
    }
}
