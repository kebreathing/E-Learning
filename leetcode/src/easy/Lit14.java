package easy;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/26 19:21
 */
public class Lit14 {
    // 找到字符串中最长的前缀
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if(strs == null || strs.length == 0) return prefix;

        // 直接以第一个字符串作为对象进行查找
        int i;
        char[] chs = strs[0].toCharArray();
        for(i = 0; i < chs.length; i++){
            boolean isok = true;
            char ch = chs[i];
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() == i || strs[j].charAt(i) != ch){
                    isok = false;
                    break;
                }
            }

            if(!isok) break;
        }
        // i 就是最长下下标
        for(int j = 0; j < i; j++){
            prefix = prefix + chs[j];
        }
        return prefix;
    }

    public static void main(String[] args){
        Lit14 lit = new Lit14();
        System.out.println(lit.longestCommonPrefix(new String[]{"abcdef", "abcde","abds","ab"}));
    }
}
