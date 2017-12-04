package courses.sms4;

import java.util.List;
/**
 * @author Chris 龙东恒 & 宋文浩
 * @mail kebreathing@gmail.com
 * @date 2017/11/24 10:56
 */
public class SMSMain {

    public static void main(String[] args){
        try {
            // 第一题
            // 输入字（4字节），输出经过L变换之后的结果
            Util.printHead("第一题：输入任意字，输出其经过L变换后的字（不含S盒变；S盒调用：L_with_sbox_str()）\n" +
                    "输入:\n" +
                    "\tbyte数组：即：new byte[]{...};\n" +
                    "\tbyte[]元素：例如(byte)0x00，0x表示16进制，后两位00为十进制0的16进制表示;\n" +
                    "\tbyte数组实例：new byte[]{(byte)0x01, (byte)0x02, (byte)0x03, (byte)0x04}.");
            String LB_str = LFunction.L_str(new byte[]{(byte) 0xc1, (byte) 0x00, (byte) 0x00, (byte) 0x00});
            System.out.println("{c1000000}变换结果为：" + LB_str);
            String LB_str2 = LFunction.L_str(new byte[]{(byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00});
            System.out.println("{80000000}变换结果为：" + LB_str2);

            // 第二题
            LDistribution ld = new LDistribution();
            // 证明：表一的正确性
            Util.printHead("\n第二题：验证表一的正确性，并完成其余两题");
            Util.printHead("验证表一：若为第一次运行，请调用fill_distribution()函数，结果将保存在当前目录。\n" +
                    "\t\t若已存在运行结果，请调用get_distribution()函数获取分布，以节省时间。");
//            ld.fill_distribution();
            ld.get_distribution();

            // (1)输入：任意字      输出对应的：L(B)
            Util.printHead("\n(1)输入任意字，输入其变换的结果：");
//            String LB = LFunction.L_str(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xa5});
//            String LB = LFunction.L_str(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x0a, (byte) 0x05});
            String LB = LFunction.L_str(new byte[]{(byte) 0x00, (byte) 0xa5, (byte) 0x00, (byte) 0x00});
            System.out.println("（初始化输入为：00a50000）变换结果为：" + LB);

            // (2)输入：Pattern(X) 输出对应的：Pattern(Y)
            Util.printHead("\n(2)输入任意字的模式，输出其对应的所有可能输出模式：");
            List<String> patternY = ld.patternY(6);
            System.out.println("（初始化输入为：6）所有可能的输出模式如下：");
            for(String str: patternY)
                System.out.println(str);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
