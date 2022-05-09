package com.example.backend_cleaningsupplie.email;

import com.example.backend_cleaningsupplie.confirm_token_email.EmailService;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;


@Service
@AllArgsConstructor
public class MailService implements MailSender {

    private final JavaMailSender javaMailSender;
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Override
    @Async
    public void send(List<String> allUserEmail, String subject, String massUtskick) {
        for (int i = 0; i < allUserEmail.size(); i++) {
            try {
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
                mimeMessageHelper.setText(massUtskick);
                mimeMessageHelper.setTo(allUserEmail.get(i));
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setFrom("ulf.mandorff@gmail.com");

            } catch (MessagingException e) {
                LOGGER.error("Failed to send email ", e);
                throw new IllegalStateException("Failed to send email to " + allUserEmail.get(i));
            }
        }
    }
}
