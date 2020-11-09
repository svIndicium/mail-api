package nl.rvkit.mail.application;

import nl.rvkit.lib.StringHelper;
import nl.rvkit.lib.exceptions.MyMailMessageException;
import nl.rvkit.mail.MailProperties;
import nl.rvkit.template.persistence.Template;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Map;

@Service
public class EmailService implements IEmailService {

    private final JavaMailSender mailSender;
    private final MailProperties properties;

    public EmailService(JavaMailSender mailSender, MailProperties properties) {
        this.mailSender = mailSender;
        this.properties = properties;
    }

    @Override
    public void sendSimpleMessage(List<String> to, String subject, String text) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(properties.getEmail());
        mail.setTo(to.toArray(new String[0]));
        mail.setSubject(subject);
        mail.setText(text);
        mailSender.send(mail);
    }

    @Override
    public void sendHtmlMessage(List<String> to, String subject, String text) {
        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, "utf-8");
        try {
            helper.setFrom(properties.getEmail());
            helper.setTo(to.toArray(new String[0]));

            helper.setSubject(subject);
            helper.setText(text, true);
        } catch (MessagingException e) {
            throw new MyMailMessageException("Error in sending html mail:" + e.getMessage());
        }
        mailSender.send(mail);
    }

    @Override
    public void sendTemplate(List<String> to, String subject, Map<String, String> templateModel, String html) {
        for (Map.Entry<String, String> entry : templateModel.entrySet()){
            html = StringHelper.replacePlaceholder(html, entry.getKey(), entry.getValue());
        }
        sendHtmlMessage(to, subject, html);
    }


}
