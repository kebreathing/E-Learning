package medium;

import java.util.Arrays;
import java.util.Stack;

public class Lit456 {

    class Pair {
        int min, max;

        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    // 判断是否存在 132 模式的序列存在
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack();
        // 思考stack中Pair元素值变化
        // 遇到更小的值，要重新规划
        // 遇到更大的值，要看历史元素
        // 更大值分为两种情况: 1. 因为元素新压入 2. n确实比max大
        for(int n : nums){
            if(stack.isEmpty() || n < stack.peek().min)
                // 栈为空或遇到更小的值，直接压入
                stack.push(new Pair(n,n));
            else if(n > stack.peek().min){
                // n 大于当前最小值
                Pair last = stack.pop();
                if(n < last.max)
                    // n 大于当前最小值 小于最大值 满足条件
                    return true;
                else {
                    // n 大于当前最小值 还大于当前最大值 需要更新
                    // 对于新压入的Pair 就要面临这个问题
                    // 所以 会去翻过去存储的Pair
                    last.max = n;
                    while(!stack.isEmpty() && n >= stack.peek().max)
                        stack.pop();

                    // n 表示当前的值，如果遇到max比n大的，且min小于n的 满足条件
                    if(!stack.isEmpty() && stack.peek().min < n) return true;
                    // 如果stack为空 压入
                    stack.push(last);
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        Lit456 lit = new Lit456();
        System.out.println(lit.find132pattern(new int[]{1,2,3,4}));
        System.out.println(lit.find132pattern(new int[]{3,1,4,2}));
        System.out.println(lit.find132pattern(new int[]{-1,3,2,0}));
    }
}
