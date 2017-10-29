package easy;

public class Lit717 {

    // 有两个特殊的字符串
    // 第一个字符： 0 bit
    // 第二个字符表示为两个bits： 10 或 11
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 1) return true;

        int i = 0;
        while(i < bits.length){
            if(bits[i] == 0) {
                if(i == bits.length -1)
                    return true;
                i++; continue;
            } else {
                i += 2;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Lit717 lit = new Lit717();
        System.out.println(lit.isOneBitCharacter(new int[]{1,1,1,0}));
        System.out.println(lit.isOneBitCharacter(new int[]{1,1,0}));
    }
}
