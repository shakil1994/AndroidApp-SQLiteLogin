package com.example.shakil.androidsqlitelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shakil.androidsqlitelogin.Database.MyDatabaseHelper;
import com.example.shakil.androidsqlitelogin.Model.UserDetails;

public class RegistrationActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtUserName, edtPassword;
    private Button btnSignUp;

    UserDetails userDetails;

    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userDetails = new UserDetails();
        myDatabaseHelper = new MyDatabaseHelper(this);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);

        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();

                userDetails.setName(name);
                userDetails.setEmail(email);
                userDetails.setUserName(userName);
                userDetails.setPassword(password);

                long rowId = myDatabaseHelper.insertData(userDetails);
                if (rowId > 0) {
                    Toast.makeText(RegistrationActivity.this, "Row " + rowId + " is successfully inserted.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegistrationActivity.this, ResultActivity.class));
                } else {
                    Toast.makeText(RegistrationActivity.this, "Data insertion failed", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
