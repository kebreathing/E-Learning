package courses.mq.demo;

import pku.ByteMessage;
import pku.DefaultMessage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yangxiao on 2017/11/14.
 * 这是一个消息队列的内存实现
 */
public class DemoMessageStore {
    // 单例模式
    static final DemoMessageStore store = new DemoMessageStore();

    // 消息存储
    // Key: topic value: Message
    HashMap<String, ArrayList<ByteMessage>> msgs = new HashMap<>();

    // 遍历指针
    // Key: topic value: the index of reading information (begin from)
    HashMap<String, Integer> readPos = new HashMap<>();


    /**
     * 存储消息（推送）
     * @param msg
     * @param topic
     */
    public synchronized void push(ByteMessage msg, String topic) {
        if (msg == null) {
            return;
        }
        if (!msgs.containsKey(topic)) {
            msgs.put(topic, new ArrayList<>());
        }
        //加入消息
        msgs.get(topic).add(msg);
    }


    /**
     * 消耗消息（拉取）
     * @param queue
     * @param topic
     * @return
     */
    public synchronized ByteMessage pull(String queue, String topic) {
        // readPos: key = queue + " " + topic.
        String k = queue + " " + topic;
        if (!readPos.containsKey(k)) {
            readPos.put(k, 0);
        }

        // 不包含topic 判断的逻辑有问题： 先判断是否存在topic 再去判断开始读取的位置
        int pos = readPos.get(k);
        if (!msgs.containsKey(topic)) {
            return null;
        }

        // 获得消息
        ArrayList<ByteMessage> list = msgs.get(topic);
        if (list.size() <= pos) {
            return null;
        } else {
            ByteMessage msg = list.get(pos);
            readPos.put(k, pos + 1);
            return msg;
        }
    }

}
