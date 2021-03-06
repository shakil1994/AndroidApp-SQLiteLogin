package com.example.shakil.androidsqlitelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shakil.androidsqlitelogin.Database.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper myDatabaseHelper;

    private EditText edtUserName, edtPassword;
    private Button btnSignIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();

                if (v.getId() == R.id.btnSignIn) {
                    Boolean result = myDatabaseHelper.findPassword(userName, password);
                    if (result == true) {
                        Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, ResultActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Username or password didn't match.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnSignUp) {
                    startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
                }
            }
        });
    }
}
