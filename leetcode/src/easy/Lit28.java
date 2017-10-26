package easy;

public class Lit28 {
    // Returns the index of the first occurrence of needle in haystack
    // or -1 if needle is not part of haystack
    // Time Limit Exceed!!
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        if(needle.equals(haystack)) return 0;

        int i = 0;
        while(i < haystack.length()){
            int j = i, k = 0;
            while(k < needle.length()
                    && j < haystack.length()
                    && haystack.charAt(j) == needle.charAt(k)){
                j++;
                k++;
            }

            if(k >= needle.length()) return i;
            else                       i++;
        }

        return -1;
    }

    public int strStr2(String haystack, String needle){
        for(int i = 0; ; i++){
            for(int j = 0; ; j++){
                if(j == needle.length()) return i;
                // 等价于 i = haystack.length() i + j(j=0) == haystack.length(); 搜索到最后还是没找到！
                if(i + j == haystack.length()) return -1;
                if(needle.charAt(j) != haystack.charAt(i+j)) break; // 逐字节匹配
            }
        }
    }

    public static void main(String[] args){
        Lit28 lit = new Lit28();
//        System.out.println(lit.strStr("aaa", "a"));
        System.out.println(lit.strStr("mississippi", "pi"));
    }
}
