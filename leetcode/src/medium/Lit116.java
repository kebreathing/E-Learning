package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/12/4 18:13
 */
public class Lit116 {

    // 将所有节点的next指向它在树中的右节点
    public void connect2(TreeLinkNode root) {
        if(root == null) return;

        // BFS
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeLinkNode pre = null;
            for(int i = 0; i < size; i++){
                TreeLinkNode node = q.poll();
                // link
                if(pre == null)
                    pre = node;
                else {
                    pre.next = node;
                    pre = node;
                }

                if(node.left != null) q.add(node.left);
                if(node.right!= null) q.add(node.right);
            }

            pre.next = null;
        }
    }
}
