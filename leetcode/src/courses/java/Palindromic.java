package courses.java;

import java.util.Scanner;

public class Palindromic {

    // 判断是否是回文序列
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext()){
            System.out.println(false);
            return;
        }

        while(sc.hasNext()) {
            String str = sc.nextLine();
            if (str.length() == 0) {
                System.out.println(false);
                continue;
            }

            // 遍历计算
            str = str.toLowerCase();
            int i0 = 0, j0 = str.length() - 1;
            boolean isok = true;
            while (i0 < j0) {
                while (i0 < j0 && !(str.charAt(i0) >= 'a' && str.charAt(i0) <= 'z')
                        && !(str.charAt(i0) >= '0' && str.charAt(i0) <= '9')) i0++;
                while (j0 > i0 && !(str.charAt(j0) >= 'a' && str.charAt(j0) <= 'z')
                        && !(str.charAt(j0) >= '0' && str.charAt(j0) <= '9')) j0--;
                if (i0 > j0) {
                    isok = false; break;
                }
                if (str.charAt(i0) != str.charAt(j0)) {
                    isok = false; break;
                }
                i0++;
                j0--;
            }
            System.out.println(isok);
        }
        sc.close();
    }
}
