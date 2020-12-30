package hu.indicium.dev.mail.mail.application;

import java.util.List;
import java.util.Map;

public interface IEmailService {
    void sendSimpleMessage(List<String> to, String subject, String text);

    void sendHtmlMessage(List<String> to, String subject, String text);

    void sendTemplate(List<String> to, String subject, Map<String, String> templateModel, String html);
}
