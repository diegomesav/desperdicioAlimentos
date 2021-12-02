package interfaze;

import java.util.List;

import modelo.bd.PublicacionesDTO;

public interface InicioInterface {

    interface View {
        void mostrarLista(List<PublicacionesDTO> publicacionesDTOList);
        void respuestaSalirApp();
    }

    interface Controlador {
        void recuperarLista();
        void salirApp();
    }

    interface Modelo {
        void obtenerLista();
    }

}
