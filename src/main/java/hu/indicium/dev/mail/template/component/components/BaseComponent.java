package hu.indicium.dev.mail.template.component.components;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import hu.indicium.dev.mail.lib.exceptions.MyFileNotFoundException;
import hu.indicium.dev.mail.template.component.ComponentEnum;
import org.springframework.util.ResourceUtils;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseComponent implements Comparable<BaseComponent> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int position;
    private ComponentEnum type;
    public abstract String getTemplateName();

    @Override
    public int compareTo(BaseComponent baseComponent) {
        return this.getPosition() - baseComponent.getPosition();
    }

    public abstract String fillInTemplate();

    protected String getComponentHTML() {
        try {
            File file = ResourceUtils.getFile("classpath:templates/" + getTemplateName() + ".html");
            return Files.readString(file.toPath());
        } catch (IOException e) {
            throw new MyFileNotFoundException("Could not find:" + getTemplateName() + ".html");
        }
    }
}
