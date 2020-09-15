package com.xhpp.foodpenguin.ui.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.Users;
import com.xhpp.foodpenguin.ui.login.LoginActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText mUsername;
    EditText mPhone;
    EditText mEmail;
    EditText mPassword;
    EditText mPassRetype;
    Button   mRegisterBtn;
    FirebaseFirestore db;
    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mUsername      = findViewById(R.id.usernameTextInput);
        mPhone         = findViewById(R.id.phoneNumberTextInput);
        mEmail         = findViewById(R.id.emailTextInput);
        mPassword      = findViewById(R.id.passwordTextInput);
        mPassRetype    = findViewById(R.id.retypePasswordTextInput);
        mRegisterBtn   = findViewById(R.id.registerButton);
        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }


    public void signIn(View view)
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    //Username Validation
    public boolean usernameCheck(String username)
    {

        if(TextUtils.isEmpty(username)) //check empty username
        {
            mUsername.setError("Can't Empty");
            return false;
        }

        else if (username.length() > 25)
        {
            mUsername.setError("Username can't long then 25");
            return false;
        }

        else
        {
            return true;
        }
    }

    //Phone Validation
    public boolean phoneCheck(String phone)
    {
        String phonePattern = "^(\\d{3,4}[- .]?)(\\d{3}[- .]?)\\d{4}$";
        if(TextUtils.isEmpty(phone))   //check empty phone
        {
            mPhone.setError("Can't Empty");
            return false;
        }

        else if(!phone.matches(phonePattern))
        {
            mPhone.setError("Invalid Phone");
            return false;
        }

        else
        {
            return true;
        }
    }

    //email Validation
    public boolean emailCheck(String email)
    {
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})");
        if(TextUtils.isEmpty(email))    //check empty verification
        {
            mEmail.setError("Can't Empty");
            return false;
        }

        else if (!emailPattern.matcher(email).find())
        {
            mEmail.setError("Invalid Email");
            return false;
        }

        else
        {
            return true;
        }
    }

    //Password Validation
    public boolean passwordCheck(String password)
    {
        Pattern alphabet = Pattern.compile("[a-zA-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern space = Pattern.compile("\\s");



        if(TextUtils.isEmpty(password))    //check empty password
        {
            mPassword.setError("Can't Empty");
            return false;
        }

        else if(password.length() < 6)
        {
            mPassword.setError("Password must at least 6");
            return false;
        }

        else if(!alphabet.matcher(password).find())
        {
            mPassword.setError("Password must have at least 1 alphabet");
            return false;
        }

        else if(space.matcher(password).find())
        {
            mPassword.setError(("Password Can't have space"));
            return false;
        }

        else if(!digit.matcher(password).find())
        {
            mPassword.setError("Password must have at least 1 digit");
            return false;
        }

        else
        {
            return true;
        }
    }

    //Retype Password validation
    public boolean retypeCheck(String password, String retypePass)
    {

        if(TextUtils.isEmpty(retypePass))  //check empty retype password
        {
            mPassRetype.setError("Can't Empty");
            return false;
        }

        else if(!password.matches(retypePass) ) //check password same with retype password
        {
            mPassRetype.setError(("Not Same with Password"));
            return false;
        }

        else
        {
            return true;
        }
    }

    public void register(View view)
    {
        final String username     = mUsername.getText().toString().trim();
        final String phone        = mPhone.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String password     = mPassword.getText().toString().trim();
        String retypePass   = mPassRetype.getText().toString().trim();

        if(usernameCheck(username) & phoneCheck(phone) & emailCheck(email) & passwordCheck(password) & retypeCheck(password,retypePass))
        {
            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        String UserId = fAuth.getCurrentUser().getUid();

                        Users users = new Users(username,password,phone,email);
                        DocumentReference documentReference = db.collection("users").document(UserId);
                        documentReference.set(users);
                        Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                        RegisterActivity.this.startActivity(intent);
                        finish();
                    }

                    else
                    {
                        Toast.makeText(RegisterActivity.this, "Email have been used", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        else
        {
            Toast.makeText(RegisterActivity.this,"Please Correct field!", Toast.LENGTH_SHORT);
        }

    }
}