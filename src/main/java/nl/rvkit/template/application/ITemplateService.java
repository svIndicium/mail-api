package nl.rvkit.template.application;

import nl.rvkit.template.component.components.BaseComponent;
import nl.rvkit.template.persistence.Template;
import nl.rvkit.template.presentation.dto.TemplateCreateDTO;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ITemplateService {
    //GET
    List<Template> getAll();

    Template getById(final String name);

    //POST
    void create(final TemplateCreateDTO template);

    //PUT
    void update(Template template);

    void addComponent(String name, BaseComponent component);

    void removeComponent(String name, Long componentId);

    String getTemplateByNameAsHtml(final String name);

    String getTemplateAsHtml(@NotNull Template template);

}
