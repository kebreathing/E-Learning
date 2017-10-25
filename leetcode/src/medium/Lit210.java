package medium;

import java.util.*;

public class Lit210 {

    // numCourses: 课程数量
    // prerequisites: 修课条件
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return null;

        int idx = 0;
        int[] orders = new int[numCourses];
        Set<Integer> nopre = new HashSet<>();
        Map<Integer,LinkedList<Integer>> haspre = new HashMap<>();

        for(int i = 0; i < numCourses; i++)
            nopre.add(i);

        for(int[] req : prerequisites){
            if (!haspre.containsKey(req[0])) haspre.put(req[0],new LinkedList<>());
            haspre.get(req[0]).add(req[1]);
            nopre.remove(req[0]);
        }

        if(nopre.isEmpty()) return null;

        // 存在无条件修学课程
        for(int c : nopre)
            orders[idx++] = c;

        while(!nopre.isEmpty()){

            List<Integer> _nopre = new LinkedList<>();
            for(int pre : nopre){
                // 遍历Map
                for(int key: haspre.keySet()){
                    // 存在该课程，删除
                    if(haspre.get(key).isEmpty()) continue;
                    if(haspre.get(key).contains(pre)) haspre.get(key).remove(pre);
                    if(haspre.get(key).isEmpty())     _nopre.add(key);
                }
            }

            nopre.clear();
            for(int c : _nopre) {
                nopre.add(c);
                orders[idx++] = c;
            }
        }

        return idx == orders.length?orders:null;
    }

    public static void main(String[] args){
            Lit210 lit = new Lit210();
        int numCourse = 4;
        int[][] courses = {
                {1,0},{2,0},{3,1},{3,2}
        };

        lit.findOrder(numCourse,courses);
    }
}
