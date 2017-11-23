package medium;

import java.util.*;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/23 9:32
 */
public class Lit347 {

    // 找出数组中出现最频繁的k个数
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        // 静态的可以直接搜索统计
        // 元素是动态变化的，就要用新的方法
        // 按照value排序
        Map<Integer, Integer> map = new TreeMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        for(int i = 0; i < list.size() && i < k; i++)
            res.add(list.get(i).getKey());
        return res;
    }
}
