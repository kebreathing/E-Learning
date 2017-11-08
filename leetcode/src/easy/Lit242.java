package easy;

public class Lit242 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            int cs = s.charAt(i) - 'a';
            int ct = t.charAt(i) - 'a';
            count[cs]++;
            count[ct]--;
        }

        for(int c : count)
            if(c != 0)
                return false;
        return true;
    }
}
