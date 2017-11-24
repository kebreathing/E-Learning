/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/24 10:56
 */
public class LFunc {
    // << 移位操作
    // 前面部分以1填充
    // 后面部分以0填充
    // L 函数 B ^ (B << 2) ^ (B << 10) ^ (B << 18) ^ (B << 24)
    public static byte[] L(byte[] word) throws Exception{
        if(word == null || word.length != 4){
            throw new Exception("The length of a word must be 4.");
        }

        // 获得 S-Box 中的替换结果
        byte[] B = new byte[4];
        for(int i = 0; i < word.length; i++){
            int[] rc = high4_low4(word[i]);
            B[i] = SBox.getByte(rc[0], rc[1]);
//            printByte(B[i]);
        }

        // 字节拼接成字： 4 bytes -> 1 word -> 32 bits int
        int iB = bytes_to_int(B);
        printInt(iB);
        // 循环移位和异或操作
        int iB2 = (iB << 4) | (iB >>> (32-4));
//        printInt(iB2);
        int iB10 = (iB << 10) | (iB >>> (32-10));
//        printInt(iB10);
        int iB18 = iB << 18 | (iB >>> (32-18));
//        printInt(iB18);
        int iB24 = iB << 24 | (iB >>> (32-24));
//        printInt(iB24);
        int lB = iB ^ iB2 ^ iB10 ^ iB18 ^ iB24;
//        printInt(lB);
        B = int_to_bytes(lB);
        return B;
    }

    // 将32位的int 输出成4个8bits的byte
    public static byte[] int_to_bytes(int n){
        byte[] bytes = new byte[4];
        bytes[0] = (byte)((n >> 24) & (0xff));
        bytes[1] = (byte)((n >> 16) & (0xff));
        bytes[2] = (byte)((n >> 8)  & (0xff));
        bytes[3] = (byte)((n >> 0)  & (0xff));
        printBytes(bytes);
        return bytes;
    }

    // 移位,做异或，得到32bits int
    public static int bytes_to_int(byte[] B){
        // 移位是以 1 位单位前进的
        // &0xff将byte值无差异转成int,避免Java自动类型提升后,会保留高位的符号位
        int b0 = (B[0] & 0xff) << 24;
        int b1 = (B[1] & 0xff) << 16;
        int b2 = (B[2] & 0xff) << 8;
        int b3 = (B[3] & 0xff) << 0;

        return b0 + b1 + b2 + b3;
    }

    // 获得 byte 字节的高4位和低4位
    public static int[] high4_low4(byte b){
        int low = 0, high = 0;
        for(int i = 3, j = 7; i >= 0; i--, j--){
            low = (low << 1) | (((b & 0xff) >> i) & 0x1);
            high =(high << 1) | (((b & 0xff)>> j) & 0x1);
        }
        return new int[]{high, low};
    }

    // 输出每个字节
    public static void printBytes(byte[] B){
        for(byte b : B)
            printByte(b);
    }

    public static void printInt(int a){
        String str = "";
        for(int i = 31; i>= 0; i--){
            str = str + (byte) ((a >> i) & 0x1);
        }
        System.out.println(str);
    }

    public static void printByte(byte b){
        String str = "";
        for(int i = 7; i>= 0; i--){
            str = str + (byte) ((b >> i) & 0x1);
        }
        System.out.println(str);
    }

    public static void main(String[] args){
        try{
            // Example from pdf: A:f0 02 c2 9e
            byte[] LB = L(new byte[]{(byte)0xf0, 0x02, (byte)0xc2, (byte)0x9e});
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
