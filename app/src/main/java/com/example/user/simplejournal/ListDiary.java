package com.example.user.simplejournal;

public class ListDiary {
    int id;
    String diaryTitle;
    String diaryContent;

    public ListDiary(int id, String diaryTitle, String diaryContent) {
        this.id = id;
        this.diaryTitle = diaryTitle;
        this.diaryContent = diaryContent;
    }

    public int getId() {
        return id;
    }

    public String getDiaryTitle() {
        return diaryTitle;
    }

    public String getDiaryContent() {
        return diaryContent;
    }
}
