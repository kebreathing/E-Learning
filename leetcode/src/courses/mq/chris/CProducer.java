package courses.mq.chris;

import courses.mq.MessageHeader;
import courses.mq.Producer;
import courses.mq.interfaces.ByteMessage;

public class CProducer extends Producer {

    /**
     * 生成消息
     * @param topic 消息种类标识符
     * @param body  消息内用结果体
     * @return      消息实体
     * @throws Exception
     */
    @Override
    public ByteMessage createBytesMessageToTopic(String topic, byte[] body) throws Exception {
        // Fill Message Headers
        // Fill the 'Topic' field
        return new CByteMessage(topic, body);
    }

    /**
     * 发送消息指 CStore 仓库
     * @param msg
     * @throws Exception
     */
    @Override
    public void send(ByteMessage msg) throws Exception {
        CStore.instance.push(msg.headers().getString(MessageHeader.TOPIC), msg);
    }

    @Override
    public void flush() throws Exception {
        super.flush();
    }
}
