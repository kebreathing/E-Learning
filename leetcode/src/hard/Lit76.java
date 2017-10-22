package hard;

// 寻找s中包含t内所有字符的最短子串
public class Lit76 {

    public String minWindow(String S, String T){
        int[] map = new int[128];
        for(int i = 0; i < T.length(); i++)
            map[T.charAt(i)]++;

        int counter = T.length();
        int begin = 0, end = 0, dist = Integer.MAX_VALUE, head = 0;
        while(end < S.length()){
            // 如果S中end位置的字符串存在于T中
            // 不管存不存在，都对这个字符--，只不过存在了counter--
            if(map[S.charAt(end++)]-- > 0) counter--;

            // 当计数为零时，字符全部出现
            while(counter == 0){
                if(end - begin < dist) {
                    dist = end - begin;
                    head = begin; // 记录开始值
                }

                // 如果S中begin位置的字符在T中不存在
                // 不管存不存在，都对字符++
                // 如果本身为零的话，也就是碰到了T中目前只出现一次的字符，counter++
                if(map[S.charAt(begin++)]++ == 0) counter++; // make it invalid
            }
        }

        return dist==Integer.MAX_VALUE?"":S.substring(head,head + dist);
    }
// 解决这类问题的思路：
// end记录当前满足条件的最末下标；
// begin调整以使条件不满足；
// 最后再不断进行！
//    int findSubstring(string s){
//        vector<int> map(128,0);
//        int counter; // check whether the substring is valid
//        int begin=0, end=0; //two pointers, one point to tail and one  head
//        int d; //the length of substring
//
//        for() { /* initialize the hash map here */ }
//
//        while(end<s.size()){
//
//            if(map[s[end++]]-- ?){  /* modify counter here */ }
//
//            while(/* counter condition */){
//
//                 /* update d here if finding minimum*/
//
//                //increase begin to make it invalid/valid again
//
//                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
//            }
//
//            /* update d here if finding maximum*/
//        }
//        return d;
//    }

    public static void main(String[] args){
        Lit76 lit = new Lit76();
        lit.minWindow("ADOBECODEBANC","ABC");
        // head = A-0 Begin = A-0 END = C-6
        // end会到再次出现A的地方,begin会到目前为止只出现一次的字母
        // END = A-11 Begin = C-6, head = C-6
        // end会到再次出现C的地方，begin回到目前为止只出现一次的字母
        // END = C-13 Begin = A-10 head = A-10
    }
}
