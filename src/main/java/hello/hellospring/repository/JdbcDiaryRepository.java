package hello.hellospring.repository;

import hello.hellospring.domain.Diary;
import hello.hellospring.domain.DiaryList;
import hello.hellospring.domain.Hashtag;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcDiaryRepository implements DiaryRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcDiaryRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<DiaryList> getDiaryList() {
        List<DiaryList> diaryLists = jdbcTemplate.query("SELECT D.diaryIdx, U.userIdx, U.username ,D.diaryContent, D.diaryImg, FORMATDATETIME(D.diaryDate, 'yyyy-MM-dd') AS diaryDate, D.status, D.isPublic\n" +
                        "FROM Diary D JOIN Member U on D.userIdx = U.userIdx\n" +
                        "where D.isPublic='Y' AND D.status='Y'\n" +
                        "ORDER BY D.createdAt DESC;",
                getDiaryListMapper());
        return diaryLists;

    }

    @Override
    public void save(Diary diary, int userIdx) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("diary").usingGeneratedKeyColumns("diaryIdx");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userIdx", userIdx);
        parameters.put("diaryContent", diary.getDiaryContent());
        parameters.put("diaryDate", diary.getDiaryDate());
        parameters.put("isPublic", diary.getIsPublic());
        parameters.put("diaryImg", diary.getDiaryImg());
        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
    }

    @Override
    public List<Integer> getCalendar(int userIdx, int year, int month) {
        String Query = "SELECT DISTINCT FORMATDATETIME(diaryDate, 'dd') FROM Diary WHERE userIdx=? AND FORMATDATETIME(diaryDate, 'yyyy') = ? AND FORMATDATETIME(diaryDate, 'mm') = ? AND status='Y';";
        List<Integer> dates = jdbcTemplate.query(Query, getDateMapper(), userIdx, Integer.toString(year), Integer.toString(month));
        return dates;
    }

    private RowMapper<Integer> getDateMapper() {
        return (rs, rowNum) -> {
            return rs.getInt("date");
        };
    }

    private RowMapper<DiaryList> getDiaryListMapper() {
        return (rs, rowNum) -> {
            DiaryList diaryList = new DiaryList();
            diaryList.setUserIdx(rs.getInt("userIdx"));
            diaryList.setUsername(rs.getString("username"));
            diaryList.setDiaryIdx(rs.getInt("diaryIdx"));
            diaryList.setDiaryContent(rs.getString("diaryContent"));
            diaryList.setDiaryImg(rs.getString("diaryImg"));
            diaryList.setDiaryDate(rs.getString("diaryDate"));
            diaryList.setStatus(rs.getString("status"));
            diaryList.setHashtag(jdbcTemplate.queryForObject("SELECT H.hashtagContent\n" +
                    "FROM DiaryHasgtag DH JOIN Hashtag H on DH.hashtagIdx = H.hashtagIdx\n" +
                    "WHERE diaryIdx=?;", String.class, rs.getInt("diaryIdx")));
            return diaryList;
        };
    }

    private RowMapper<Hashtag> getDiaryHashtagList() {

        return (rs, rowNum) -> {
            Hashtag hashtag = new Hashtag();
            hashtag.setDiaryIdx(rs.getInt("diaryIdx"));
            hashtag.setHashtag(rs.getString("hashtagContent"));
            return hashtag;
        };
    }
}
