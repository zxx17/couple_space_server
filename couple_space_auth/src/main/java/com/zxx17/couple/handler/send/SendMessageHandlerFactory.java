package com.zxx17.couple.handler.send;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/27
 **/
@Component
public class SendMessageHandlerFactory implements InitializingBean {
    @Resource
    private List<SendMessageHandler> sendMessageHandlerList;

    private final Map<SendTypeEnum, SendMessageHandler> handlerMap = new HashMap<>();


    public SendMessageHandler getHandler(int subjectType) {
        SendTypeEnum sendTypeEnum = SendTypeEnum.getByTypeCode(subjectType);
        return handlerMap.get(sendTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (SendMessageHandler sendMessageHandler : sendMessageHandlerList) {
            handlerMap.put(sendMessageHandler.getHandlerType(), sendMessageHandler);
        }
    }



}
