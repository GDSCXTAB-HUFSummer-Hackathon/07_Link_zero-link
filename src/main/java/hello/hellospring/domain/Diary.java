package hello.hellospring.domain;

import java.util.Date;
import java.util.List;

public class Diary {
    private int diaryIdx;
    private String diaryContent;
    private String diaryImg;
    private Date diaryDate;
    private List<String> hashtags;
    private String isPublic;
    private String status;

    public int getDiaryIdx() {
        return diaryIdx;
    }

    public void setDiaryIdx(int diaryIdx) {
        this.diaryIdx = diaryIdx;
    }

    public String getDiaryContent() {
        return diaryContent;
    }

    public void setDiaryContent(String diaryContent) {
        this.diaryContent = diaryContent;
    }

    public String getDiaryImg() {
        return diaryImg;
    }

    public void setDiaryImg(String diaryImg) {
        this.diaryImg = diaryImg;
    }

    public Date getDiaryDate() {
        return diaryDate;
    }

    public void setDiaryDate(Date diaryDate) {
        this.diaryDate = diaryDate;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
