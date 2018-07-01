package com.example.user.simplejournal.data;

import android.provider.BaseColumns;

public class Contract {
    public static final class DiaryEntry {
        public static final String TABLE_NAME = "diary_details";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_CONTENT = "content";
    }
}
