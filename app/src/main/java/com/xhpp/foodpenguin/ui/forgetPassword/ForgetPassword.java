package com.xhpp.foodpenguin.ui.forgetPassword;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.login.LoginActivity;
import com.xhpp.foodpenguin.ui.register.RegisterActivity;

import java.util.regex.Pattern;

public class ForgetPassword extends AppCompatActivity
{
    FirebaseAuth fAuth;
    EditText fEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        fAuth = FirebaseAuth.getInstance();
        fEmail = findViewById(R.id.resetEmail);
    }

    public boolean emailCheck(String email)
    {
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})");
        if(TextUtils.isEmpty(email))    //check empty verification
        {
            fEmail.setError("Can't Empty");
            return false;
        }

        else if (!emailPattern.matcher(email).find())
        {
            fEmail.setError("Invalid Email");
            return false;
        }

        else
        {
            return true;
        }
    }

    public void resetPassword(View view) {
        final String email = fEmail.getText().toString();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        if (emailCheck(email))
        {
            fAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>()
            {
                @Override
                public void onSuccess(Void aVoid)
                {
                    Toast.makeText(ForgetPassword.this, "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener()
            {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    Toast.makeText(ForgetPassword.this, "Error, Reset Link Is Not Sent. " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            finish();
        }
    }

    public void signUp(View view)
    {
        Intent intent = new Intent(this , RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}
