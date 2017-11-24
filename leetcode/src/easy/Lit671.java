package easy;


import medium.TreeNode;

public class Lit671 {

    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        int rootVal = root.val;
        int min = mindfs(rootVal,root);
        return (min == rootVal)? -1 : min;
    }

    private int mindfs(int rootVal, TreeNode root){
        if (root.val != rootVal)
            return root.val;

        int left = Integer.MAX_VALUE;
        int right= Integer.MAX_VALUE;
        // dfs深度遍历最后肯定只会停在没有左右节点、与rootVal相同的叶子节点
        if(root.left == null && root.right == null)
            return rootVal;

        // 如果发现节点val与rootVal不同，就stop
        if(root.left != null && root.left.val == rootVal)
            left = mindfs(rootVal,root.left);
        else
            left = root.left.val;

        if(root.right != null && root.right.val == rootVal)
            right = mindfs(rootVal,root.right);
        else
            right = root.right.val;



        if(left != rootVal && right != rootVal) return Math.min(left,right);
        else if(left != rootVal)                return left;
        else if(right!= rootVal)                return right;
        else                                    return rootVal;
    }
}
