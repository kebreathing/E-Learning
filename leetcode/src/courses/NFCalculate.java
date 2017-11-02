package courses;
import java.util.LinkedList;
import java.util.List;
/**
* Author : Chris 龙东恒 and 宋文浩
* StuId  : 1701210892 and 1701220043
*
**/
public class NFCalculate {

    // Rules: i < k
    // R1: xk xi = xi xk+1
    // R2: -xk xi = xi -xk+1
    // R3: -xi xk = xk+1 -xi
    // R4: -xi -xk = -xk+1 -xi
    private boolean has1 = false;

    public NFCalculate(){
        System.out.println("提示：算法将正负字母视为正负整数进行处理");
        System.out.println("注意：当正负字母中存在0，请将输入序列按以下方法操作。");
        System.out.println("1：正字母集合或负字母中含有0，请将所有正字母+1/负字母-1");
        System.out.println("2：最后的输出结果请依据第1条操作，逆向输出（正字母-1，负字母+1）");
        System.out.println("3：由于无法明确判断序列中正负字母的分布，所以对于0元素，程序无法\n" +
                "识别其为正字母抑或负字母，这是本程序的局限，望理解。");
        System.out.println("局限：使用正负整数无法将正字母集合、负字母集合完全表示（因为存在0元素）。");
    }

    public void nf_w(List<Integer> w){
        if(hasOne(w)) {
            // 使用err会令输出无序。
            System.out.println("\nError：请对集合中的0元素，做适当变换。");
            return;
        }
        nf_w(w,false);
        nf_print("NF",w);
        System.out.println("\nPS:每行头两字符表示对前一行进行该规则操作后得到的结果。如：");
        System.out.println("IN: Seq1");
        System.out.println("R2: Seq2: 对Seq1进行R2规则重写的结果");
    }

    /**
     * 计算法式流程：
     * 1. 规整化，化成由 正字母(i1-ir) + 负字母(js-j1) 的形式
     * 2. 判断是否存在最大违规二元组，若存在化简
     * @param w 整数序列，整数表示ir,负整数表示js
     */
    private void nf_w(List<Integer> w, boolean isrecursive){
        if(w == null || w.size() == 0) return ;

        if(!isrecursive)
            nf_print("IN",w);

        int notsorted = isSort(w);
        if(notsorted == w.size()-1){
            // 可以进行二元组化简
            int ir = irjs(w);   // 获得ir - js
            int[] tuple = illegalTuple(w,ir);
            int a = tuple[0], b = tuple[1];

            if(a > ir || b <= ir) {
                return;
            }

            while(a < b){
                _R1(w,a,a+1);
                _R4(w,b-1,b);
                a++;
                b--;
            }

            Cancel(w,a,a+1);
            Cancel(w,b,b-1);
            // when b < a
            Cancel(w,b,a);
            return;
        } else {
            for(int i = notsorted; i + 1 < w.size(); i++){
                Cancel(w,i,i+1);
                R1(w,i,i+1);
                R2(w,i,i+1);
                R3(w,i,i+1);
                R4(w,i,i+1);
            }
            nf_w(w, true);
        }
    }

    // R1的逆
    private void _R1(List<Integer> w,int k,int i){
        if(w.get(k) < 0 || w.get(i) < 0) return;
        int tmp = w.get(k);
        w.set(k,w.get(i) - 1);
        w.set(i,tmp);
        nf_print("R1",w);
    }

    // R4的逆: -xi -xk = -xk+1 -xi
    private void _R4(List<Integer> w,int k,int i){
        if(w.get(k) > 0 || w.get(i) > 0) return;
        int tmp = w.get(k);
        w.set(k,w.get(i));
        w.set(i,tmp + 1);
        nf_print("R4",w);
    }

    // R1: xk xi = xi xk+1
    private void R1(List<Integer> w,int k, int i){
        if(w.get(k) < 0 || w.get(i) < 0 || w.get(k) <= w.get(i)) return;
        int tmp = w.get(k);
        w.set(k,w.get(i));
        w.set(i,tmp + 1);
        nf_print("R1",w);
    }

    // R2: -xk xi = xi -xk+1
    private void R2(List<Integer> w,int k,int i){
        if(w.get(k) > 0 || w.get(i) < 0 || w.get(k) * -1 <= w.get(i)) return;
        int tmp = w.get(k);
        w.set(k,w.get(i));
        w.set(i,tmp-1);
        nf_print("R2",w);
    }

    // R3: -xi xk = xk+1 -xi
    private void R3(List<Integer> w,int i,int k){
        if(w.get(i) > 0 || w.get(k) < 0 || w.get(i) * -1 >= w.get(k)) return;
        int tmp = w.get(i);
        w.set(i,w.get(k) + 1);
        w.set(k,tmp);
        nf_print("R3",w);
    }

    // R4: -xi -xk = -xk+1 -xi
    private void R4(List<Integer> w,int i,int k){
        if(w.get(i) > 0 || w.get(k) > 0 || w.get(i) * -1 >= w.get(k) * -1) return;
        int tmp = w.get(i);
        w.set(i,w.get(k) - 1);
        w.set(k,tmp);
        nf_print("R4",w);
    }

    // CANCEL： 化简
    private void Cancel(List<Integer> w,int a,int b){
        if(w.get(a) + w.get(b) != 0) return;
        w.remove(a);
        w.remove(a);
        nf_print("R5",w);
    }

    // 判断序列是否为有序序列，即是否可以判断存在最大违规二元组
    private int isSort(List<Integer> w){
        int idx = 0;
        // Case 1: 8 3 4
        // Case 2: -4 3 5
        // Case 3: -5 -9 -7 -4
        while(idx + 1 < w.size()) {
            if(w.get(idx) < 0 && w.get(idx+1) > 0) return idx;
            if(w.get(idx) > 0 && w.get(idx+1) > 0 && w.get(idx) > w.get(idx+1)) return idx;
            if(w.get(idx) < 0 && w.get(idx+1) < 0 && w.get(idx) > w.get(idx+1)) return idx;
            idx++;
        }
        return idx;
    }

    // 找到ir-js的分割点
    // return: idx = ir; idx+1 = js
    private int irjs(List<Integer> w){
        int idx = 0;
        while(idx + 1 < w.size() && w.get(idx) * w.get(idx+1) > 0) idx++;
        return idx;
    }

    // 寻找最大违规二元组
    private int[] illegalTuple(List<Integer> w, int ir){
        int i = 0, j = w.size() - 1;
        while(i <= ir && j > ir){
            int l = w.get(i);
            int r = w.get(j) * -1;
            if(l < r)      i++;
            else if(l > r) j--;
            else {
                // 存在违规二元组，找到最大值
                while(i+1 <= ir && w.get(i) == w.get(i+1)) i++;
                while(j-1  > ir && w.get(j) == w.get(j-1)) j--;
                break;
            }
        }
        return new int[]{i,j};
    }

    // 输出序列
    private void nf_print(String keywords, List<Integer> w){
        StringBuilder builder = new StringBuilder();
        builder.append(keywords + ": ");
        for(int i : w){
            if(i >= 0) builder.append("x" + i + " ");
            else       builder.append("x" + (i * -1) + "^-1 ");
        }
        System.out.println(builder.toString());
    }

    private boolean hasOne(List<Integer> w){
        for(int i : w)
            if(i == 0) return true;
        return false;
    }

    public static List<Integer> arr2List(int[] nums){
        List<Integer> w = new LinkedList<>();
        for(int n : nums) w.add(n);
        return w;
    }

    public static void main(String[] args){
//        int[] nums1 = {3, 7, 9, 11, 15, 18, -14, -13, -9, -2};
//        int[] nums2 = {8, 3, 7, 11, -9, -4};
//        int[] nums3 = {7, 3, 7, 11, -9, -4};
//        int[] nums4 = {-6, 3, 7, -9, -4};
        int[] nums5 = {-5, 3, 7, -9, -4};
        int[] nums6 = {-3, 2, 7, -9, -4, -1};
        int[] nums7 = {0, -5, 3, 7, 11, -9, -4, 0, 0, 0, 0};
        int[] nums8 = {1, -6, 4, 8, 12, -10, -5, -1, -1, -1, -1};

        NFCalculate nfc = new NFCalculate();
//        nfc.nf_w(arr2List(nums1));    //x3 x7 x10 x14 x17 x13^-1 x12^-1 x2^-1
//        nfc.nf_w(arr2List(nums2));    //x3 x7 x10 x11 x9^-1 x4^-1
//        nfc.nf_w(arr2List(nums3));    //x3 x7 x10 x4^-1
//        nfc.nf_w(arr2List(nums4));    //x3 x9^-1 x4^-1
        nfc.nf_w(arr2List(nums5));     //x3 x8 x10^-1 x6^-1 x4^-1
        nfc.nf_w(arr2List(nums6));     //x2 x8 x10^-1 x4^-1 x4^-1 x1^-1
//        nfc.nf_w(arr2List(nums7));
        nfc.nf_w(arr2List(nums8));
//        nfc.nf_w(arr2List(new int[]{5,3}));  // 3 6
//        nfc.nf_w(arr2List(new int[]{-5,3})); // 3 -6
//        nfc.nf_w(arr2List(new int[]{-3,-5}));// -6 -3
    }
}
