

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

    public void arraylist_example(){

         List<Integer> list = new ArrayList<Integer>();
        // 等式右边可以不指定类型
//       List<Integer> list = new ArrayList<>();
//       List<List<Integer>> list = new ArrayList<>(); 复杂变量：让系统帮你搞定

        // 赋值 or 添加元素
        for(int i = 0; i < 1000; i++, list.add(i));

        // 修改元素
        for(int i = 0; i < list.size(); i++, list.set(i,list.get(i) + 1));

        // 遍历 or 访问特定下标元素
        for(int i : list) System.out.print(list.get(i) + " ");

        // 无序序列排序: 默认为升序
        Collections.sort(list);
    }

    public void linkedlist_example(){
        List<Integer> list = new LinkedList<Integer>();
        // 等式右边可以不指定类型
//       List<Integer> list = new LinkedList<>();
//       List<List<Integer>> list = new LinkedList<>(); 复杂变量：让系统帮你搞定

        // 赋值 or 添加元素
        for(int i = 0; i < 1000; i++, list.add(i));

        // 删除元素
        for(int i = 0; i < 100 && !list.isEmpty();i++, list.remove(0)); // 删除前100个元素

        // 修改元素
        for(int i = 0; i < list.size(); i++, list.set(i,list.get(i) + 1));    // 元素递增

        // 遍历 or 访问特定下标元素（指针遍历）
        for(int i : list) System.out.print(list.get(i) + " ");

        // 无序序列排序: 默认为升序(指针方式排序)
        Collections.sort(list);
    }
}
