package com.example.aayushsinha.notice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AfterLogin extends AppCompatActivity {
EditText msgbox;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        msgbox = (EditText) findViewById(R.id.id_message);


    }

    public void mypost(View v){
        message = msgbox.getText().toString();
        String method = "login";
        BackGroundTask1 backGroundTask1 = new BackGroundTask1(this);
        backGroundTask1.execute(method,message);
        finish();
    }
}
