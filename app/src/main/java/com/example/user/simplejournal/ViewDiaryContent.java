package com.example.user.simplejournal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.simplejournal.data.Contract;
import com.example.user.simplejournal.data.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ViewDiaryContent extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListDiary> listDiaries;
    TextView listDiaryContent;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diary_content);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listDiaryContent = findViewById(R.id.tv_list_diary);
        databaseHelper = new DatabaseHelper(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToInsertDiary();
            }
        });

        recyclerView = findViewById(R.id.rc_diary);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listDiaries = new ArrayList<>();
        viewAll();
    }

    // Display diary list on a card view
    public void viewAll() {
        Cursor cursor = databaseHelper.loadDiary();
        List<ListDiary> listDiaries = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                do {
                    listDiaries.add(new ListDiary(
                            cursor.getInt(0),       // ID
                            cursor.getString(1),    // title
                            cursor.getString(2)     // content

                    ));
                } while (cursor.moveToNext());

                adapter = new DiaryAdapter(listDiaries, getApplicationContext(), ViewDiaryContent.this);
                recyclerView.setAdapter(adapter);
            }
        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }
    }

    public void showSelectedContent() {
        Cursor cursor = databaseHelper.loadSelectedContent();
        try {
            cursor.getInt(0);
            String title = cursor.getString(1);
            String content = cursor.getString(2);

            showDiary(title, content);
        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_LONG).show();
            Log.e("Content error", "Error: " + e);
        }

    }

    public void showDiary(String title, String disease) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(disease);
        builder.show();
    }

    public void switchToInsertDiary() {
        Intent intent = new Intent(ViewDiaryContent.this, InsertDiary.class);
        startActivity(intent);
    }

    public void switchToTodoDetails() {
        Intent intent = new Intent(ViewDiaryContent.this, ToDoDetails.class);
        startActivity(intent);
    }
}
