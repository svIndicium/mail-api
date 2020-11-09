package nl.rvkit.template.component.components;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.rvkit.lib.exceptions.MyFileNotFoundException;
import nl.rvkit.template.component.ComponentEnum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.util.ResourceUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
