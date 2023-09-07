package com.jtc.ykt.wechat.api;

import com.jtc.ykt.Result;
import com.jtc.ykt.wechat.service.MessageService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.crypto.SHA1;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 小天
 * @Date: 2023/9/4 - 09 - 04 - 16:32
 * @Decsription: com.jtc.ykt.wechat.api
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/wechat/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    private static final String token = "psjj";

    /**
     * 服务器有效性校验
     *
     */
    @GetMapping
    public String verifyToken(HttpServletRequest request){
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if(this.checkSignature(signature,timestamp,nonce)){
            return echostr;
        }
        return "error";
    }

    private boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] str = new String[]{token,timestamp,nonce};
        //排序
        Arrays.sort(str);
        //进行sha1加密
        String temp = SHA1.gen(str);
        //与微信提供的signature进行皮队
        return signature.equals(temp);
    }

    /**
     * 接收微信服务器发送来的消息
     * @param request
     * @return
     * @throws Exception
     */
//    @PostMapping
//    public String receiveMessage(HttpServletRequest request) throws Exception {
//
//        WxMpXmlMessage wxMpXmlMessage = WxMpXmlMessage.fromXml(request.getInputStream());
//        System.out.println(JSONObject.toJSONString(wxMpXmlMessage));
//        return "success";
//    }
    /**
     * 接收微信服务器发送来的消息
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping
    public String receiveMessage(HttpServletRequest request) throws Exception {
        Map<String, String> param = this.parseXml(request);
        return messageService.receiveMessage(param);
    }

    private Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        InputStream inputStream = request.getInputStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        inputStream.close();
        inputStream = null;
        return map;
    }

    @GetMapping("/pushPayMessage")
    public Result pushPayMessage() throws WxErrorException {
        messageService.pushPayMessage(1L);
        return Result.ok();
    }
}
