package hu.indicium.dev.mail.template.component.components;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import hu.indicium.dev.mail.lib.StringHelper;

import javax.persistence.Entity;
import javax.persistence.Transient;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class TextComponent extends BaseComponent {
    private String text;

    @Transient
    private String templateName = "text";

    @Override
    public String getTemplateName() {
        return templateName;
    }

    @Override
    public String fillInTemplate() {
        String html = getComponentHTML();
        html = StringHelper.replacePlaceholder(html, "text", this.text);
        return html;
    }

}
