package nl.rvkit.lib;

import nl.rvkit.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Component
@EnableWebMvc
@ComponentScan({"nl.rvkit.freemarker"})
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public MailProperties mailProperties() {
        return new MailProperties();
    }

}
