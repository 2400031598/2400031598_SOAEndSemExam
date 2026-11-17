
package com.example.dockercomposedemo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DataController {

    private final JdbcTemplate jdbcTemplate;

    public DataController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/data")
    public Map<String, String> getData() {

        String database = jdbcTemplate.queryForObject(
            "SELECT DATABASE()", String.class
        );

        return Map.of(
            "message", "Application connected successfully to MySQL!",
            "database", database,
            "status", "SUCCESS"
        );
    }
}
