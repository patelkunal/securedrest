package org.coderearth.securedrest.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by kunal_patel on 1/21/17.
 */
@Configuration
@ComponentScan("org.coderearth.securedrest.core")
public class CoreConfig {

    @Bean
    // @Profile("dev")
    protected DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("appdb")
                .addDefaultScripts()
                .build();
    }

    // @Bean
    // @Profile("prod")
    // @Primary
    // protected DataSource dataSource() {
    //     // TODO - need to externalize these properties
    //     return new DriverManagerDataSource("jdbc:mysql://localhost:3306/appdb", "root", "root");
    // }

    @Bean
    protected JdbcTemplate template(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
