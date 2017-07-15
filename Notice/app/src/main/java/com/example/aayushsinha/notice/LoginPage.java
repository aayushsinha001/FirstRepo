package com.example.aayushsinha.notice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.name;

public class LoginPage extends AppCompatActivity {
EditText user,pass;
    String name1,pass1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        user = (EditText) findViewById(R.id.id_uname);
        pass = (EditText) findViewById(R.id.id_userpass);
    }

    public void mylogin1(View v){
        name1 = user.getText().toString();
        pass1 = pass.getText().toString();
        if(name1.equals("cse")&&pass1.equals("sit")){
            Intent i = new Intent(this,AfterLogin.class);
            startActivity(i);

        }
    }
}
