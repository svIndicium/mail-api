package nl.rvkit.mail.presentation.dto;

import lombok.Getter;
import lombok.Setter;
import nl.rvkit.lib.EmailCollection;

import java.util.List;

@Getter
@Setter
public class SimpleMailRequest {
    private String subject;

    @EmailCollection
    private List<String> receiverList;

    private String message;
}
