package medium;

import java.util.*;

public class Lit508 {

    // 找到出现频次最高的SUM
    // 如果出现的次数都是1，则可以以任何顺序返回
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        search(root, map);

        int fre = 1;
        for(int key : map.keySet())
            if(fre < map.get(key))
                fre = map.get(key);

        List<Integer> res = new ArrayList<>();
        for(int key : map.keySet())
            if(map.get(key) == fre)
                res.add(key);

        int[] resarr = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            resarr[i] = res.get(i);
        return resarr;
    }

    private void search(TreeNode root, Map<Integer, Integer> map){
        if(root.left != null)
            search(root.left, map);
        if(root.right!= null)
            search(root.right, map);
        root.val += ((root.left == null)?0:root.left.val) + ((root.right==null)?0:root.right.val);
        map.put(root.val, map.containsKey(root.val)? map.get(root.val) + 1: 1);
    }
}
