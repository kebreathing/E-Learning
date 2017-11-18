package easy;

public class Lit581 {
    public int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            if (A[i] < max) end = i;
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }

    public static void main(String[] args){
        Lit581 lit = new Lit581();
//        System.out.println(lit.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(lit.findUnsortedSubarray(new int[]{2, 6, 8, 10}));
    }
}
