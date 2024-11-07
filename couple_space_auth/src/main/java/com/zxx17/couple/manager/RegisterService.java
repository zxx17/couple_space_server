package com.zxx17.couple.manager;

import com.zxx17.couple.controller.request.RegisterDTO;
import com.zxx17.couple.result.Result;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/27
 **/
public interface RegisterService {

    Result<String> register(RegisterDTO registerDTO);

}
