package ufps.edu.co.canchas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.support.v7.widget.*;
import android.view.WindowManager;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatTextView lblSignUp;
    private AppCompatButton btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lblSignUp = (AppCompatTextView) findViewById(R.id.lblSignUp);
        btnLogIn = (AppCompatButton) findViewById(R.id.btnLogIn);
        lblSignUp.setOnClickListener(this);
        btnLogIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.lblSignUp:
                intent = new Intent(this, Signup.class);
                startActivity(intent);
                break;
            case R.id.btnLogIn:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }

    }
}
