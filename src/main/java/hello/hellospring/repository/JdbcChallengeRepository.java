package hello.hellospring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcChallengeRepository implements ChallengeRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcChallengeRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


}
