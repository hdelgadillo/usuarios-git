package com.sysview.docauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }    

    public static void main(String... args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
/* ORIGINAL
@SpringBootApplication
@EnableAutoConfiguration

public class Application{
   	
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}*/
