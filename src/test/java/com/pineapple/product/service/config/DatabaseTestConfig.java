package com.pineapple.product.service.config;

import com.pineapple.product.service.infra.config.DatabaseCommonsConfig;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

@TestConfiguration
@ActiveProfiles("integration-tests")
@Import({DatabaseCommonsConfig.class, JpaTestConfig.class})
public class DatabaseTestConfig {
    @Bean
    public JdbcTemplate template(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
