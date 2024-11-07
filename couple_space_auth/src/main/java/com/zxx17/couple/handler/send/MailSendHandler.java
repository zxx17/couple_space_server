package com.zxx17.couple.handler.send;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/27
 **/
@Slf4j
@Component
public class MailSendHandler implements SendMessageHandler {

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public SendTypeEnum getHandlerType() {
        return SendTypeEnum.EMAIL;
    }

    @Override
    public boolean send(String to, String theme, String message) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(theme);
            helper.setText(message, true);
            mailSender.send(helper.getMimeMessage());
            return true;
        } catch (MessagingException e) {
            log.error("发送邮件失败:" + e.getMessage());
            return false;
        }
    }



}
