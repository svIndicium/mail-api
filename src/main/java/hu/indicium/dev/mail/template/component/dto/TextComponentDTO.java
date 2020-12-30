package hu.indicium.dev.mail.template.component.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import hu.indicium.dev.mail.template.component.components.TextComponent;
import lombok.Getter;
import lombok.Setter;
import hu.indicium.dev.mail.lib.Mapper;

@Getter
@Setter
@JsonTypeName("TEXT")
public class TextComponentDTO extends BaseComponentDTO<TextComponent> {
    private String text;

    public TextComponentDTO() {
    }

    @Override
    public TextComponent mapToDomain() {
        return Mapper.map(this, TextComponent.class);
    }
}
