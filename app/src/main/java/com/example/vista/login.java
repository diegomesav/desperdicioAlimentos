package com.example.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controlador.ControladorLogin;
import interfaze.LoginIterface;

public class login extends AppCompatActivity implements LoginIterface.View {

    private ControladorLogin controlador = new ControladorLogin(this);
    EditText tUsuario;
    EditText tContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();


        Button bingresar;
        Button bregistrarse;

        tUsuario = (EditText)findViewById(R.id.editUsuario);
        tContrasena = (EditText)findViewById(R.id.editPassword);
        bingresar = (Button)findViewById(R.id.btnIngresar);
        bregistrarse = (Button)findViewById(R.id.txtRegistrarse);

        bingresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Boolean t1,t2,t3;
                t1 = controlador.validarLogin(tUsuario.getText().toString(),"usuario");
                t2 =  controlador.validarLogin(tContrasena.getText().toString(),"password");
                if(t1 == true && t2 == true){
                    t3 = controlador.usuarioPermitido(tUsuario.getText().toString(),tContrasena.getText().toString());
                }
            }
        });

        bregistrarse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registrarse = new Intent(login.this,registrarse.class);
                startActivity(registrarse);
            }
        });
    }

    @Override
    public void validarResultado(String editText, String mensaje) {

            if(editText=="usuario" && !mensaje.isEmpty()){
                tUsuario.setError(mensaje);
            }
            else if(editText=="password" && !mensaje.isEmpty()){
                tContrasena.setError(mensaje);
            }
    }

    @Override
    public void usuarioAutorizado(Boolean valida) {
        if(valida == true){
            Intent menu = new Intent(this,menu.class);
            startActivity(menu);
            finish();
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "Usuario no permitido";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}