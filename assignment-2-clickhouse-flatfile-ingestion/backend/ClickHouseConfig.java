package io.zeotap.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.clickhouse.client.ClickHouseDataSource;

import javax.sql.DataSource;

@Configuration
public class ClickHouseConfig {

    @Bean
    public DataSource clickHouseDataSource() {
        return new ClickHouseDataSource("jdbc:clickhouse://localhost:8123");
    }
}
