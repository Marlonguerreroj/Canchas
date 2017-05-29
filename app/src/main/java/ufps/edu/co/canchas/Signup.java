package ufps.edu.co.canchas;

import android.content.Intent;
import android.support.v7.app.*;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        registrar = (AppCompatButton) findViewById(R.id.registrar);
        registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registrar:
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
