package com.zxx17.couple.handler.send;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/27
 **/
public interface SendMessageHandler {


    SendTypeEnum getHandlerType();

    boolean send(String to,String theme,String message);

}
