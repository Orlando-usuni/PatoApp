package dominio;
import presentacion.VentanaCarrera;

import javax.swing.*;
import java.util.Random;

import static java.lang.Math.random;

public class PatoHilo extends Thread{
    private JProgressBar barra;
    private String nombre;
    private VentanaCarrera ventana; // Referencia a la ventana

    //Constructor
    public PatoHilo(JProgressBar progressBar, String nombre, VentanaCarrera ventana){
        this.barra = progressBar;
        this.nombre = nombre;
        this.ventana = ventana;

    }


    public void run(){


        Random random = new Random();
        int progreso = 0;
        
        while(progreso < 100){
            progreso += random.nextInt(5)+1;
            if (progreso > 100) progreso = 100;

            //Actualizar barra
            barra.setValue(progreso);
            barra.setString(nombre + ": " + progreso + "%");

            try{
                // Pausa el hilo un momento para que la carrera sea visible
                Thread.sleep(random.nextInt(200)+50);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al cargar la barra" + e.getMessage());
                break;
            }
            }
        //Al terminar el bucle, llama al método de la ventana
        ventana.registrarGanador(this.nombre);
        }





}
