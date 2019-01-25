package com.example.shakil.sqlitelogin;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shakil.sqlitelogin.Database.MyDatabaseHelper;

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

                if (v.getId() == R.id.btnSignIn){

                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnSignUp){
                    startActivity(new Intent(MainActivity.this, SignUpActivity.class));
                }
            }
        });
    }
}
