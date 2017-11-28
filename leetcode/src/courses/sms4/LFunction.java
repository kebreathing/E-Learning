package courses.sms4;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/24 10:56
 */
public class LFunction {
    // 前面部分以1填充, 后面部分以0填充

    /**
     * L函数的具体实现：B ^ (B << 2) ^ (B << 10) ^ (B << 18) ^ (B << 24)
     * @param word
     * @return 以 String 字符串的形式返回
     * @throws Exception
     */
    public static String L_str(byte[] word) throws Exception{
        return Util.bytesToHex(L(word));
    }

    /**
     * L函数的具体实现：B ^ (B << 2) ^ (B << 10) ^ (B << 18) ^ (B << 24)
     * @param word
     * @return 以 byte[] 的形式返回
     * @throws Exception
     */
    public static byte[] L(byte[] word) throws Exception {
        if (word == null || word.length != 4) {
            throw new Exception("The length of a word must be 4.");
        }

        byte[] B = word;
        // 字节拼接成字： 4 bytes -> 1 word -> 32 bits int
        int iB = bytes_to_int(B);

        // 循环移位和异或操作
        int ilB = iB ^rotate_left(iB, 2, 32) ^ rotate_left(iB, 10, 32)
                    ^ rotate_left(iB, 18, 32) ^ rotate_left(iB, 24, 32);
        return int_to_bytes(ilB);
    }


    public static String L_with_sbox_str(byte[] word) throws Exception{
        return Util.bytesToHex(L_with_sbox(word));
    }

    /**
     * 带Sbox转换的
     * @param word
     * @return
     * @throws Exception
     */
    public static byte[] L_with_sbox(byte[] word) throws Exception {
        if (word == null || word.length != 4) {
            throw new Exception("The length of a word must be 4.");
        }

        // 获得 S-Box 中的替换结果
        byte[] B = new byte[4];
        for (int i = 0; i < word.length; i++) {
            int[] rc = high4_low4(word[i]);
            B[i] = SBox.getByte(rc[0], rc[1]);
        }

        // 字节拼接成字： 4 bytes -> 1 word -> 32 bits int
        int iB = bytes_to_int(B);

        // 循环移位和异或操作
        int ilB = iB ^rotate_left(iB, 2, 32) ^ rotate_left(iB, 10, 32)
                ^ rotate_left(iB, 18, 32) ^ rotate_left(iB, 24, 32);
        return int_to_bytes(ilB);
    }

    /** 循环左移 offset 位
    * 左移offset位，len - offset 将以 0 填充
    * 无符号右移动，填充刚才的 0 位置
    * | 连接
     * */
    private static int rotate_left(int iB, int offset, int lenBits) {
        return (iB << offset) | (iB >>> (lenBits - offset));
    }

    // 将32位的int 输出成4个8bits的byte
    private static byte[] int_to_bytes(int n) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) ((n >> 24) & (0xff));
        bytes[1] = (byte) ((n >> 16) & (0xff));
        bytes[2] = (byte) ((n >> 8) & (0xff));
        bytes[3] = (byte) ((n >> 0) & (0xff));
        return bytes;
    }

    // 移位,做异或，得到32bits int -> 组成32位字，为了进行循环左移
    private static int bytes_to_int(byte[] B) {
        // &0xff将byte值无差异转成int,避免Java自动类型提升后,会保留高位的符号位
        int b0 = (B[0] & 0xff) << 24;
        int b1 = (B[1] & 0xff) << 16;
        int b2 = (B[2] & 0xff) << 8;
        int b3 = (B[3] & 0xff) << 0;

        return b0 + b1 + b2 + b3;
    }

    // 获得 byte 字节的高4位和低4位 -> S盒替代
    private static int[] high4_low4(byte b) {
        int low = 0, high = 0;
        for (int i = 3, j = 7; i >= 0; i--, j--) {
            low = (low << 1) | (((b & 0xff) >> i) & 0x1);
            high = (high << 1) | (((b & 0xff) >> j) & 0x1);
        }
        return new int[]{high, low};
    }

    private static void main(String[] args) {
        try {
            // Example from pdf: A:f0 02 c3 9e
//            byte[] LB = L(new byte[]{(byte) 0xf0, 0x02, (byte) 0xc3, (byte) 0x9e});
            // 1th:
//            System.out.println(L_str(new byte[]{(byte) 0xf0, 0x02, (byte) 0xc3, (byte) 0x9e}));
            System.out.println(L_str(new byte[]{(byte) 0xc1, (byte)0x00, (byte) 0x00, (byte) 0x00}));
            System.out.println(L_str(new byte[]{(byte) 0x80, (byte)0x00, (byte) 0x00, (byte) 0x00}));
            // 2th
//            System.out.println(L_str(new byte[]{(byte) 0x0, 0x0, (byte) 0xa, (byte) 0x5}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
