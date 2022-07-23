package hello.hellospring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcHomeRepository implements HomeRepository{

    private final JdbcTemplate jdbcTemplate;
    public JdbcHomeRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
