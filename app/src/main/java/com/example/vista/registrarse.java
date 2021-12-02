package com.example.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

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
    Spinner sexo2;
    EditText sexo;
    int seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        getSupportActionBar().hide();


        nombre = getFormFieldValue(R.id.editNombres);
        apellido = getFormFieldValue(R.id.editApellidos);
        spSexo = ((Spinner) findViewById(R.id.spSexo)).getSelectedItem().toString();
        sexo2 = (Spinner) findViewById(R.id.spSexo);
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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexo, android.R.layout.simple_spinner_item);
        ((Spinner) findViewById(R.id.spSexo)).setAdapter(adapter);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulario = new FormularioDTO(nombre.getText().toString(), apellido.getText().toString(), ((Spinner) findViewById(R.id.spSexo)).getSelectedItem().toString(), direccion.getText().toString(),
                        correo.getText().toString(), ciudad.getText().toString(), celular.getText().toString(), contrasena.getText().toString(), usuario.getText().toString());
                controlador.validarFormulario(formulario);
                Boolean ingresoUsuario = controlador.validarFormulario(formulario);
                if (ingresoUsuario == true){
                    controlador.usuarioGuardarUsuario(formulario);
                    
                }
            }


        });

    }


    private EditText getFormFieldValue(int field) {
         return ((EditText) findViewById(field));
    }

    @Override
    public void validarResultadoFormulario(String editText, String mensaje) {

        System.out.println(mensaje);

        if(!mensaje.isEmpty()){
            switch (editText) {
                case "nombre":
                    nombre.setError(mensaje);
                    break;


                case "apellido":
                    apellido.setError(mensaje);
                    break;



                case "direccion":
                    direccion.setError(mensaje);
                    break;


                case "correo":
                    correo.setError(mensaje);
                    break;


                case "ciudad":
                    ciudad.setError(mensaje);
                    break;


                case "celular":
                    celular.setError(mensaje);
                    break;


                case "contrasena":
                    contrasena.setError(mensaje);
                    break;


                case "usuario":
                    usuario.setError(mensaje);
                    break;

                case "sexo":
                    Toast toast = Toast.makeText(getBaseContext(), mensaje, Toast.LENGTH_LONG);
                    toast.show();
                    break;

            }
            /*Toast toast = Toast.makeText(getBaseContext(), seleccion, Toast.LENGTH_LONG);
            toast.show();*/
        }
    }


    @Override
    public void respuestaGuardadoUsuario(Boolean respuesta) {
        if(respuesta == true){
            Toast toast = Toast.makeText(getBaseContext(), "Usuario guardado", Toast.LENGTH_LONG);
            toast.show();
        }

    }


}