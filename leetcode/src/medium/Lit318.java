package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/20 20:23
 */
public class Lit318 {

    // 找到两个不含相同字母且乘积最大的字符串，并求出该乘积的值
    // 如何表示不含相同字母的字符串呢？
    public int maxProduct(String[] words) {
        // 让元素变成二进制，使用与操作，结果为0的就可以
        // 时间复杂度 n * n
        // Int 是32位的！居然忘了这个！
        if(words == null || words.length < 2)
            return 0;
        int len = words.length;
        int[] bits = new int[len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < words[i].length(); j++){
                bits[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int max = 0;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if((bits[i] & bits[j]) == 0 && max < words[i].length() * words[j].length()){
                    max = words[i].length() * words[j].length();
                }
            }
        }

        return max;
    }
}
