package com.zxx17.couple.handler.send;

import java.util.Objects;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/27
 **/
public enum SendTypeEnum {

    EMAIL(1),
    MOBILE(2);

    private final Integer type;

    SendTypeEnum(Integer type){
        this.type = type;
    }

    public static SendTypeEnum getByTypeCode(Integer type) {
        for (SendTypeEnum subjectInfoTypeEnum : SendTypeEnum.values()) {
            if (Objects.equals(subjectInfoTypeEnum.type, type)) {
                return subjectInfoTypeEnum;
            }
        }
        return null;
    }

}
