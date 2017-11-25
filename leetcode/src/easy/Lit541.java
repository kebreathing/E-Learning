package easy;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/25 9:59
 */
public class Lit541 {

    // 逆序字符串
    // 1. 如果字符串 < k 直接整个逆序
    // 2. 如果字符串 > k & < 2k 逆序0-k
    // 3. 如果字符串 >2k ，逆序k与2k
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    public static void main(String[] args){
        Lit541 lit = new Lit541();
        System.out.println(lit.reverseStr("abcdefgh", 2));
        System.out.println(lit.reverseStr("abcdefgh", 3));
        System.out.println(lit.reverseStr("abcdefgh", 4));
        System.out.println(lit.reverseStr("abcdefgh", 5));
        System.out.println(lit.reverseStr("abcdefgh", 6));
    }
}
