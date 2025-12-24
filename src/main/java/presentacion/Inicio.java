package presentacion;

import dominio.RegistrarCarrera;
import dominio.RegistrarPato;
import dominio.RegistroUsuario;
import servicios.ManejoArchivos;
import servicios.ServicioListaUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio {
    private JPanel mainPanel;
    private JButton btnRegistro;
    private JButton btnCarrera;
    private JButton btnEstadistica;
    private JButton iniciarCarreraButton;
    private JButton añadirPatoButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton buscarButton;
    private JTable tblRegistro;
    private JScrollPane JScrollPaneVentana;
    private JComboBox comboBoxCarrera;
    private DefaultTableModel model;
    ServicioListaUsuario servicioListaUsuario = new ServicioListaUsuario();
    RegistroPatosVentana registroPatosVentana = new RegistroPatosVentana();
    ManejoArchivos manejoArchivos = new ManejoArchivos();



    //Cargar datos a combosxCarrera
    public void cargarDatosComboBoxCArrera(){
        for(RegistrarCarrera carrera : servicioListaUsuario.getlistCMapasCarrera()){
            comboBoxCarrera.addItem(carrera.getNombre());
        }

    }

    public void actualizarComboCarreras(){
        comboBoxCarrera.removeAllItems();
        for(RegistrarCarrera carrera : servicioListaUsuario.getlistCMapasCarrera()){
            comboBoxCarrera.addItem(carrera.getNombre());

        }

    }


    public void actualizarTabla(){


        model.setRowCount(0);

        //Cargar los datos:
        for(RegistroUsuario usuario: servicioListaUsuario.getListaUsuarios()){
            model.addRow(new Object[]{
                    usuario.getNombre(),
                    usuario.getEdad(),
                    usuario.getDocumento(),
                    usuario.getCategoria(),
                    usuario.getnPatos()
            });
        }


    }

    public Inicio() {

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] {"Nombre", "Edad", "Documento", "Categoria", "Pato"});
        tblRegistro.setModel(model);

        //Agregar la informacion




        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroPatosVentana registroPatosVentana = new RegistroPatosVentana();
                registroPatosVentana.mostrarVentana(() -> actualizarTabla());


            }
        });

        btnCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGestionarCarrera ventana = new VentanaGestionarCarrera();

                // La mostramos y le pasamos la instrucción de actualizar el combo
                ventana.MostrarVentana(() -> actualizarComboCarreras());


            }
        });
        btnEstadistica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaEstadistica ventanaEstadistica = new VentanaEstadistica();
                ventanaEstadistica.mostrarVentana();
            }
        });
        iniciarCarreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCarrera = (String) comboBoxCarrera.getSelectedItem();
                VentanaCarrera ventanaCarrera = new VentanaCarrera();
                ventanaCarrera.mostrarVentana();
                ventanaCarrera.nombreCarrera(nombreCarrera);
                ventanaCarrera.obtenerJugadores();

            }
        });

        
    }




    JPanel getMainPanel(){
        return mainPanel;
    }

    public void MostrarVentana(){
        JFrame frame = new JFrame("Ventana Inicio");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 600);
        frame.setVisible(true);
        manejoArchivos.cargarDatosCarreras();
        cargarDatosComboBoxCArrera();


    }




}

