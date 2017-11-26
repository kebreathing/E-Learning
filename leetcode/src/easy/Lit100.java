package easy;

import medium.TreeNode;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/26 19:17
 */
public class Lit100 {

    // 判断两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null)
            return false;
        if(p != null && q == null)
            return false;
        if(p != null && q != null && p.val != q.val)
            return false;
        if(p == null && q == null)
            return true;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
