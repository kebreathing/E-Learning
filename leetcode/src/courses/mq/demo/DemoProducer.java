package courses.mq.demo;


import pku.ByteMessage;
import pku.DefaultMessage;
import pku.MessageHeader;
import pku.Producer;

/**
 * Created by yangxiao on 2017/11/14.
 * 这是一个内存存储的
 */
public class DemoProducer extends Producer {

    /**
     * 创建信息实体
     * @param topic 消息头：分类
     * @param body  消息内容
     * @return
     */
    @Override
    public ByteMessage createBytesMessageToTopic(String topic, byte[] body) {
        ByteMessage msg = new DefaultMessage(body);
        msg.putHeaders(MessageHeader.TOPIC, topic);
        return msg;
    }

    /**
     * 传入默认信息实体：将信息发送到存储点Store
     * @param defaultMessage
     */
    @Override
    public void send(ByteMessage defaultMessage) {
        String topic = defaultMessage.headers().getString(MessageHeader.TOPIC);
        DemoMessageStore.store.push(defaultMessage, topic);
    }
}
