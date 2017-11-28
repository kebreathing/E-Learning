package courses.sms4;

public class SMSMain {

    public static void main(String[] args){
        try {
            // 第一题
            // 输入字（4字节），输出经过L变换之后的结果
            LFunc.L(new byte[]{(byte) 0xc1, (byte) 0x00, (byte) 0x00, (byte) 0x00});
            // 第二题
            // 证明：表一的正确性
            new LDistribution().fill_distribution();
            // (1)输入：任意字      输出对应的：

            // (2)输入：Pattern(X) 输出对应的：Pattern(Y)
            System.out.println(new LDistribution().pattern(new byte[]{(byte) 0xc1, (byte) 0x00, (byte) 0x00, (byte) 0x00}));
            System.out.println(new LDistribution().pattern_str(new byte[]{(byte) 0xc1, (byte) 0x00, (byte) 0x00, (byte) 0x00}));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
