package com.example.shakil.sqlitelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shakil.sqlitelogin.Database.MyDatabaseHelper;
import com.example.shakil.sqlitelogin.Model.UserDetails;

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class SignUpActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtUserName, edtPassword;
    private Button btnSignUp;

    UserDetails userDetails;

    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

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

            }
        });

    }

}
