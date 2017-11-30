package easy;

import java.util.Stack;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/30 18:41
 */
public class Lit155 {
    // 设计Stack，有一下几个函数
    // 常量时间内获得最小值
    private Stack<Integer> stack = null;
    private int min = Integer.MAX_VALUE;
    public Lit155() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty() || x < stack.peek()){
            min = x;
        }

        stack.push(x);
        stack.push(min);
    }

    public void pop() {
        if(stack.isEmpty())
            return;
        stack.pop();
        stack.pop();
        if(!stack.isEmpty())
            min = stack.peek();
    }

    public int top() {
        stack.pop();
        int top = stack.peek();
        stack.push(min);
        return top;
    }

    public int getMin() {
        return min;
    }
}
