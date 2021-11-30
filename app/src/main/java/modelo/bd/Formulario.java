package modelo.bd;

import android.widget.EditText;
import android.widget.Spinner;

import interfaze.FormularioInterfaz;

public class Formulario implements FormularioInterfaz.View {

    private EditText editNombres;
    private EditText editApellidos;
    private Spinner spSexo;
    private EditText editDireccion;
    private EditText editCorreo;
    private EditText editCiudad;
    private EditText editCelular;
    private EditText editUsuario;
    private EditText editPassword;


    public Formulario(EditText editNombres, EditText editApellidos, Spinner spSexo,
                      EditText editDireccion, EditText editCorreo, EditText editCiudad, EditText editCelular,
                      EditText editUsuario, EditText editPassword) {
        this.editNombres = editNombres;
        this.editApellidos = editApellidos;
        this.spSexo = spSexo;
        this.editDireccion = editDireccion;
        this.editCorreo = editCorreo;
        this.editCiudad = editCiudad;
        this.editCelular = editCelular;
        this.editUsuario = editUsuario;
        this.editPassword = editPassword;

    }

    public EditText getEditNombres() {
        return editNombres;
    }

    public void setEditNombres(EditText editNombres) {
        this.editNombres = editNombres;
    }

    public EditText getEditApellidos() {
        return editApellidos;
    }

    public void setEditApellidos(EditText editApellidos) {
        this.editApellidos = editApellidos;
    }

    public Spinner getSpSexo() {
        return spSexo;
    }

    public void setSpSexo(Spinner spSexo) {
        this.spSexo = spSexo;
    }

    public EditText getEditDireccion() {
        return editDireccion;
    }

    public void setEditDireccion(EditText editDireccion) {
        this.editDireccion = editDireccion;
    }

    public EditText getEditCorreo() {
        return editCorreo;
    }

    public void setEditCorreo(EditText editCorreo) {
        this.editCorreo = editCorreo;
    }

    public EditText getEditCiudad() {
        return editCiudad;
    }

    public void setEditCiudad(EditText editCiudad) {
        this.editCiudad = editCiudad;
    }

    public EditText getEditCelular() {
        return editCelular;
    }

    public void setEditCelular(EditText editCelular) {
        this.editCelular = editCelular;
    }

    public EditText getEditUsuario() {
        return editUsuario;
    }

    public void setEditUsuario(EditText editUsuario) {
        this.editUsuario = editUsuario;
    }

    public EditText getEditPassword() {
        return editPassword;
    }

    public void setEditPassword(EditText editPassword) {
        this.editPassword = editPassword;
    }

    @Override
    public void validarResultadoFormulario(String editText, String mensaje) {
        
    }

    @Override
    public void respuestaGuardadoUsuario(Boolean respuesta) {

    }
}

