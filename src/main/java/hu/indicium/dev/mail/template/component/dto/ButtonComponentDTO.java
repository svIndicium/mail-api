package hu.indicium.dev.mail.template.component.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import hu.indicium.dev.mail.template.component.components.ButtonComponent;
import lombok.Getter;
import lombok.Setter;
import hu.indicium.dev.mail.lib.Mapper;

@Getter
@Setter
@JsonTypeName("BUTTON")
public class ButtonComponentDTO extends BaseComponentDTO<ButtonComponent> {
    private String text;
    private String link;

    public ButtonComponentDTO() {
    }

    @Override
    public ButtonComponent mapToDomain() {
        return Mapper.map(this, ButtonComponent.class);
    }
}
