package hello.hellospring.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Date;

public class Diary {
    private int diaryIdx;
    private String diaryContent;
    private String diaryImg;
    private Date diaryDate;
    private String hashtag;
    private String isPublic;
    private String status;

    public Diary() {
    }

    public Diary(String diaryContent, String diaryImg, Date diaryDate, String hashtag, String isPublic) {
        this.diaryContent = diaryContent;
        this.diaryImg = diaryImg;
        this.diaryDate = diaryDate;
        this.hashtag = hashtag;
        this.isPublic = isPublic;
    }

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

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
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
