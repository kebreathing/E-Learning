package medium;

import java.util.ArrayList;
import java.util.List;

public class Lit535 {
    // 这种加密和解密的方式很有意思呀哈哈哈哈
    List<String> urls = new ArrayList<>();

    public String encode(String longUrl){
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1); // 返回的是长度
    }

    public String decode(String shortUrl){
        int index = Integer.valueOf(shortUrl); // 记录的其实就是 URL 在序列中的位置
        return (index < urls.size()? urls.get(index) : "");
    }
}
