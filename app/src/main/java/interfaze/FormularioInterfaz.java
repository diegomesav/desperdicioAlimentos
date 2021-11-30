package interfaze;

import modelo.bd.Formulario;
import modelo.bd.FormularioDTO;

public interface FormularioInterfaz {

    interface View {
        void validarResultadoFormulario(String editText, String mensaje);
        void respuestaGuardadoUsuario(Boolean respuesta);
    }

    interface Controlador {
        Boolean validarFormulario(Formulario formularioDTO);

        Boolean validarFormulario(FormularioDTO formularioDTO);
        Boolean usuarioGuardarUsuario(FormularioDTO formularioDTO);
    }

    interface Modelo {
    }

}
