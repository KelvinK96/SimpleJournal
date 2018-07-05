package com.example.user.simplejournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Signup extends AppCompatActivity {

    Button signup;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup = findViewById(R.id.btn_signup);
        tvLogin = findViewById(R.id.tv_login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToViewDiary();
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToViewLogin();
            }
        });
    }

    public void switchToViewDiary() {
        Intent intent = new Intent(Signup.this, ViewDiaryContent.class);
        startActivity(intent);
    }

    public void switchToViewLogin() {
        Intent intent = new Intent(Signup.this, Login.class);
        startActivity(intent);
    }
}
