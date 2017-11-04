package courses;

import java.util.*;

// 求域F28上任意元素的逆
public class InverseofF28 {
    // 最大循环次数
    private static int MAX_TURN = 1000;
    // 辗转相除法的次数：扩展欧几里得算法参数
    private static int NUM_PARAMETERS = 5;

    private int[] mx = {8,4,3,1,0}; // x^8 + x^4 + x^3 + x^1 + 1

    public InverseofF28() { }

    public void cal(int[] fx){
//        System.out.println("*************************************************");
        System.out.println("The inverse of [ " + list2String(arr2List(fx))+ " ]: " + list2String(calInverse(fx)));
//        System.out.println("*************************************************\n");
    }

    /**
     * 计算逆
     * @param fx fx 以元素的次数表示，且元素均是1倍自己
     *           即不存在： 6x^7 + 7X^3 + ……
     */
    private List<Integer> calInverse(int[] fx){
        // 不合法：存在幂大于7的项
        if(!isLegal(fx)) return null;

        List<EulidExtend> es = new ArrayList<>();
        es.add(new EulidExtend(-1,mx,null,new int[]{0},null));
        es.add(new EulidExtend(0,fx,null,null,new int[]{0}));

        int len;
        while((len = es.size()) > 0){
            // means: rx = 1
            if(es.get(es.size() - 1).rx.get(0) == 0 && es.get(es.size()-1).rx.size() == 1)
                break;
            es.add(mod(es.get(len-2), es.get(len-1)));
        }

        return es.get(es.size()-1).wx;
    }


    // ax = qx * bx + rx (*)
    private EulidExtend mod(EulidExtend a,EulidExtend b){
        List<Integer> rxa = new ArrayList<>(a.rx);
        List<Integer> rxb = new ArrayList<>(b.rx);
        List<Integer> qx = new ArrayList<>();

        while(rxa.size() > 0 && rxa.get(rxa.size()-1) - rxb.get(rxb.size()-1) >= 0) {
            int diff = rxa.get(rxa.size() - 1) - rxb.get(rxb.size() - 1);

            // 对 rxb 的各项加上 diff 得到 rxb'
            for (int i = 0; i < rxb.size(); i++)
                rxb.set(i, rxb.get(i) + diff);

            // rxa - rxb'
            int ai = 0, bi = 0;
            while (ai < rxa.size() && bi < rxa.size()) {
                while (bi < rxb.size() && rxb.get(bi) < rxa.get(ai)) bi++;
                while (ai < rxa.size() && rxa.get(ai) < rxb.get(bi)) ai++;
                if (rxa.get(ai) == rxb.get(bi)) {
                    rxa.remove(ai);
                    rxb.remove(bi);
                }
            }

            // (*)rx = rxa + rxb' 最后一轮
            // (*)ax = rxa + rxb' 非最后一轮
            for (int i : rxb) rxa.add(i);

            // 记录 (*)qx
            qx.add(diff);

            // rxa 排序
            Collections.sort(rxa);

            // 记录 (*)bx = rxb
            rxb = new ArrayList<>(b.rx);
        }
        // qx rx 已经获得，求vx wx
        List<Integer> vx = getXfrom_12(qx,a.vx,b.vx);
        List<Integer> wx = getXfrom_12(qx,a.wx,b.wx);
        return new EulidExtend(b.i+1,rxa,qx,vx,wx);
    }

    // 从前两项计算获得 Vi = Vi-2 - qi * Vi-1;
    private List<Integer> getXfrom_12(List<Integer> qx,List<Integer> x0, List<Integer> x1){
        Set<Integer> xs = new HashSet<Integer>();
        // qi * x1
        for(int q : qx){
            for(int x: x1){
                if(xs.contains(q+x)) xs.remove(q+x);
                else                 xs.add(q+x);
            }
        }

        // x0 - qi * Vi-1
        if(x0 != null){
            for(int x : x0){
                if(xs.contains(x)) xs.remove(x);
                else               xs.add(x);
            }
        }


        List<Integer> x = new ArrayList<>(xs);
        Collections.sort(x);
        return x;
    }

    // 将 array 转 List
    private List<Integer> arr2List(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int a : arr)
            list.add(a);
        return list;
    }

    // 只支持0-7，即 x^0 - x^7
    private boolean isLegal(int[] fx){
        for(int i : fx)
            if(i > 7 || i < 0)
                return false;
        return true;
    }

    private String list2String(List<Integer> list){
        if(list == null || list.size() == 0)
            return "0";

        String res = "";
        for(int i : list){
            if(i != 0)
                res += "x^" + i + "+";
            else
                res += 1 + "+";
        }
        return res.substring(0,res.length()-1);
    }

    private void printEulid(EulidExtend e){
        System.out.println(e.i + "\trx:" + list2String(e.rx)
                + "\tqx:" + list2String(e.qx)
                + "\tvx:" + list2String(e.vx)
                + "\twx:" + list2String(e.wx));
    }

    public static void main(String[] args){
        InverseofF28 iof = new InverseofF28();

        iof.cal(new int[] {0});
        iof.cal(new int[] {0,1});
        iof.cal(new int[] {0,1,2});
        iof.cal(new int[] {0,1,2,4});
//        iof.cal(new int[] {0,1,2,4,6});  // 5
        iof.cal(new int[] {0,1,2,4,5});
        iof.cal(new int[] {0,1,2,4,5,7});
        iof.cal(new int[] {0,1,3});
        iof.cal(new int[] {0,1,3,5});
//        iof.cal(new int[] {0,1,3,5,7});  // 10
        iof.cal(new int[] {0,2,4,6});
        iof.cal(new int[] {0,2,4});
        iof.cal(new int[] {0,2});
        iof.cal(new int[] {0,3,5,7});
        iof.cal(new int[] {0,3,5});     // 15
        iof.cal(new int[] {0,3});
        iof.cal(new int[] {0,4});
        iof.cal(new int[] {0,5});
        iof.cal(new int[] {0,6});       // 20
        iof.cal(new int[] {7,4,2,0});
    }

}

class EulidExtend {
    int i;
    List<Integer> rx = new ArrayList<>();
    List<Integer> qx = new ArrayList<>();
    List<Integer> vx = new ArrayList<>();
    List<Integer> wx = new ArrayList<>();

    public EulidExtend(int i, int[] r,int[] q,int[] v,int[] w){
        this.i = i;

        arr2List(r,rx);
        arr2List(q,qx);
        arr2List(v,vx);
        arr2List(w,wx);
    }

    public EulidExtend(int i,
                       List<Integer> rx, List<Integer> qx,
                       List<Integer> vx, List<Integer> wx){
        this.i = i;
        this.rx = rx;
        this.qx = qx;
        this.vx = vx;
        this.wx = wx;
    }

    private void arr2List(int[] arr,List<Integer> list){
        if(arr == null) return;
        for(int a : arr)
            list.add(a);

        // 排序：从小到大
        Collections.sort(list);
    }
}


class ListComparator implements  Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 < o2)
            return 1;
        else if(o1 > o2)
            return -1;
        else
            return 0;
    }
}