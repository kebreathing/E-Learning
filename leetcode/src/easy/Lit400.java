package easy;

public class Lit400 {

    // 在无限的序列中找到第N个字符
    // 1 2 3 4 5 6 7 8 9 10 (第5个字符为5)
    public int findNthDigit(int n) {
        int len = 1, start = 1;
        long count = 9;
        while(n > len * count){
            n -= len * count;
            len += 1;    // bits 的位数
            count *= 10; // 100中 90个两位数 10中9个一位数
            start *= 10; // 记录开始值
        }

        start += (n-1)/len; // 找到第几个元素
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n-1) % len));

    }

    //        Time Limit Exceeds 超时
//        long index = 1, cur = 1;
//        while(index < n){
//            cur++;
//            index += (cur + "").length();
//        }
//
//        String res = cur + "";
//        if(index == n) return res.charAt(res.length() - 1) - '0';
//        else           return res.charAt(res.length() - (int)(index - n)-1) - '0';

    public static void main(String[] args){
        Lit400 lit = new Lit400();
        System.out.println(lit.findNthDigit(10));
        System.out.println(lit.findNthDigit(11));
        System.out.println(lit.findNthDigit(3));
    }
}
