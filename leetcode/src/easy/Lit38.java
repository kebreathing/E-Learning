package easy;

public class Lit38 {

    // 1
    // 11
    // 21
    // 1211
    // 111221
    // 312211
    public String countAndSay(int n) {
        if(n <= 0) return "";
        String str = "1";
        for(int i = 2; i <= n; i++){

            int count = 0;
            String tstr = "";
            char c = str.charAt(0);
            for(int j = 0; j < str.length(); j++){
                if(j == 0) { c = str.charAt(j); count = 1; continue; }
                if(c == str.charAt(j)) { count++; continue; }

                tstr += count + "" + c;
                c = str.charAt(j);
                count = 1;
            }
            tstr += count + "" + c;
            str = tstr;
        }

        return str;
    }

    public static void main(String[] args){
        Lit38 lit = new Lit38();
        System.out.println(lit.countAndSay(1));
        System.out.println(lit.countAndSay(2));
        System.out.println(lit.countAndSay(3));
        System.out.println(lit.countAndSay(4));
        System.out.println(lit.countAndSay(5));
        System.out.println(lit.countAndSay(6));
    }
}
