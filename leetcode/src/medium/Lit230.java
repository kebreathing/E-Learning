package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/23 10:17
 */
public class Lit230 {
    // 找到BST中第k个最小元素
    // 如果BST经常发生增删操作
    // 每一次也都是n的
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k-1);
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root == null)
            return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
