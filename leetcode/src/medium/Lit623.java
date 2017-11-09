package medium;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Lit623 {
    // 在第d层，添加一层
    // 1. root的层数为1
    // 2. 如果d=1，则以v为根节点，原root为左节点
    // 3. 如果d>1，则在d-1层的所有节点里新增左右两节点且值为v，原左节点在左边v的左节点，右在右节点
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode nroot = new TreeNode(v);
            nroot.left = root;
            return nroot;
        }

        int depth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // Stop at: level d-1
        while(depth < d-1){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right!= null) q.add(node.right);
            }
            depth++;
        }

        // Get the nodes of level d-1
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            TreeNode left = new TreeNode(v);
            TreeNode right= new TreeNode(v);
            left.left = node.left;
            right.right = node.right;
            node.left = left;
            node.right = right;
        }

        return root;
    }
}
