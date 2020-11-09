package nl.rvkit.template.component.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import nl.rvkit.lib.Mapper;
import nl.rvkit.template.component.components.TextComponent;

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
