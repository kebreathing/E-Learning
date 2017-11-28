package easy;

import medium.TreeNode;

import java.util.*;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/28 20:33
 */
public class Lit501 {
    private int maxfreq = 0;
    // 找到Tree中出现次数最多的元素
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[]{};

        Map<Integer, Integer> counter = new HashMap<>();
        search(root, counter);
        List<Integer> res = new ArrayList<>();
        for(Map.Entry entry : counter.entrySet()){
            if((int)entry.getValue() == maxfreq)
                res.add((int)entry.getKey());
        }

        int[] resarr = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            resarr[i] = res.get(i);
        return resarr;
    }

    private void search(TreeNode root, Map<Integer, Integer> map){
        if(root == null)
            return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        search(root.left, map);
        search(root.right, map);
        maxfreq = Math.max(maxfreq, map.get(root.val));
    }
}
