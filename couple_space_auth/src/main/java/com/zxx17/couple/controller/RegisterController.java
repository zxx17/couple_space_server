package com.zxx17.couple.controller;

import com.zxx17.couple.component.ValidCodeComponent;
import com.zxx17.couple.constant.RedisConstant;
import com.zxx17.couple.controller.request.RegisterDTO;
import com.zxx17.couple.manager.RegisterService;
import com.zxx17.couple.result.Result;
import com.zxx17.couple.util.ValidCodeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/27
 **/
@Slf4j
@RequestMapping("/auth/register")
@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    private final ValidCodeComponent validCodeComponent;

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 发送注册验证码
     *
     * @param type 1为邮箱验证码 2为手机验证码
     */
    @GetMapping("/sendValidCode/{type}/{to}")
    public Result<String> sendValidCode(@PathVariable String type, @PathVariable String to) {
        String code = ValidCodeUtil.generateRandomValidCode();
        String message = "<p>亲爱的 " + to + "，</p>" +
                "<p>欢迎来到情侣空间！🎉</p>" +
                "<p>您的验证码是：<strong>" + code + "</strong></p>" +
                "<p>在这里，你们可以记录美好的瞬间，分享彼此的心情，共同创造属于两个人的甜蜜回忆。我们为你们提供了丰富的功能，让爱情更加甜蜜和有趣。</p>" +
                "<p>愿你们的爱情之路充满幸福与美好！</p>" +
                "<p>祝你使用愉快！</p>" +
                "<p>情侣空间团队</p>";
        boolean res = validCodeComponent.sendValidCode(type, to, message, code);
        if (!res) {
            return Result.fail("验证码发送失败，请检查后重试~");
        }
        stringRedisTemplate.opsForValue()
                .set(RedisConstant.REGISTER_CODE_PREFIX + to, code, 300, TimeUnit.SECONDS);
        return Result.ok("验证码发送成功~");
    }

    /**
     * 用户注册
     *
     * @return
     */
    @PostMapping
    public Result<String> register(@RequestBody RegisterDTO registerDTO) {
        if (log.isInfoEnabled()) {
            log.info("用户注册请求参数：{}", registerDTO.toString());
        }
        return registerService.register(registerDTO);
    }


}
