package ufps.edu.co.canchas;

import android.support.v7.app.*;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Signup extends AppCompatActivity {

    private AppCompatSpinner departamentos;
    private ArrayList<String> spinnerArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        spinnerArray.add("Departamentos");
        spinnerArray.add("Norte de Santander");
        spinnerArray.add("Santander");
        departamentos = (AppCompatSpinner) findViewById(R.id.departamentos);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departamentos.setAdapter(spinnerArrayAdapter);
    }
}
