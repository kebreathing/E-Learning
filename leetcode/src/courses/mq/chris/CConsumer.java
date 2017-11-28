package courses.mq.chris;

import courses.mq.Consumer;
import courses.mq.interfaces.ByteMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CConsumer extends Consumer {

    String qName = null;            // 队列名字
    List<String> topics = new ArrayList<>();     // 被绑定的消息种类
    int curReadTopicIndex = 0;      // 当前要被读取的消息种类下标(指的是topics中的下标)

    @Override
    public void attachQueue(String queueName, Collection<String> topics) throws Exception {
        if(this.qName != null)
            throw new Exception("You can only do the 'attach' operation at once.");

        if(queueName == null || queueName.length() == 0)
            throw new Exception("The name of a queue cannot be null.");

        if(topics == null || topics.isEmpty())
            throw new Exception("The topics you wanna bind must have at least 1 topic.");

        this.qName = queueName;
//        this.topics = new ArrayList<>(topics); // 170 ms 上下
        this.topics.addAll(topics);
    }

    /**
     * 有问题的：
     * 1. store中存储的消息种类是不是只能由一个consumer消费
     * 2. 获得消息的顺序是，先获取指定topic的，再去获取下一个？
     *    还是随意获取？
     * @return
     * @throws Exception
     */
    @Override
    public ByteMessage poll() throws Exception {
        // 按Topic进行消费
        if(topics == null)
            throw new Exception("You must bind topics to the queue before you get message from it.");

        ByteMessage msg = null;
        for(int i = 0; i < topics.size(); i++){
            int topicId = (i + curReadTopicIndex) % topics.size();
            msg = CStore.instance.pull(qName, topics.get(topicId));
            if(msg != null){
                curReadTopicIndex = topicId + 1;
                break;
            }
        }

        return msg;
    }
}
