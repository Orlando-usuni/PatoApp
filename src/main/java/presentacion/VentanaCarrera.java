package presentacion;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import dominio.PatoHilo;
import dominio.RegistrarCarrera;
import dominio.RegistroUsuario;
import servicios.ServicioListaUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class VentanaCarrera {
    private JPanel mainPanel;
    private JProgressBar progressPato1;
    private JProgressBar progressPato2;
    private JProgressBar progressPato3;
    private JButton btnEmpezarCarrera;
    private JLabel JlabelNombreCarrera;
    private JLabel jLabelJugador1;
    private JLabel jLabelJugador2;
    private JLabel jLabeljugador3;
    private JLabel JLabelGandor;
    private JPanel JPanelMedallas;
    private JPanel JPanelPuestos;
    private JLabel JlabelGanadorv1;
    ServicioListaUsuario servicioListaUsuario = new ServicioListaUsuario();
    String nombreDeLaCarrera;
    String categoria;
    private ArrayList<RegistroUsuario> listaSeleccion;

    // 1. Variable para controlar si ya hay un ganador
    private String nombreGanador = null;

    // 2. Sincoroniza para registrar el gandador
    public synchronized void registrarGanador(String nombre) {
        if (this.nombreGanador == null) {
            this.nombreGanador = nombre;
            JlabelGanadorv1.setText( "Ganador: "+nombreGanador);
            JPanelMedallas.setVisible(true);

        }
    }

    public VentanaCarrera() {
        btnEmpezarCarrera.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {


                nombreGanador = null;
                progressPato1.setValue(0);
                progressPato2.setValue(0);
                progressPato3.setValue(0);

                PatoHilo primerPato = new PatoHilo(progressPato1, "MiniMurloc", VentanaCarrera.this);
                PatoHilo segundoPato = new PatoHilo(progressPato2, "HechizoVeloz",  VentanaCarrera.this);
                PatoHilo tercerPato = new PatoHilo(progressPato3, "ReyLich",  VentanaCarrera.this);

                primerPato.start();
                segundoPato.start();
                tercerPato.start();


            }
        });
    }

    public void obtenerJugadores(){
        Random random = new Random();
        for(RegistrarCarrera carrera : servicioListaUsuario.getlistCMapasCarrera()){
            if(nombreDeLaCarrera.equals(carrera.getNombre())){
                categoria = carrera.getCategoria();
                break;
            }
        }
        String[] nombres = new String[3];
        int min = 0;
        int intentos = 0;
        this.listaSeleccion = servicioListaUsuario.getListaUsuarios();


        while(intentos < 3){
            int max = listaSeleccion.size()-1;
            int numeroAleatorio = random.nextInt(max - min + 1) + min;
            String nombreCategoria = listaSeleccion.get(numeroAleatorio).getCategoria();


            if(categoria.equals(nombreCategoria)){
                nombres[intentos] = servicioListaUsuario.getListaUsuarios().get(numeroAleatorio).getNombre();
                servicioListaUsuario.getListaUsuarios().remove(numeroAleatorio);
                intentos++;
            }
        }
        listaSeleccion = servicioListaUsuario.getListaUsuarios();

        jLabelJugador1.setText(nombres[0]);
        jLabelJugador2.setText(nombres[1]);
        jLabeljugador3.setText(nombres[2]);


    }

    public void nombreCarrera(String nombre){
        JlabelNombreCarrera.setText(nombre);
        nombreDeLaCarrera = nombre;


    }


    JPanel getMainPanel(){
        return mainPanel;
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
    }


}

