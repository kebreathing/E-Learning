package courses.java;

import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 多线程如何对容器做添加和删除操作
// Search：每次循环中 新建thread，新建searchthread子类，传入对应容器和需要搜索的值
// Delete and Append 就完全不能了
public class MultiThread {

    public void run(){
        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        for(int i = 0; i < 100; i++)
            list.add(i * i);

//        for(int i = 0; i < 5; i++)
//            new Thread("thread" + i){
//                public void run(){
//                    synchronized (list){
//                        System.out.println("Thread: " + this.getName());
//                        while(list.size() < 300) {
//                            System.out.println( "1 :" + list.size());
//                            list.add(list.size());
//                        }
//                    }
//                }
//            }.run();

        new Thread("thread0" ){
            public void run(){
                synchronized (list){
                    System.out.println("Thread: " + this.getName());
                    while(list.size() < 300) {
                        System.out.println( "1 :" + list.size());
                        list.add(list.size());
                    }
                }
            }
        }.run();

        new Thread("thread1" ){
            public void run(){
                synchronized (list){
                    System.out.println("Thread: " + this.getName());
                    while(list.size() < 300) {
                        System.out.println( "1 :" + list.size());
                        list.add(list.size());
                    }
                }
            }
        }.run();

    }

    public static void main(String[] args){
        MultiThread mt = new MultiThread();
        mt.run();
    }

}

