package hu.indicium.dev.mail.lib.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebMvc
@Import(BeanValidatorPluginsConfiguration.class)
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, LocalDateTime.class)
                .directModelSubstitute(LocalDateTime.class, LocalDateTime.class)
                .securityContexts(Collections.singletonList(createSecurityContext()))
                .securitySchemes(Collections.singletonList(new ApiKey("JWT", "Authorization", "header")))
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private SecurityContext createSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .operationSelector(context -> true)
                .build();
    }

    List<SecurityReference> defaultAuth() {
        return Collections.singletonList(
                new SecurityReference("JWT", new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")})
        );
    }
}