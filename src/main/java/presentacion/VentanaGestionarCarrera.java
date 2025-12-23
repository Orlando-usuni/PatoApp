package presentacion;

import dominio.RegistrarCarrera;
import servicios.ManejoArchivos;
import servicios.ServicioListaUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionarCarrera {
    private JPanel mainPanel;
    private JTextField textFieldNombreCarrera;
    private JComboBox comboBoxCategoriaCarreraA;
    private JTextField textFieldFechaCarrera;
    private JButton agregarPistaButton;
    ServicioListaUsuario servicioListaUsuario = new ServicioListaUsuario();
    ManejoArchivos manejoArchivos = new ManejoArchivos();


        public VentanaGestionarCarrera(){

            agregarPistaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nombre = textFieldNombreCarrera.getText();
                    String categoria = (String) comboBoxCategoriaCarreraA.getSelectedItem();
                    String fecha = textFieldFechaCarrera.getText();
                    RegistrarCarrera carrera = new RegistrarCarrera(nombre, categoria,fecha);

                    servicioListaUsuario.getlistCMapasCarrera().add(carrera);
                    //Guardarlo en txt
                    manejoArchivos.guardarPistasTxt(carrera);

                }
            });
        }

        JPanel getMainPanel(){
        return mainPanel;
    }



    public void MostrarVentana(Runnable accionAlCerrar){
        JFrame frame = new JFrame("Ventana Inicio");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (accionAlCerrar != null) {
                    accionAlCerrar.run(); //
                }
            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 300);
        frame.setVisible(true);

    }


}
