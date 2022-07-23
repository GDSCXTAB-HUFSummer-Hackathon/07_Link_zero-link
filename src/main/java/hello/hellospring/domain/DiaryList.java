package hello.hellospring.domain;

public class DiaryList {
    private int userIdx;
    private String username;
    private int diaryIdx;
    private String diaryContent;
    private String diaryImg;
    private String diaryDate;
    private String status;
//    private List<String> hashtags;

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getDiaryDate() {
        return diaryDate;
    }

    public void setDiaryDate(String diaryDate) {
        this.diaryDate = diaryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
