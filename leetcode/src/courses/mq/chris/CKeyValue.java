package courses.mq.chris;

import courses.mq.interfaces.KeyValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 实现自定义key-value对
 * 封装成 Python 字典dict
 */
public class CKeyValue implements KeyValue{

    private HashMap<String, Object> map = null;

    public CKeyValue(){
        map = new HashMap<>();
    }

    @Override
    public HashMap<String, Object> getMap() {
        return map;
    }

    @Override
    public Object getObj(String key) {
        return map.get(key);
    }

    @Override
    public KeyValue put(String key, int value) {
        map.put(key, value);
        return this;
    }

    @Override
    public KeyValue put(String key, long value) {
        map.put(key, value);
        return this;
    }

    @Override
    public KeyValue put(String key, double value) {
        map.put(key, value);
        return this;
    }

    @Override
    public KeyValue put(String key, String value) {
        map.put(key, value);
        return this;
    }

    @Override
    public int getInt(String key) {
        return (int)map.get(key);
    }

    @Override
    public long getLong(String key) {
        return (long)map.get(key);
    }

    @Override
    public double getDouble(String key) {
        return (double)map.get(key);
    }

    @Override
    public String getString(String key) {
        return (String)map.get(key);
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }
}
