package com.jtc.ykt.wechat.service;

import java.util.Map;

/**
 * @Author: 小天
 * @Date: 2023/9/4 - 09 - 04 - 18:51
 * @Decsription: com.jtc.ykt.wechat.service
 * @version: 1.0
 */
public interface MessageService {
    //接收消息
    String receiveMessage(Map<String, String> param);

    void pushPayMessage(long l);
}
