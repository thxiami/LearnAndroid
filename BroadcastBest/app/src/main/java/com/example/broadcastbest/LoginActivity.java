package com.example.broadcastbest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";

    private EditText accountEdit;
    private EditText passwwordEdit;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountEdit = findViewById(R.id.account);
        passwwordEdit = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        LoginActivity.this,
                        "You clicked login Button.",
                        Toast.LENGTH_SHORT
                ).show();

                String account = accountEdit.getText().toString();
                Log.d(TAG, "onClick: accountEdit.getText():" + accountEdit.getText());
                String pwd = passwwordEdit.getText().toString();

                if ("admin".equals(account) && "123".equals(pwd)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(
                            LoginActivity.this,
                            "Wrong account or pwd",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}
