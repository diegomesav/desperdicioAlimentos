package com.example.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import controlador.ControladorFormulario;
import interfaze.FormularioInterfaz;
import modelo.bd.Formulario;
import modelo.bd.FormularioDTO;

public class registrarse extends AppCompatActivity implements FormularioInterfaz.View{

    FormularioDTO formulario;
    private ControladorFormulario controlador = new ControladorFormulario(this);

    EditText nombre;
    EditText apellido;
    String spSexo;
    EditText direccion;
    EditText correo;
    EditText ciudad;
    EditText celular;
    EditText contrasena;
    EditText usuario;
    Button btnFoto;
    ImageView foto;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        getSupportActionBar().hide();



        nombre = getFormFieldValue(R.id.editNombres);
        apellido = getFormFieldValue(R.id.editApellidos);
        spSexo = ((Spinner) findViewById(R.id.spSexo)).getSelectedItem().toString();
        direccion = getFormFieldValue(R.id.editDireccion);
        correo = getFormFieldValue(R.id.editCorreo);
        ciudad = getFormFieldValue(R.id.editCiudad);
        celular = getFormFieldValue(R.id.editCelular);
        contrasena = getFormFieldValue(R.id.editPassword);
        usuario = getFormFieldValue(R.id.editUsuario);
        btnFoto = (Button) findViewById(R.id.btnFoto);
        foto = (ImageView) findViewById(R.id.foto);
        registrar = (Button) findViewById(R.id.btnRegistrar);

        /*String[] opciones = {
                "","Masculino","Femenino","Otro"
        };
        ArrayAdapter <String> adapter = new ArrayAdapter <String>(this,android.R.layout.simple_list_item_1,opciones);
        spSexo.setAdapter(adapter);*/

        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sexo,android.R.layout.simple_spinner_item);
        ((Spinner) findViewById(R.id.spSexo)).setAdapter(adapter);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulario = new FormularioDTO(nombre.getText().toString(),apellido.getText().toString(),spSexo,direccion.getText().toString(),
                        correo.getText().toString(),ciudad.getText().toString(),celular.getText().toString(),contrasena.getText().toString(),usuario.getText().toString());
                controlador.validarFormulario(formulario);
            }
        });


    }

    private EditText getFormFieldValue(int field) {
         return ((EditText) findViewById(field));
    }

    @Override
    public void validarResultadoFormulario(String editText, String mensaje) {

        System.out.println(mensaje);

        if(!editText.isEmpty()){
            switch (editText) {
                case "nombre":
                    nombre.setError(mensaje);


                case "apellido":
                    apellido.setError(mensaje);


                case "direccion":
                    direccion.setError(mensaje);


                case "correo":
                    correo.setError(mensaje);


                case "ciudad":
                    ciudad.setError(mensaje);


                case "celular":
                    celular.setError(mensaje);


                case "contrasena":
                    contrasena.setError(mensaje);


                case "usuario":
                    usuario.setError(mensaje);

            }
        }
    }

    @Override
    public void respuestaGuardadoUsuario(Boolean respuesta) {

    }


}