package courses.mq.chris;

import courses.mq.interfaces.ByteMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息存储仓库
 * 使用单实例模式：内置静态类，java虚拟机保证static的变量指初始化一次
 */
public class CStore {

    // 单实例模式
    static final CStore instance = new CStore();

    // Map: 消息种类 - 消息序列
    private Map<String, List<ByteMessage>> topics = null;

    // Map: 消息种类 - 不同的队列读取消息阅读下标
    private Map<String, Integer> treads = null;

    private CStore() {
        topics = new HashMap<>();
        treads = new HashMap<>();
    }

    // 消息存储函数
    public void push(String topic, ByteMessage msg){
        if(topic == null || topic.length() == 0 || msg == null)
            return;

        // 同步代码块
        synchronized (CStore.class){
            if(!topics.containsKey(topic)) {
                topics.put(topic, new ArrayList<>());
                treads.put(topic, 0);
            }
            topics.get(topic).add(msg);
        }
    }

    // 消息拉取函数

    /**
     * 指定队列名称，指定类型
     * @param queue
     * @param topic
     * @return
     */
    public ByteMessage pull(String queue, String topic){
        if(queue == null || queue.length() == 0
                || topic == null || topic.length() == 0)
            return null;

        String key = queue + " " + topic;
        synchronized (CStore.class){
            // 不存在此topic
            if(!topics.containsKey(topic))
                return null;

            if(treads.getOrDefault(key, 0) >= topics.get(topic).size())
                return null;

            int readIndex = treads.getOrDefault(key, 0);
            treads.put(key, readIndex+1);
            return topics.get(topic).get(readIndex);
        }
    }
}

