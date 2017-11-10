package easy;

public class Lit504 {

    // 将十进制转换成7进制的表示
    public String convertToBase7(int num) {
        boolean negative = (num >= 0) ? false: true;
        num = Math.abs(num);
        if(num == 0)
            return num + "";

        String rev = "";
        while(num != 0){
            rev += (num % 7);
            num /= 7;
        }

        String res = "";
        for(int i = rev.length() - 1; i >= 0; i--)
            res += rev.charAt(i);
        return negative?"-"+res:res;
    }

    public static void main(String[] args){
        Lit504 lit = new Lit504();
        System.out.println(lit.convertToBase7(7));
        System.out.println(lit.convertToBase7(100));
        System.out.println(lit.convertToBase7(-10));
        System.out.println(lit.convertToBase7(-7));
        System.out.println(lit.convertToBase7(0));
    }
}
