package nl.rvkit.mail.presentation;

import nl.rvkit.mail.application.IEmailService;
import nl.rvkit.mail.presentation.dto.HtmlMailRequest;
import nl.rvkit.mail.presentation.dto.SimpleMailRequest;
import nl.rvkit.mail.presentation.dto.TemplateMailRequest;
import nl.rvkit.template.application.ITemplateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mail")
public class EmailController {
    private final IEmailService emailService;
    private final ITemplateService templateService;

    public EmailController(IEmailService emailService, ITemplateService templateService) {
        this.emailService = emailService;
        this.templateService = templateService;
    }


    @PostMapping
    public void sendHtmlEmail(@RequestBody @Valid HtmlMailRequest mail) {
        emailService.sendHtmlMessage(mail.getReceiverList(), mail.getSubject(), mail.getMessage());
    }

    @PostMapping(value = "/simple")
    @ResponseStatus(HttpStatus.OK)
    public void sendMail(@RequestBody @Valid SimpleMailRequest mail) {
        emailService.sendSimpleMessage(mail.getReceiverList(), mail.getSubject(), mail.getMessage());
    }

    @PostMapping(value = "/template/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void sendTemplateMail(@PathVariable String name, @RequestBody @Valid TemplateMailRequest mail) {
        String template = templateService.getTemplateByNameAsHtml(name);
        emailService.sendTemplate(mail.getReceiverList(), mail.getSubject(), mail.getTemplateModel(), template);
    }

}
