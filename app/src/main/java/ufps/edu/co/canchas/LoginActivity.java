package ufps.edu.co.canchas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.support.v7.widget.*;
import android.view.WindowManager;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatTextView txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtSignUp = (AppCompatTextView) findViewById(R.id.SignUp);
        txtSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SignUp:
                Intent intent1 = new Intent(this,Signup.class);
                startActivity(intent1);
                break;

        }

    }
}
