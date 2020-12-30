package hu.indicium.dev.mail.mail.presentation.dto;

import lombok.Getter;
import lombok.Setter;
import hu.indicium.dev.mail.lib.EmailCollection;

import java.util.List;

@Getter
@Setter
public class HtmlMailRequest {
    private String subject;

    @EmailCollection
    private List<String> receiverList;

    private String message;
}
