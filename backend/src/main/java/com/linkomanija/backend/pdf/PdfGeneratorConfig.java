package com.linkomanija.backend.pdf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import static org.thymeleaf.templatemode.TemplateMode.HTML;

@Configuration
public class PdfGeneratorConfig {
  private static final String UTF_8 = "UTF-8";

  @Bean
  public TemplateEngine engine() {
    final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setPrefix("/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(HTML);
    templateResolver.setCharacterEncoding(UTF_8);

    final TemplateEngine engine = new TemplateEngine();
    engine.setTemplateResolver(templateResolver);
    engine.addDialect(new Java8TimeDialect());

    return engine;
  }
}
