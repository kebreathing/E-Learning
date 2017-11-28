package courses.sms4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Chris 龙东恒
 * @mail kebreathing@gmail.com
 * @date 2017/11/24 16:38
 */
public class LDistribution {

    private long[][] dist_count = null;
    long[][] formated_matrix = null;        // 按表一对行列进行格式化

    public LDistribution(){
        formated_matrix = new long[16][16];
        dist_count = new long[16][16];
    }

    public String pattern_str(byte[] X) throws Exception{
        if(X == null || X.length != 4)
            throw new Exception("The length of the input must be 4.");

        int p = 0;
        for(int i = 0; i < 4; i++){
            p = (p << 1) | (((X[i] | 0) == 0)?0:1);
        }
        return Util.printInt(p).substring(32-8, 32);
    }

    /**
     * 求 Pattern
     * @param X 用户输入的字
     * @return int类型的输出
     * @throws Exception
     */
    public int pattern(byte[] X) throws Exception {
        if(X == null || X.length != 4)
            throw new Exception("The length of the input must be 4.");

        int p = 0;
        for(int i = 0; i < 4; i++){
            p = (p << 1) | (((X[i] | 0) == 0)?0:1);
        }
        return p;
    }

    /**
     * 开始填表
     */
    public void fill_distribution(){
        if(dist_count != null) return;

        try {
            dfs(0, new byte[4]);
            // 交换
            // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
            int[] arr = {0, 1, 2, 4, 8, 3, 5, 6, 9, 10, 12, 7, 11, 13, 14, 15};
            // 先换列 再换行

            for(int i = 1; i < 16; i++){
                for(int j = 1; j < 16; j++){
                    formated_matrix[i][j] = dist_count[arr[i]][arr[j]];
                }
            }

            Util.printMatrix(dist_count);
            System.out.println();
            Util.printMatrix(formated_matrix);
            save_table();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void save_table() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./table.csv")));

        int len = dist_count.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len-1; j++)
                writer.write(dist_count[i][j] + ",");
            writer.write(dist_count[i][len-1]+"\n");
        }

        writer.write("\nFormatted Matric: \n");
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len-1;j++)
                writer.write(dist_count[i][j] + ",");
            writer.write(dist_count[i][len-1]+"\n");
        }

        writer.flush();
        writer.close();
        System.out.println("Table 1 has been saved at ./table.csv.");
    }


    private void dfs(int index, byte[] bytes) throws Exception{
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
            new LDistribution().fill_distribution();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
