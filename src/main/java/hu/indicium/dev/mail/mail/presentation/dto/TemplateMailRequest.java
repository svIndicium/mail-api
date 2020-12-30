package hu.indicium.dev.mail.mail.presentation.dto;

import lombok.Getter;
import lombok.Setter;
import hu.indicium.dev.mail.lib.EmailCollection;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TemplateMailRequest {
    private String subject;

    @EmailCollection
    private List<String> receiverList;

    private Map<String, String> templateModel;
}
