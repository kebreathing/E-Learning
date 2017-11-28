package courses.mq.chris;

import courses.mq.MessageHeader;
import courses.mq.interfaces.ByteMessage;
import courses.mq.interfaces.KeyValue;

/**
 * 实现自定义消息实体
 */
public class CByteMessage implements ByteMessage {

    private byte[] msg = null;
    private KeyValue kvs = null;

    // 消息头中应该包含字段和函数
    // 必须要保证逻辑正确性

    /**
     * 只填入消息内容，不填消息头
     * @param body
     */
    public CByteMessage(byte[] body){
        msg = body;
        kvs = new CKeyValue();
    }

    /**
     * 只填入消息头的topic字段，以及消息体
     * @param topic
     * @param body
     */
    public CByteMessage(String topic, byte[] body){
        kvs = new CKeyValue();
        kvs.put(MessageHeader.TOPIC, topic);
        msg = body;
    }

    /**
     * 填入像段消息头字段，以及消息体
     * @param kvs
     * @param body
     */
    public CByteMessage(KeyValue kvs, byte[] body){
        if(kvs == null){
            kvs = new CKeyValue();
        }

        setBody(body);
        setHeaders(kvs);
    }

    @Override
    public void setHeaders(KeyValue headers) {
        kvs = headers;
    }

    @Override
    public byte[] getBody() {
        if (msg == null) return null;
        else             return msg;
    }

    @Override
    public void setBody(byte[] body) {
        msg = body;
    }

    // 获得整个 Message Head
    @Override
    public KeyValue headers() {
        return kvs;
    }

    @Override
    public ByteMessage putHeaders(String key, int value) {
        kvs.put(key, value);
        return this;
    }

    @Override
    public ByteMessage putHeaders(String key, long value) {
        kvs.put(key, value);
        return this;
    }

    @Override
    public ByteMessage putHeaders(String key, double value) {
        kvs.put(key, value);
        return this;
    }

    @Override
    public ByteMessage putHeaders(String key, String value) {
        kvs.put(key, value);
        return this;
    }
}
