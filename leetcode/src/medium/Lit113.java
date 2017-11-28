package medium;

import java.util.ArrayList;
import java.util.List;

public class Lit113 {

    // 找出满足从根到叶子节点之和为sum的所有路径
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        search(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void search(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            if(sum-root.val == 0)
                res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.val);
        search(root.left, sum - root.val, list, res);
        search(root.right, sum - root.val, list, res);
        list.remove(list.size()-1);
    }
}