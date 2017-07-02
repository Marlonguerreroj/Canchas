package ufps.edu.co.canchas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.*;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

import ufps.edu.co.canchas.dto.UsuarioDTO;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatTextView lblSignUp;
    private AppCompatEditText user;
    private AppCompatEditText pass;
    private AppCompatButton btnLogIn;
    private RequestQueue queue;
    private Boolean estado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogIn = (AppCompatButton) findViewById(R.id.btnLogIn);
        lblSignUp = (AppCompatTextView) findViewById(R.id.lblSignUp);
        user = (AppCompatEditText) findViewById(R.id.user);
        pass = (AppCompatEditText) findViewById(R.id.pass);
        lblSignUp.setOnClickListener(this);
        btnLogIn.setOnClickListener(this);
        queue = Volley.newRequestQueue(this);


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
                Log.i("ws","doIt");
                // prepare the Request
                String u = user.getText().toString();
                Log.i("user",u);
                if(!u.isEmpty()){
                JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, Constant.URL_LISTAR_USUARIOS+u, null,
                        new Response.Listener<JSONObject>()
                        {
                            @Override
                            public void onResponse(JSONObject response) {
                                // display response
                                Log.i("Response", response.toString());
                                Gson g = new Gson();
                                UsuarioDTO dto = g.fromJson(response.toString(), UsuarioDTO.class);

                                if(dto.getUsuario()!= null && dto.getContrasena().equals(pass.getText().toString())){
                                    Log.i("name",""+dto.getUsuario());
                                    Bundle b = new Bundle();
                                    b.putString("user",response.toString());

                                    user.setText("");
                                    pass.setText("");
                                    iniciarSesion(b);

                                }else{
                                    Log.i("Error","NULL");
                                    user.setError("Datos incorrectos");
                                    pass.setError("Datos incorrectos");
                                    user.setText("");
                                    pass.setText("");
                                }

                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.i("Error.Response", "Error: "+error.getMessage());
                            }
                        }
                );
               // ConfigureApp.getInstance().addToRequestQueue(req,tag_json_array);
                queue.add(getRequest);
                }else{
                    user.setError("Datos incorrectos");
                    pass.setError("Datos incorrectos");
                    user.setText("");
                    pass.setText("");
                }
                break;

        }

    }

    public void iniciarSesion(Bundle b){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(b);
        startActivity(intent);
    }


}
