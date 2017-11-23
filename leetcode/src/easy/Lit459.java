package easy;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/23 9:47
 */
public class Lit459 {

    // 判断字符串是否由指定pattern组成
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() == 0) return false;

        for(int pLen = 1; pLen <= s.length()/ 2; pLen++){
            if(s.length() % pLen != 0)
                continue;

            // 长度满足重复要求
            String tmp = s.substring(0, pLen);
            boolean ispattern = true;
            for (int i = pLen; i < s.length(); i += pLen){
                if(!tmp.equals(s.substring(i, i + pLen))){
                    ispattern = false;
                    break;
                }
            }
            if(ispattern) return true;
        }

        return false;
    }

    public static void main(String[] args){
        Lit459 lit = new Lit459();
        System.out.println(lit.repeatedSubstringPattern("aaaaaaaaaaa"));
        System.out.println(lit.repeatedSubstringPattern("abababab"));
        System.out.println(lit.repeatedSubstringPattern("abcabcabcabc"));
    }
}
