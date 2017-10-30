package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lit95 {
    // 给定整数，返回由 1 - n 组成的所有BST
    // 目标应该是构建一棵树
    // return type: 是TreeNode的list说明了要将所有的node存入到集合中！
    public List<TreeNode> generateTrees(int n) {
        return genTrees(1,n);
    }

    private List<TreeNode> genTrees(int start,int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            // start - 1 < start
            // 初始化 i = 1 的情况
            list.add(null);
//            return list;
        }
// 没有右节点，所以right == null
//        if(start == end){
//            // 单独做节点
//            list.add(new TreeNode(start));
//            return list;
//        }

        List<TreeNode> left,right;
        for(int i = start; i <= end; i++){
            left = genTrees(start,i-1);
            right= genTrees(i+1,end);
            for(TreeNode lnode : left){
                for(TreeNode rnode : right){
                    // 都是以 i 为根的节点
                    // 改变的是左右子节点
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right= rnode;
                    // 底层是已经连接好的子树
                    list.add(root);
                }
            }
        }

        return list;
    }

    public static void main(String[] args){

    }
}
