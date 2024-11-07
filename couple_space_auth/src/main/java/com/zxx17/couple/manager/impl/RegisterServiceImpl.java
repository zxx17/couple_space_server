package com.zxx17.couple.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zxx17.couple.constant.RedisConstant;
import com.zxx17.couple.controller.request.RegisterDTO;
import com.zxx17.couple.domain.CpUser;
import com.zxx17.couple.manager.RegisterService;
import com.zxx17.couple.result.Result;
import com.zxx17.couple.service.impl.CpUserServiceImpl;
import com.zxx17.couple.util.SaltMD5Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/27
 **/
@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {


    @Value("${auth.salt}")
    private String salt;

    private final CpUserServiceImpl cpUserService;

    private final StringRedisTemplate stringRedisTemplate;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result<String> register(RegisterDTO registerDTO) {
        // 获取注册类型，1是邮箱注册，2是手机号注册
        String registerType = registerDTO.getRegisterType();
        // 对比Redis验证码 register:code:{email/phone} => {code}
        String codeInCache;
        String userName;
        if ("1".equals(registerType)) {
            String email = registerDTO.getEmail();
            boolean exists = cpUserService.exists(new LambdaQueryWrapper<CpUser>().eq(CpUser::getEmail, email));
            if (exists) {
                return Result.fail("该邮箱已注册，请更换邮箱注册");
            }
            userName = "CP" + email;
            codeInCache = stringRedisTemplate.opsForValue().get(RedisConstant.REGISTER_CODE_PREFIX + email);
        } else if ("2".equals(registerType)) {
            String phoneNumber = registerDTO.getPhoneNumber();
            boolean exists = cpUserService.exists(new LambdaQueryWrapper<CpUser>().eq(CpUser::getPhoneNumber, phoneNumber));
            if (exists) {
                return Result.fail("该手机号已注册，请更换手机号注册");
            }
            userName = "CP" + phoneNumber;
            codeInCache = stringRedisTemplate.opsForValue().get(RedisConstant.REGISTER_CODE_PREFIX + phoneNumber);
        } else {
            return Result.fail();
        }
        if (!registerDTO.getValidCode().equals(codeInCache)) {
            return Result.fail("验证码错误，请核对后重试");
        }
        // 获取密码，进行加密
        String password = SaltMD5Utils.generateSaltPassword(registerDTO.getPassword(), salt);
        // 设置默认信息
        CpUser cpUser = new CpUser();
        BeanUtils.copyProperties(registerDTO, cpUser);
        cpUser.setPassword(password);
        // 初始化默认头像
        cpUser.setAvatarUrl("default");
        // 初始化默认会员等级
        cpUser.setMembershipLevel(0);
        // 初始化用户名
        cpUser.setUsername(userName);
        // 保存用户信息
        cpUserService.save(cpUser);
        return Result.ok();
    }
}
