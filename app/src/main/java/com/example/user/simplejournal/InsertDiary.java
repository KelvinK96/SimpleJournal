package com.example.user.simplejournal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.user.simplejournal.data.DatabaseHelper;

public class InsertDiary extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText eTitle, eContent;
    ImageButton save, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_diary);

        eTitle = findViewById(R.id.et_title);
        eContent = findViewById(R.id.et_content);
        save = findViewById(R.id.btn_save);
        clear = findViewById(R.id.btn_clear);

        databaseHelper = new DatabaseHelper(this);
        insertDiary();
        setClear();
    }

    public void insertDiary() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = databaseHelper.insertData(eTitle.getText().toString(),
                        eContent.getText().toString());

                if (isInserted) {
                    Toast.makeText(InsertDiary.this, "Data inserted", Toast.LENGTH_LONG).show();
                    removeDiary();
                } else {
                    Toast.makeText(InsertDiary.this, "Data isn't inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // clear diary content when clear button is clicked
    public void setClear() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeDiary();
            }
        });
    }

    // method to clear edit text fields
    public void removeDiary() {
        eTitle.setText(null);
        eContent.setText(null);
    }

}
