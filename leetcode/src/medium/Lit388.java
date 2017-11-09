package medium;

import java.util.Stack;

public class Lit388 {

    // 求字符串最长的路径
    // 要求时间复杂度是 O(n)
    // \n：表示换行
    // \t：表示子集
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;

        int begin = 0, end = 0, len = 0, maxlen = 0;
        Stack<String> stack = new Stack();
        while(end < input.length()){
            if(input.charAt(end) == '\n') end++;
            // Count: \t
            int tcnt = 0;
            while(end < input.length()
                    && input.charAt(end) == '\t') {
                tcnt++;
                end++;
            }

            begin = end;
            // Point end will stop at char '\'
            while(end < input.length() && input.charAt(end) != '\n') end++;

            // tcnt wil always satisfiy equation : tcnt = stack.size() + 1
            while(!stack.isEmpty() && tcnt <= stack.size() - 1){
                len -= stack.pop().length();
            }

            String str = input.substring(begin, end);
            stack.push(str);
            len += stack.peek().length();
            if(str.contains("."))
                maxlen = Math.max(maxlen, len + stack.size() - 1);
        }

        return maxlen;
    }

    public static void main(String[] args){
        Lit388 lit = new Lit388();
        System.out.println(lit.lengthLongestPath("a"));
//        System.out.println(lit.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
//        System.out.println(lit.lengthLongestPath("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext"));
//        System.out.println(lit.lengthLongestPath("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext"));
    }

}
