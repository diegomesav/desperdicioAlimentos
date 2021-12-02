package controlador;

import interfaze.FormularioInterfaz;
import modelo.bd.Formulario;
import modelo.bd.FormularioDTO;
import modelo.bd.UsuarioDto;

public class ControladorFormulario implements FormularioInterfaz.Controlador {

    private final FormularioInterfaz.View view;

    public ControladorFormulario(FormularioInterfaz.View view) {
        this.view = view;
    }

    @Override
    public Boolean validarFormulario(Formulario formularioDTO) {
        return null;
    }

    @Override
    public Boolean validarFormulario(FormularioDTO formularioDTO) {
        System.out.println(formularioDTO);
        if (formularioDTO.getEditNombres().toString().trim().isEmpty()) {
            view.validarResultadoFormulario("nombre", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditApellidos().toString().trim().isEmpty()) {
            view.validarResultadoFormulario("apellido", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getSpSexo().toString().trim().equalsIgnoreCase("SELECCIONE EL SEXO")) {
            view.validarResultadoFormulario("sexo", "Seleccione ");
            return false;
        } else if (formularioDTO.getEditDireccion().toString().trim().isEmpty()) {
            view.validarResultadoFormulario("direccion", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditCorreo().toString().trim().isEmpty()) {
            view.validarResultadoFormulario("correo", "Los campos no pueden estar vacíos");
            return false;
        } else if (!formularioDTO.getEditCorreo().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")) {
            view.validarResultadoFormulario("correo", "El correo debe ser valido");
            return false;
        } else if (formularioDTO.getEditCiudad().toString().trim().isEmpty()) {
            view.validarResultadoFormulario("ciudad", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditCelular().toString().trim().isEmpty()) {
            view.validarResultadoFormulario("celular", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditUsuario().toString().trim().isEmpty()) {
            view.validarResultadoFormulario("usuario", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditPassword().toString().trim().isEmpty()) {
            view.validarResultadoFormulario("password", "Los campos no pueden estar vacíos");
            return false;
        } else if (formularioDTO.getEditPassword().length() < 6) {
            view.validarResultadoFormulario("password_length", "La contraseña debe tener mínimo 6 caracteres");
            return false;
        }

        return true;
    }


    @Override
    public Boolean usuarioGuardarUsuario(FormularioDTO formularioDTO) {
        if (formularioDTO != null) {
            UsuarioDto usuario = UsuarioDto.getInstance();
            usuario.setNombre(formularioDTO.getEditNombres());
            usuario.setApellido(formularioDTO.getEditApellidos());
            usuario.setSexo(formularioDTO.getSpSexo());
            usuario.setDireccion(formularioDTO.getEditDireccion());
            usuario.setCorreo(formularioDTO.getEditCorreo());
            usuario.setCiudad(formularioDTO.getEditCiudad());
            usuario.setCelular(formularioDTO.getEditCelular());
            usuario.setUsuario(formularioDTO.getEditUsuario());
            usuario.setPassword(formularioDTO.getEditPassword());
            view.respuestaGuardadoUsuario(true);
            return true;
        } else {
            view.respuestaGuardadoUsuario(false);
            return false;
        }
    }

}