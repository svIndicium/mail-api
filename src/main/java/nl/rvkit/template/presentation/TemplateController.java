package nl.rvkit.template.presentation;

import nl.rvkit.template.application.ITemplateService;
import nl.rvkit.template.component.components.BaseComponent;
import nl.rvkit.template.component.dto.BaseComponentDTO;
import nl.rvkit.template.persistence.Template;
import nl.rvkit.template.presentation.dto.TemplateCreateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/templates")
@SuppressWarnings("rawtypes")
public class TemplateController {
    private final ITemplateService templateService;

    public TemplateController(ITemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Template>> getAll() {
        return ResponseEntity.ok(templateService.getAll());
    }

    @GetMapping(value = "/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Template> get(@PathVariable String name) {
        return ResponseEntity.ok(templateService.getById(name));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TemplateCreateDTO template) {
        templateService.create(template);
    }

    @PostMapping(value = "/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void addComponent(@PathVariable String name, @RequestBody BaseComponentDTO baseComponentDTO) {
        BaseComponent component = (BaseComponent) baseComponentDTO.mapToDomain();

        templateService.addComponent(name, component);
    }

}
