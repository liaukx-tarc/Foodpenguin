package com.xhpp.foodpenguin.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xhpp.foodpenguin.MainActivity;
import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void forgetPassword(View view)
    {

    }

    public void login(View view)
    {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void signUp(View view)
    {
        Intent intent = new Intent(this , RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}