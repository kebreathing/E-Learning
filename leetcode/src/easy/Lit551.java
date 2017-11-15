package easy;

public class Lit551 {

    // A > 1 or L > 2连续 惩罚
    public boolean checkRecord(String s) {
        if(s == null || s.length() == 0) return true;
        int A = 0, L = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'A') {
                A++;
                L = 0;
            }
            else if(s.charAt(i) == 'L')
                L++;
            else
                L = 0;

            if(A > 1 || L > 2)
                return false;
        }

        return true;
    }
}
