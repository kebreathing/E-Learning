package easy;

public class Lit58 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;

        int len = 0, i = s.length() - 1;
        while(i >= 0){
            if(s.charAt(i) == ' ' && len == 0) {
                i--;
            } else if(s.charAt(i) == ' '){
                break;
            } else {
                len++;
                i--;
            }
        }

        return len;
    }
}
