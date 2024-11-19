package com.example.twofactorauthentification;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    private EditText emailField;
    private Button signupButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        emailField = findViewById(R.id.EmailAddress);
        signupButton = findViewById(R.id.signUpButton);


        signupButton.setOnClickListener(view->{
            String email = emailField.getText().toString().trim();

            Intent intent = new Intent(this, Verify.class);
            intent.putExtra("USER_EMAIL", email);
            startActivity(intent);

    });


}
}
