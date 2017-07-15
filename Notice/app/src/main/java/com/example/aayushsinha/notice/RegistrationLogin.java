package com.example.aayushsinha.notice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistrationLogin extends AppCompatActivity {
EditText ET_NAME,ET_USN,ET_USER_PASS;
    String name,usn,user_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_login);

        ET_NAME= (EditText) findViewById(R.id.id_uname);
        ET_USN= (EditText) findViewById(R.id.id_usn);
        ET_USER_PASS= (EditText) findViewById(R.id.id_password);

    }
    public void myregister(View v){
      name = ET_NAME.getText().toString();
        usn=ET_USN.getText().toString();
        user_pass=ET_USER_PASS.getText().toString();
        String method = "register";
        BackGroundTask backGroundTask = new BackGroundTask(this);
        backGroundTask.execute(method,name,usn,user_pass);
        finish();
    }

    public void mylogin(View v){
        Intent i = new Intent(this,LoginPage.class);
        startActivity(i);
    }

}
