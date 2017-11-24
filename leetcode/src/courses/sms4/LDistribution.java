package courses.sms4;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/24 16:38
 */
public class LDistribution {

    private static long[] dist_row = null;
    private static long[][] dist_count = null;
    private static double[][] dist_rate = null;
    /**
     * 求 Pattern
     * @param X 用户输入的字
     * @return
     * @throws Exception
     */
    public static int pattern(byte[] X) throws Exception {
        if(X == null || X.length != 4)
            throw new Exception("The length of the input must be 4.");

        int p = 0;
        for(int i = 0; i < 4; i++){
            p = (p << 1) | (((X[i] | 0) == 0)?0:1);
        }
        return p;
    }

    public static void fill_distribution(){
        if(dist_count != null) return;
        dist_row = new long[16];
        dist_count = new long[16][16];
        dist_rate = new double[16][16];
        try {
            dfs(0, new byte[4]);
            // 交换
            // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
            int[] arr = {0, 1, 2, 4, 8, 3, 5, 6, 9, 10, 12, 7, 11, 13, 14, 15};
            // 先换列 再换行
            long[][] matrix = new long[16][16];
            for(int i = 1; i < 16; i++){
                for(int j = 1; j < 16; j++){
                    matrix[i][j] = dist_count[arr[i]][arr[j]];
                }
            }

            Util.printMatrix(dist_count);
            System.out.println();
            Util.printMatrix(matrix);
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void dfs(int index, byte[] bytes) throws Exception{
        if(index == 4) {
            // Input: bytes
            int pattern_x = pattern(bytes);
            int pattern_y = pattern(LFunc.L(bytes));
            dist_count[pattern_x][pattern_y]++;
            return;
        }

        // index < 4
        for(int i = 0; i <= 255; i++){
            bytes[index] = (byte)i;
            dfs(index+1, bytes);
            bytes[index] = 0;
        }
    }


    public static void main(String[] args){
        try {
//            System.out.println(pattern(new byte[]{(byte) 1, (byte) 1, (byte) 1, (byte) 1}));
//            System.out.println(pattern(new byte[]{(byte) 0, (byte) 1, (byte) 1, (byte) 1}));
//            System.out.println(pattern(new byte[]{(byte) 0, (byte) 0, (byte) 1, (byte) 1}));
//            System.out.println(pattern(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1}));
//            System.out.println(pattern(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0}));
            fill_distribution();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
