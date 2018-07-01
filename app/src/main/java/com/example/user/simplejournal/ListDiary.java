package com.example.user.simplejournal;

public class ListDiary {
    String diaryTitle;
    String diaryContent;

    public ListDiary(String diaryTitle, String diaryContent) {
        this.diaryTitle = diaryTitle;
        this.diaryContent = diaryContent;
    }

    public String getDiaryTitle() {
        return diaryTitle;
    }

    public String getDiaryContent() {
        return diaryContent;
    }
}
