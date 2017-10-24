package easy;

public class Lit458 {

    // minutesToTest
    // 不能同时测试，一次只能进行一次测试
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        // 指定时间内能够进行的测试数量
        int status = minutesToTest / minutesToDie + 1;

        // 覆盖！使用 pig 的数量去覆盖桶的类型
        // 覆盖方式：横排一个 竖列一个 矩阵规模就是 Status * Status （一次能够同时进行的测试数量）
        while(Math.pow(status,pigs) < buckets)
            pigs++;

        return pigs;
    }

    public static void main(String[] args){

    }
}
