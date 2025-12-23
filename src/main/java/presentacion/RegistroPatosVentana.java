package presentacion;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import dominio.RegistroUsuario;
import servicios.ServicioListaUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroPatosVentana {
    private JPanel mainPanel;
    private JTextField textFieldNombre;
    private JTextField textFieldEdad;
    private JTextField textFieldCc;
    private JComboBox comboBoxCategoria;
    private JButton btnRegistrar;
    private JButton limpiarFormatoButton;
    private JComboBox comboBoxNPato;
    ServicioListaUsuario servicioListaUsuario = new ServicioListaUsuario();



    public void  agregarPato(String nombre){
        comboBoxNPato.addItem(nombre);
        comboBoxNPato.addItem("Panda");

    }

    public RegistroPatosVentana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                String edad = textFieldEdad.getText();
                String cc = textFieldCc.getText();
                String categoria = (String) comboBoxCategoria.getSelectedItem();
                String nPato = (String) comboBoxNPato.getSelectedItem();
                RegistroUsuario nuevo = new RegistroUsuario(nombre, edad, cc, categoria, nPato);

                if(nombre.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Error! Ingrese el campo de Nombre", "Campo obligatorio", JOptionPane.ERROR_MESSAGE);
                    return;


                } else if (edad.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error! Ingrese el campo de Edad", "Campo obligatorio", JOptionPane.ERROR_MESSAGE);
                    return;

                } else if(cc.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Error! Ingrese el campo de cc", "Campo obligatorio", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                boolean registrado = servicioListaUsuario.registrarUsuario(nuevo);

                if (!registrado) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ya existe un usuario con ese documento",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                JOptionPane.showMessageDialog(
                        null,
                        "Usuario registrado correctamente"
                );

                btnRegistrar.setEnabled(false);


            }
        });

        limpiarFormatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNombre.setText("");
                textFieldEdad.setText("");
                textFieldCc.setText("");
                comboBoxCategoria.setSelectedIndex(0);
                comboBoxNPato.setSelectedIndex(0);
                btnRegistrar.setEnabled(true);
            }
        });
    }

    JPanel getMainPanel(){
        return mainPanel;
    }

    public void mostrarVentana(Runnable alCerrar){//Recibe una accion a ejecutar

        FlatLaf.setup(new FlatDarculaLaf());
        FlatLaf.updateUI();

        JFrame frame = new JFrame("Ventana de registro");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (alCerrar != null) {
                    alCerrar.run();
                }
            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
}
