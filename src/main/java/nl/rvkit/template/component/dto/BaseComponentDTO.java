package nl.rvkit.template.component.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import nl.rvkit.template.component.ComponentEnum;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ButtonComponentDTO.class, name = "BUTTON"),
        @JsonSubTypes.Type(value = TextComponentDTO.class, name = "TEXT")
})
@Getter
@Setter
public abstract class BaseComponentDTO<DOMAIN> {

    private int position;
    private ComponentEnum type;

    public abstract DOMAIN mapToDomain();
}
