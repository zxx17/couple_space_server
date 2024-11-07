package com.zxx17.couple.controller.request;

import lombok.Data;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/27
 **/
@Data
public class RegisterDTO {

    private String email;
    private String phoneNumber;
    private String password;
    private String validCode;
    private String registerType;

}
