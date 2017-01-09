package org.coderkitchen.securedrest;

import org.coderearth.securedrest.jwtsecurity.config.SecurityConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

/**
 * Created by kunal_patel on 12/30/16.
 */
@SpringBootApplication
@Import(SecurityConfig.class)
public class Application {


    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .build(args)
                .run();
    }

}
