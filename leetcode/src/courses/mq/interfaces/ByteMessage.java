package courses.mq.interfaces;

/**
 * Created by yangxiao on 2017/11/14.
 * 字节消息接口
 *
 */
public interface ByteMessage {

    //设置消息头
    void setHeaders(KeyValue headers);

    //获取字节数据
    byte[] getBody();

    //设置字节数据
    void setBody(byte[] body);

    KeyValue headers();

    //设置header
    ByteMessage putHeaders(String key, int value);

    ByteMessage putHeaders(String key, long value);

    ByteMessage putHeaders(String key, double value);

    ByteMessage putHeaders(String key, String value) ;

}
