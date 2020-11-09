package nl.rvkit.template.application;

import nl.rvkit.lib.Mapper;
import nl.rvkit.template.component.components.BaseComponent;
import nl.rvkit.template.persistence.ITemplateRepository;
import nl.rvkit.template.persistence.Template;
import nl.rvkit.template.presentation.dto.TemplateCreateDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class TemplateService implements ITemplateService {
    private final ITemplateRepository repository;

    public TemplateService(ITemplateRepository repository) {
        this.repository = repository;
    }

    //GET
    @Override
    public List<Template> getAll() {
        return repository.findAll();
    }

    @Override
    public Template getById(String name) {
        return repository.findById(name).orElseThrow(() -> new EntityNotFoundException("Template with name: " + name + " was not found"));
    }

    //POST
    @Override
    public void create(TemplateCreateDTO createDTO) {
        Template template = Mapper.map(createDTO, Template.class);
        repository.save(template);
    }

    //UPDATE
    @Override
    public void update(Template template) {
        repository.save(template);
    }

    @Override
    public void addComponent(String name, BaseComponent component) {
        if (!exists(name)) {
            Template newTemplate = new Template(name);
            repository.save(newTemplate);
        }
        Template template = getById(name);
        template.addComponent(component);
        update(template);
    }

    @Override
    public void removeComponent(String name, Long componentId) {

    }

    @Override
    public String getTemplateByNameAsHtml(String name) {
        return getTemplateAsHtml(getById(name));
    }

    @Override
    public String getTemplateAsHtml(Template template) {
        List<BaseComponent> components = template.getComponents();
        Collections.sort(components);

        //Create new HTML document
        Document document = Jsoup.parse("");
        for (BaseComponent component : components) {
            document.body().append(component.fillInTemplate());
        }
        return document.html();
    }


    private boolean exists(String name) {
        return repository.existsById(name);
    }
}
