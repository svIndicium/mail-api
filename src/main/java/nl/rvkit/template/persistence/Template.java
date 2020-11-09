package nl.rvkit.template.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.rvkit.template.component.components.BaseComponent;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Template {
    @Id
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BaseComponent> components;

    public Template(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(BaseComponent component) {
        this.components.add(component);
    }


}
