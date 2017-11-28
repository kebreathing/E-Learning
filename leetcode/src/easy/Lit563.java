package easy;

import medium.TreeNode;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/28 21:21
 */
public class Lit563 {

    private int tilt = 0;
    // 统计每个节点的左节点个数，然后将所有左节点的值相加
    public int findTilt(TreeNode root) {
        search(root);
        return tilt;
    }

    private int search(TreeNode root){
        if(root == null) return 0;

        int left = search(root.left);
        int right= search(root.right);
        this.tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
