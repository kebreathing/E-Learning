package easy;

public class Lit278 {

    // 找出第一个 bad version
    // 每一个version都是基于历史版本的
    public int firstBadVersion(int n) {
        if(n == 1) return 1;
        return badVersion(1,n);
    }

    private int badVersion(int begin,int end){
        if(begin == end)
            return begin;
        int mid = (end-begin) / 2 + begin;

        if(isBadVersion(mid))
            return badVersion(begin,mid);
        else
            return badVersion(mid+1,end);
    }

    // 模拟函数
    public boolean isBadVersion(int version){
        return true;
    }
}
