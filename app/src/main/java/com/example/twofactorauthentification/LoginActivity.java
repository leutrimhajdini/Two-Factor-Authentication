package com.example.twofactorauthentification;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private EditText emailInput, passwordInput;
    private TextView signupText;
    private Button login;

    DB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.nameEditText);
        passwordInput = findViewById(R.id.passwordEditText);
        login = findViewById(R.id.loginButton);
        signupText = findViewById(R.id.signupTextView);


        DB = new DB(this);


        login.setOnClickListener(v->validateLogin());

        signupText.setOnClickListener(v->{
            startActivity(new Intent(this, SignUp.class));
        });


    }


    private void validateLogin(){
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if(email.isEmpty()){
            Toast.makeText(this,"Please enter your email!", Toast.LENGTH_SHORT).show();
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this,"Please enter a valid email address!", Toast.LENGTH_SHORT).show();
        }else if(password.isEmpty()){
            Toast.makeText(this,"Please enter your Password!", Toast.LENGTH_SHORT).show();
        }else{
            boolean userExists = DB.validateUser(email, password);
            if(userExists){
                Toast.makeText(this,"Credentials okay!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Credentials are wrong!", Toast.LENGTH_SHORT).show();

            }

        }








    }

}
