package com.task.university;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String LOGIN_AND_PASSWORD = "test";
    private EditText loginEditText, passwordEditText;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeWidgets();
    }

    private void initializeWidgets() {
        loginEditText = (EditText) findViewById(R.id.loginEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (loginEditText != null && passwordEditText != null) {
            if (loginEditText.getText().toString().equals(LOGIN_AND_PASSWORD) &&
                    passwordEditText.getText().toString().equals(LOGIN_AND_PASSWORD)) {
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                finishActivity(0);
            }
        }
    }
}
