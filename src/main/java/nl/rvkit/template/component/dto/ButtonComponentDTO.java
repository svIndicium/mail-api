package nl.rvkit.template.component.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import nl.rvkit.lib.Mapper;
import nl.rvkit.template.component.components.ButtonComponent;

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
