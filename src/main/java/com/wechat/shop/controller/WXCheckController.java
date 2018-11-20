package com.wechat.shop.controller;

import com.wechat.shop.entity.AccessToken;
import com.wechat.shop.entity.MsgEntity;
import com.wechat.shop.entity.User;
import com.wechat.shop.entity.VoiceEntity;
import com.wechat.shop.service.AccessTokenServie;
import com.wechat.shop.service.MsgService;
import com.wechat.shop.service.VoiceMsgService;
import com.wechat.shop.utils.CheckUtils;
import com.wechat.shop.utils.MsgUtils;
import com.wechat.shop.utils.WeiXinUtils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

@Controller
public class WXCheckController {

    @Autowired
    private MsgService msgService;

    @Autowired
    private VoiceMsgService voiceMsgService;

    @Autowired
    private AccessTokenServie accessTokenServie;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        PrintWriter out = response.getWriter();
        if (CheckUtils.checkSignatrue(signature,timestamp,nonce)){
            out.print(echostr);
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void server(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String str = null;
        try {
            //将request请求，传到Message工具类的转换方法中，返回接收到的Map对象
            Map<String,String> map = MsgUtils.xmlToMap(request);
            //从集合中获取各个节点的内容
            String ToUserName = map.get("ToUserName");
            String FromUserName = map.get("FromUserName");
            String CreateTime = map.get("CreateTime");
            String MsgType = map.get("MsgType");
            String MsgId = map.get("MsgId");
            AccessToken token = accessTokenServie.checkAccessToken();
            if (MsgType.equals("text")){
                String Content = map.get("Content");
                msgService.save(ToUserName,FromUserName,CreateTime,MsgType,Content,MsgId);
                User user = WeiXinUtils.getUser(token.getAccessToken(),FromUserName);
                MsgEntity msg = new MsgEntity();
                msg.setToUserName(FromUserName);
                msg.setFromUserName(ToUserName);
                msg.setCreateTime(new Date().getTime());
                msg.setMsgType("text");
                msg.setContent("您好，"+user.getNickname()+"\n我是："+ToUserName
                        +"\n您想要找的商品为："+Content);
                msg.setMsgId(MsgId);
                str = MsgUtils.textToXml(msg);        //调用Message工具类，将对象转为XML字符串
            }else if (MsgType.equals("voice")){
                String MediaId = map.get("MediaId");
                String Format = map.get("Format");
                String Recognition = map.get("Recognition");
                VoiceEntity voice = new VoiceEntity();
                voice.setToUserName(ToUserName);
                voice.setFromUserName(FromUserName);
                voice.setCreateTime(new Date().getTime());
                voice.setMsgType(MsgType);
                voice.setFormat(Format);
                voice.setMediaId(MediaId);
                voice.setRecognition(Recognition);
                voice.setMsgId(MsgId);
                voiceMsgService.save(voice);
                User user = WeiXinUtils.getUser(token.getAccessToken(),FromUserName);
                MsgEntity msg = new MsgEntity();
                msg.setToUserName(FromUserName);
                msg.setFromUserName(ToUserName);
                msg.setCreateTime(new Date().getTime());
                msg.setMsgType("text");
                msg.setContent("您好，"+user.getNickname()+"\n您说的是："+Recognition);
                msg.setMsgId(MsgId);
                str = MsgUtils.textToXml(msg);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        out.print(str);     //返回转换后的XML字符串
        out.close();
    }
}
