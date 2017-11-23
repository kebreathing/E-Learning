package medium;

// 建立类 strs，记录其中0和1的个数
// 如果存在多个相同1或相同0的元素，使用Map对不同类型进行统计
// 贪心算法：
// 1. 字符串长度
// 2. 字符串中0和1的个数
// 3. 搜索至穷尽再去增加
// 这种方式会存在问题：生成不同的序列本身就很耗时间，增大了时间复杂度
class Element{

    int zeros = 0;
    int ones  = 0;

    public Element(int z, int o){
        zeros = z;
        ones = o;
    }
}
