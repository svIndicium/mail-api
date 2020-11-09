package nl.rvkit.mail;

import lombok.Getter;

@Getter
public class MailProperties {

    public MailProperties() {
        email = System.getenv("MAIL_ADDRESS");
    }

    private final String email;

}
