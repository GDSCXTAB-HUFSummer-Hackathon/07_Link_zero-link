package hello.hellospring.repository;

import hello.hellospring.domain.Diary;
import hello.hellospring.domain.DiaryList;
import hello.hellospring.domain.Hashtag;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcDiaryRepository implements DiaryRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcDiaryRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<DiaryList> getDiaryList() {
        List<DiaryList> diaryLists = jdbcTemplate.query("SELECT D.diaryIdx, U.userIdx, U.username ,D.diaryContent, D.diaryImg, DATE_FORMAT(D.diaryDate, '%Y-%m-%d %a') AS diaryDate, D.status, D.isPublic FROM Diary D JOIN Member U on D.userIdx = U.userIdx where D.isPublic='Y' AND D.status='Y' ORDER BY D.createdAt DESC;",
                getDiaryListMapper());
        return diaryLists;

    }

    @Override
    public List<Hashtag> getHashTags() {
        List<Hashtag> hashtag = jdbcTemplate.query("SELECT H.hashtagContent, DH.diaryIdx\n" +
                "FROM DiaryHashtag DH JOIN Hashtag H on DH.hashtagIdx = H.hashtagIdx", getDiaryHashtagList());
        return hashtag;
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
