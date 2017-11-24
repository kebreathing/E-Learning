package easy;

import medium.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Lit257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        dfs("",root,res);

        for(int i = 0; i < res.size(); i++)
            if(res.get(i).length() > 2)
                res.set(i,res.get(i).substring(2));
        return res;
    }

    private void dfs(String str, TreeNode root, List<String> res){
        if(root == null) return;

        if(root.left == null && root.right == null){
            res.add(new String(str + "->" + root.val));
            return;
        }

        dfs(str+"->"+root.val, root.left,res);
        dfs(str + "->"+root.val, root.right, res);
    }

    public static void main(String[] args){

    }
}
