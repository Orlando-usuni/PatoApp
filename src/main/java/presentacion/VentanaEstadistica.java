package presentacion;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;

import javax.swing.*;

public class VentanaEstadistica {
    private JPanel mainPanel;
    private JButton exportarArchivosButton;


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
    }
}
