package presentacion;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import dominio.RegistrarPato;
import servicios.ServicioListaUsuario;

import javax.swing.*;

public class VentanaEstadistica {
    private JPanel mainPanel;
    private JButton exportarArchivosButton;
    private JLabel jLabelPatoVeloz;
    ServicioListaUsuario servicioListaUsuario = new ServicioListaUsuario();

    public void patoVeloz(){
        int velocidadPato = 0;
        for(RegistrarPato pato : servicioListaUsuario.getListaPatos()){
            if(pato.getContadorGanancia() > velocidadPato){
                velocidadPato = pato.getContadorGanancia();
            }
        }
        for(RegistrarPato pato : servicioListaUsuario.getListaPatos()){
            if(velocidadPato == pato.getContadorGanancia()){
                jLabelPatoVeloz.setText("EL PATO MAS VELOZ:+" + pato.getNombre());
            }
        }
    }


    public void mostrarVentana(){
        // Configurar el tema Darcula
        FlatLaf.setup(new FlatDarculaLaf());
        // Opcional: Para que se integre mejor con el sistema operativo
        FlatLaf.updateUI();

        JFrame frame = new JFrame("Ventana de registro");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 600);
        frame.setVisible(true);
        patoVeloz();

    }
}
