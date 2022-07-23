package hello.hellospring.repository;

import hello.hellospring.domain.PostSignInReq;
import hello.hellospring.domain.PostUserRes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.*;

public class JdbcMemberRepository implements MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcMemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createUser(PostUserRes postUserRes) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("userIdx");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userName", postUserRes.getUserName());
        parameters.put("id", postUserRes.getId());
        parameters.put("password", postUserRes.getPassword());
        parameters.put("email", postUserRes.getEmail());
        parameters.put("phoneNumber", postUserRes.getPhoneNumber());
        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
    }

    @Override
    public boolean checkUser(PostSignInReq postSignInReq) {
        int res = jdbcTemplate.queryForObject("SELECT EXISTS(SELECT * FROM Member WHERE id=? AND password=?);", int.class, postSignInReq.getId(), postSignInReq.getPassword());
        if (res==0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int getUserIdx(String id) {
        String Query = "SELECT userIdx FROM User WHERE id=?";
        return jdbcTemplate.queryForObject(Query, int.class, id);
    }


}
