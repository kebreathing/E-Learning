package easy;

public class Lit125 {

    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;

        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(i < j && !Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) i++;
            while(i < j && !Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))) j--;
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++; j--;
        }

        return true;
    }
}
