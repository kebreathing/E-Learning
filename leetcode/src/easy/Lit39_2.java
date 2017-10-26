package easy;

import java.util.Map;

public class Lit39_2 {

    // 找到第N个Ugly Number
    // 1, 2, 3, 4, 5
    public int uglyNumber(int n){
        if(n <= 5) return n;

        // Initial
        int[] nums = new int[n];
        for(int i = 0; i < 5; i++)
            nums[i] = i+1;

        // Make a map to record the index: <start, end>
        int index = 5;
        int[] map = {1, 0, 0};
        while(index < n){
            // 遍历
            int a = map[0],b = map[1],c = map[2];
            for(int i = a; i < index && 2 * nums[i] <= nums[index-1]; a = ++i);

            for(int i = b; i < index && 3 * nums[i] <= nums[index-1]; b = ++i);

            for(int i = c; i < index && 5 * nums[i] <= nums[index-1]; c = ++i);

            // 选择最小的一个
            int _a = Integer.MAX_VALUE,_b = Integer.MAX_VALUE,_c = Integer.MAX_VALUE;
            if(a < index && 2 * nums[a] > nums[index-1]) {
                _a = 2 * nums[a];
                map[0] = a;
            }
            if(b < index && 3 * nums[b] > nums[index-1]){
                _b = 3 * nums[b];
                map[1] = b;
            }
            if(c < index && 3 * nums[c] > nums[index-1]){
                _c = 5 * nums[c];
                map[2] = c;
            }
            nums[index++] = Math.min(_a,Math.min(_b,_c));
        }

        return nums[index-1];
    }

    public int uglyNum(int n){
        if(n <= 5) return n;

        int[] nums = new int[n];
        for(int i = 0; i < 5; nums[i] = i+1, i++);

        int idx = 5;
        int a,b,c;
        int _a = Integer.MAX_VALUE,_b = Integer.MAX_VALUE,_c = Integer.MAX_VALUE;

        // 记录 2、3、5 顺序遍历过程的起点
        int[] map = {1,0,0};
        while(idx < n){
            // 用 2、3、5 顺序遍历到 idx-1 的元素，并与之相乘，求其中大于 nums[idx-1] 且值最小的一位
            // 最后的结果就是： 每次遍历都一样
            for(a = map[0]; a < idx && (_a = 2 * nums[a]) <= nums[idx-1]; a++);
            for(b = map[1]; b < idx && (_b = 3 * nums[b]) <= nums[idx-1]; b++);
            for(c = map[2]; c < idx && (_c = 5 * nums[c]) <= nums[idx-1]; c++);
            map[0] = a;map[1] = b; map[2] = c;
            nums[idx++] = Math.min(_a,Math.min(_b,_c));
        }

        // 时间复杂度为 O(3n)
        return nums[n-1];
    }

    // 厉害厉害
    public int uglyNumNet(int n){
        int[] nums = new int[n];
        nums[0] = 1;

        int idx = 0;
        int m1 = 0, m2 = 0, m3 = 0;
        while(idx < n){
            int A = nums[m1] * 2;
            int B = nums[m2] * 3;
            int C = nums[m3] * 5;
            int min = Math.min(A,Math.min(B,C));
            if(min == A) m1++;
            if(min == B) m2++;
            if(min == C) m3++;
            nums[idx++] = min;
        }

        return nums[n-1];
    }

    public static void main(String[] args){
        Lit39_2 lit = new Lit39_2();
        System.out.println(lit.uglyNum(10));
    }
}
