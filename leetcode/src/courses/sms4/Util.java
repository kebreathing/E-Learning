package courses.sms4;

public class Util {

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    // 输出每个字节
    public static void printBytes(byte[] B) {
        for (byte b : B)
            printByte(b);
    }

    // 输出单个int的32个比特位
    public static void printInt(int a) {
        String str = "";
        for (int i = 31; i >= 0; i--) {
            str = str + (byte) ((a >> i) & 0x1);
        }
        System.out.println(str);
    }

    // 打印单个byte的8个比特位
    public static void printByte(byte b) {
        String str = "";
        for (int i = 7; i >= 0; i--) {
            str = str + (byte) ((b >> i) & 0x1);
        }
        System.out.println(str);
    }

    // 以16进制的形式输出结果
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static void printMatrix(long[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
