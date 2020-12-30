package hu.indicium.dev.mail.template.application;

import hu.indicium.dev.mail.template.component.components.BaseComponent;
import hu.indicium.dev.mail.template.presentation.dto.TemplateCreateDTO;
import hu.indicium.dev.mail.template.persistence.Template;

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
