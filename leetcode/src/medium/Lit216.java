package medium;

import java.util.LinkedList;
import java.util.List;

public class Lit216 {

    // K: 集合内元素个数
    // N: 元素和
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        if(n == 0 || k == 0) return res;

        dfs(1,0,k,n,new LinkedList<Integer>(),res);


        return res;
    }

    private void dfs(int idx,int sum,int k,int n, List<Integer> list,List<List<Integer>> res){
        if(k == 1){
            for(int i = idx; i <= 9; i++){
                if(sum + i == n) {
                    list.add(i);
                    res.add(new LinkedList<>(list));
                    list.remove(list.size()-1);
                    return;
                }
            }
        } else {
            for(int i = idx; i <= 9; i++){
                if(sum + i < n){
                    list.add(i);
                    dfs(i+1,sum+i,k-1,n,list,res);
                    list.remove(list.size()-1);
                } else break;
            }
        }
    }

    public static void main(String[] args){
        Lit216 lit = new Lit216();
        for(List<Integer> l : lit.combinationSum3(3,9)){
            for(int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
