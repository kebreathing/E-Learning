package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/22 18:50
 */
public class Lit98 {

    // 验证二叉树是否为二分查找树
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        return recursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recursive(TreeNode root, long min, long max){
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return recursive(root.left, min, root.val) && recursive(root.right, root.val, max);
    }


    public boolean isValidBST2(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        mid(root, nodes);
        for(int i = 0; i < nodes.size() - 1; i++)
            // 等于都不行
            if(nodes.get(i) >= nodes.get(i+1))
                return false;
        return  true;
    }

    private void mid(TreeNode root, List<Integer> nodes){
        if(root == null)
            return;

        mid(root.left, nodes);
        nodes.add(root.val);
        mid(root.right, nodes);
    }
}
