package nl.rvkit.template.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITemplateRepository extends JpaRepository<Template, String> {
}
