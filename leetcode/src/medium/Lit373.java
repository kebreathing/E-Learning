package medium;

import java.util.*;

public class Lit373 {

    // nums1: 数组
    // nums2: 数组
    // 从nums1中选择一个，从nums2中选择一个，组成(n1,n2)
    // 找出前k的最小值pari
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        // 暴力破解法
        List<int[]> perms = new ArrayList<>();
        for(int n1 : nums1){
            for(int n2 : nums2){
                perms.add(new int[]{n1,n2});
            }
        }

        // 排序
        Collections.sort(perms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (new Integer(o1[0] + o1[1])).compareTo(o2[0] + o2[1]);
            }
        });

        if(k >= perms.size()) return perms;
        else                  return perms.subList(0,k);
    }

    // 优先级队列 —— 一直没有掌握优先级队列的使用方式
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>(k);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0]+a[1]-b[0]-b[1]);

        // 开始计算
        if(nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0
                || k == 0) return res;

        // 将 nums1 的所有元素与 nums2[0] 进行配对，并压入队列
        for(int i = 0; i < nums1.length && i < k; i++)
            queue.offer(new int[]{nums1[i],nums2[0], 0});

        // 这个想法好厉害！！
        while(k-- > 0 && !queue.isEmpty()){
            int[] cur = queue.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length - 1) continue;
            queue.offer(new int[]{cur[0],nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}
