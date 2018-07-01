package com.example.user.simplejournal;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.user.simplejournal.data.DatabaseHelper;

public class InsertDiary extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText eTitle, eContent;
    ImageButton save, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_diary);

        eTitle = findViewById(R.id.et_title);
        eContent = findViewById(R.id.et_content);
        save = findViewById(R.id.btn_save);
        delete = findViewById(R.id.btn_delete);

        databaseHelper = new DatabaseHelper(this);
        insertDiary();
    }

    public void insertDiary() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = databaseHelper.insertData(eTitle.getText().toString(),
                        eContent.getText().toString());

                if (isInserted == true) {
                    Toast.makeText(InsertDiary.this, "Data inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(InsertDiary.this, "Data isn't inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void removeDiary(){
    }

}
