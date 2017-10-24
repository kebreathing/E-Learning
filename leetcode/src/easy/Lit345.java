package easy;

public class Lit345 {

    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return "";

        int i = 0, j = s.length() - 1;
        char[] chs = s.toCharArray();
        while(i < j){
            while(i < j && !isvowel(s.charAt(i))) i++;
            while(j > i && !isvowel(s.charAt(j))) j--;

            if(i < j) {
                char c = chs[i];
                chs[i] = chs[j];
                chs[j] = c;
                i++;j--;
            }
        }
        return new String(chs);
    }

    private boolean isvowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args){
        Lit345 lit = new Lit345();
        System.out.println(lit.reverseVowels("leetcode"));
    }
}
