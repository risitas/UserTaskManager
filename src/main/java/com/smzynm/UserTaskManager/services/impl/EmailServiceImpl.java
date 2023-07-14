package com.smzynm.UserTaskManager.services.impl;

import com.smzynm.UserTaskManager.dto.post.EmailPostDto;
import com.smzynm.UserTaskManager.services.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Override
    public Boolean sendEmail(EmailPostDto emailPostDto) throws Exception {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setSubject(emailPostDto.getSubject());
            helper.setText(emailPostDto.getBody(), true);
            helper.setTo(emailPostDto.getAddressee());
            helper.setFrom("no_reply@dominio.com");
            javaMailSender.send(message);
        }catch (Exception e){
            e.getMessage();
        }
        return true;
    }
}
