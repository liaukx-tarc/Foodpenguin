package com.xhpp.foodpenguin.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.xhpp.foodpenguin.MainActivity;
import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.Users;
import com.xhpp.foodpenguin.ui.account.AccountFragment;
import com.xhpp.foodpenguin.ui.forgetPassword.ForgetPassword;
import com.xhpp.foodpenguin.ui.register.RegisterActivity;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth fAuth;
    FirebaseFirestore db;
    EditText mEmail;
    EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fAuth = FirebaseAuth.getInstance();
        mEmail = findViewById(R.id.emailTextInputLo);
        mPassword = findViewById(R.id.passTextInput);
        fAuth.signOut(); //set to logout
        if(fAuth.getCurrentUser() != null)
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            LoginActivity.this.startActivity(intent);
            finish();
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

    public void login(View view)
    {
        final String email = mEmail.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();

        if (emailCheck(email) | passwordCheck(password))
        {
            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    else
                    {
                        Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        else
        {
            Toast.makeText(LoginActivity.this,"Please Correct field!", Toast.LENGTH_SHORT);
        }
    }

    public void forgetPassword(View view)
    {
        Intent intent =  new Intent(this, ForgetPassword.class);
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