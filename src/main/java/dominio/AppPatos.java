package dominio;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import presentacion.Inicio;
import servicios.ManejoArchivos;


public class AppPatos {




    public static void main(String[] args) {
        ManejoArchivos manejoArchivos = new ManejoArchivos();
        manejoArchivos.CrearDocumento("registroUsuarios.txt");
        manejoArchivos.leerUsuariosDesdeTxt("registroUsuarios.txt");
        FlatLaf.setup(new FlatDarculaLaf());
        Inicio ventaInicio = new Inicio();
        ventaInicio.MostrarVentana();



    }

}
