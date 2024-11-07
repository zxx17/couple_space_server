package com.zxx17.couple.component;

import com.zxx17.couple.handler.send.SendMessageHandler;
import com.zxx17.couple.handler.send.SendMessageHandlerFactory;
import com.zxx17.couple.util.ValidCodeUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/27
 **/
@Component
public class ValidCodeComponent {

    @Resource
    private SendMessageHandlerFactory sendMessageHandlerFactory;

    /**
     * 发送验证码
     */
    public boolean sendValidCode(String type, String to, String validCode, String code) {
        SendMessageHandler handler = sendMessageHandlerFactory.getHandler(Integer.parseInt(type));
        return handler.send(to, "注册验证码", validCode);
    }




    /**
     * 验证验证码
     */
}
