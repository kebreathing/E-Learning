package medium;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/25 9:42
 */
public class Lit165 {

    // 比较两个版本的大小
    // v1 > v2 -> 1
    public int compareVersion(String version1, String version2) {
        // 存在不包含 . 的可能性
        // 2.0 or 2
        // 判断两个字符串的长度
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i < v1.length && j < v2.length){
            int a = Integer.valueOf(v1[i]);
            int b = Integer.valueOf(v2[j]);
            if(a > b) return 1;
            if(a < b) return -1;
            i++; j++;
        }

        // .0.0.0.0
        while(i < v1.length){
            if(Integer.valueOf(v1[i]) > 0)
                return 1;
            i++;
        }

        while(j < v2.length){
            if(Integer.valueOf(v2[j]) > 0)
                return -1;
            j++;
        }
        return 0;
    }

    public static void main(String[] args){
        Lit165 lit = new Lit165();
        System.out.println(lit.compareVersion("1.1.1.1.0.0.0", "1.1.1.1.0.0.0.0.0.0"));
        System.out.println(lit.compareVersion("1.1.1.1.0.0.0", "1.1.1.1.0.0"));
        System.out.println(lit.compareVersion("1.1.1.1.0.0.0", "1.1.1.2"));
        System.out.println(lit.compareVersion("1.1.1.1.0.0.0", "3.1.1"));
    }
}
