package medium;

import java.util.Arrays;
import java.util.HashSet;

public class Lit593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(dis(p1, p2), dis(p1, p3),
                dis(p1, p4), dis(p2, p3), dis(p2, p4), dis(p3, p4)));
        return !hs.contains(0) && hs.size()==2; //One each for side & diagonal
    }
    int dis(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }

    public static void main(String[] args){
        Lit593 lit = new Lit593();
//        lit.validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1});
//        lit.validSquare(new int[]{0,0}, new int[]{0,1}, new int[]{1,1}, new int[]{1,0});
        lit.validSquare(new int[]{1,0}, new int[]{0,1}, new int[]{-1,0}, new int[]{0,-1});
//        lit.validSquare(new int[]{6987, -473}, new int[]{6985, -473}, new int[]{6986,-472}, new int[]{6986,-474});
    }
}
