package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/19 19:02
 */
public class Lit728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(i <= 9) {
                res.add(i);
            } else {
                boolean self_dividing = true;
                String num = String.valueOf(i);
                for(int j = 0; j < num.length(); j++){
                    if(num.charAt(j) == '0' || i % (num.charAt(j) - '0') != 0){
                        self_dividing = false;
                        break;
                    }
                }

                if(self_dividing) res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args){
        Lit728 lit = new Lit728();
        System.out.println(lit.selfDividingNumbers(1, 9));
        System.out.println(lit.selfDividingNumbers(1, 22));

    }
}
