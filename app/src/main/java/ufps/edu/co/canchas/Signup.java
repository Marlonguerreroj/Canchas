package ufps.edu.co.canchas;

import android.content.Intent;
import android.support.v7.app.*;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton registrar;
    private AppCompatEditText usuario;
    private AppCompatEditText nombre;
    private AppCompatEditText email;
    private AppCompatEditText contrasena;
    private AppCompatEditText telefono;
    private RequestQueue queue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        registrar = (AppCompatButton) findViewById(R.id.registrar);
        usuario = (AppCompatEditText) findViewById(R.id.txtUsuario);
        nombre = (AppCompatEditText) findViewById(R.id.txtNombre);
        email = (AppCompatEditText) findViewById(R.id.txtEmail);
        contrasena = (AppCompatEditText) findViewById(R.id.txtContrasena);
        telefono = (AppCompatEditText) findViewById(R.id.txtTelefono);
        registrar.setOnClickListener(this);
        queue = Volley.newRequestQueue(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registrar:
                if(nombre.getText().toString().trim().isEmpty()){
                    nombre.setError("El nombre es requerido");
                    break;
                }else if(email.getText().toString().trim().isEmpty()){
                    email.setError("El email es requerido");
                    break;
                }else if(usuario.getText().toString().trim().isEmpty()){
                    usuario.setError("El usuario es requerido");
                    break;
                }else if(contrasena.getText().toString().trim().isEmpty()){
                    contrasena.setError("La contraseña es requerida");
                    break;
                }else if(telefono.getText().toString().trim().isEmpty()){
                    telefono.setError("El telefono es requerido");
                    break;
                }
                StringRequest postRequest = new StringRequest(Request.Method.POST, Constant.URL_REGISTRAR_USUARIO,
                        new Response.Listener<String>(){
                @Override
                public void onResponse(String response){
                    Log.d("Response",response);
                }
            }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error) {
                    // error
                    Log.d("Error.Response", "Error: "+error.getMessage());
                }
            }){
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("usuario", usuario.getText().toString());
                    params.put("nombre",nombre.getText().toString() );
                    params.put("email", email.getText().toString());
                    params.put("contrasena",contrasena.getText().toString() );
                    params.put("telefono", telefono.getText().toString());

                    return params;
                }
            };
            queue.add(postRequest);

            Intent intent1 = new Intent(this, LoginActivity.class);
            startActivity(intent1);
            break;
        }
    }
}
