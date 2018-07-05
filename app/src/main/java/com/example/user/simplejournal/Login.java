package com.example.user.simplejournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button login;
    TextView tvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvSignup = findViewById(R.id.tv_signup);
        login = findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToViewDiary();
            }
        });

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToViewSignup();
            }
        });
    }

    public void switchToViewDiary() {
        Intent intent = new Intent(Login.this, ViewDiaryContent.class);
        startActivity(intent);
    }

    public void switchToViewSignup() {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }
}
