package hu.indicium.dev.mail.template.component.components;

import lombok.Getter;
import lombok.Setter;
import hu.indicium.dev.mail.lib.StringHelper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
public class ButtonComponent extends BaseComponent {
    private String text;
    private String link;
    @Column(columnDefinition = "varchar(255) default '#B0B0B0'")
    private String color = "#B0B0B0";
    @Column(columnDefinition = "varchar(255) default '#FFFFFF'")
    private String textColor = "#FFFFFF";
    @Transient
    private String templateName = "button";

    @Override
    public String getTemplateName() {
        return templateName;
    }

    @Override
    public String fillInTemplate() {
       String html = getComponentHTML();
       html = StringHelper.replacePlaceholder(html, "text", this.text);
       html = StringHelper.replacePlaceholder(html, "link", this.link);
       html = StringHelper.replacePlaceholder(html, "color", this.color);
       html = StringHelper.replacePlaceholder(html, "textColor", this.textColor);
       return html;
    }


}

