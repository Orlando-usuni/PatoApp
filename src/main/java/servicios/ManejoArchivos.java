package servicios;

import dominio.RegistrarCarrera;
import dominio.RegistroPato;
import dominio.RegistroUsuario;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;


public class ManejoArchivos {

    public void CrearDocumento(String nombre){
        File archivoUsuarios = new File(nombre);

        try {
            if (!archivoUsuarios.exists()) {
                archivoUsuarios.createNewFile();
                cargarDatos(nombre);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al crear el documento: " + e.getMessage());
        }
    }

    public void leerUsuariosDesdeTxt(String nombreArchivo) {

        ServicioListaUsuario servicio = new ServicioListaUsuario();

        if (!servicio.getListaUsuarios().isEmpty()) {
            return;
        }

        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length == 5) {
                    RegistroUsuario usuario = new RegistroUsuario(
                            datos[0], // nombre
                            datos[1], // edad
                            datos[2], // documento
                            datos[3], // categoria
                            datos[4]  // patos
                    );

                    servicio.getListaUsuarios().add(usuario);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al leer usuarios: " + e.getMessage());
        }
    }


    public void cargarDatos(String nombre){
        ServicioListaUsuario servicioListaUsuario = new ServicioListaUsuario();
        //Carga los datos a la memoria
        servicioListaUsuario.listaUsuarios.add(new RegistroUsuario("Anduin","11","1001110001","Niño","MiniMurloc"));
        servicioListaUsuario.listaUsuarios.add(new RegistroUsuario("Murky","10","1001110002","Niño","HechizoVeloz"));
        servicioListaUsuario.listaUsuarios.add(new RegistroUsuario("Magni","12","1001110003","Niño","ReyLich"));
        servicioListaUsuario.listaUsuarios.add(new RegistroUsuario("Jaina","19","1002220001","Joven","MiniMurloc"));
        servicioListaUsuario.listaUsuarios.add(new RegistroUsuario("Thrall","22","1002220002","Joven","HechizoVeloz"));
        servicioListaUsuario.listaUsuarios.add(new RegistroUsuario("Valeera","20","1002220003","Joven","ReyLich"));
        servicioListaUsuario.listaUsuarios.add(new RegistroUsuario("Arthas","35","1003330001","Adulto","MiniMurloc"));
        servicioListaUsuario.listaUsuarios.add(new RegistroUsuario("Illidan","38","1003330002","Adulto","HechizoVeloz"));
        servicioListaUsuario.listaUsuarios.add(new RegistroUsuario("Uther","45","1003330003","Adulto","ReyLich"));


        //carga los datos a el archivo X aqui
        File ArchivoUsuario = new File(nombre);
            try{
                PrintWriter salida = new PrintWriter(new FileWriter(ArchivoUsuario,false));
                for(RegistroUsuario usuario: servicioListaUsuario.listaUsuarios) {
                    salida.println(usuario.escribirRegistro());}
                salida.close();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al cargar los datos" + e.getMessage());}

    }

    public void guardarInformacion(RegistroUsuario nuevoUsuario, String nombre){
        File ArchivoUsuario = new File(nombre);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(ArchivoUsuario,true));
            salida.println(nuevoUsuario.escribirRegistro() + "");
            salida.close();
            JOptionPane.showMessageDialog(null, "Se guardo correctamente los datos");

        }catch(Exception e){
            System.out.println("No se pudo agregar el usuarioNuevo");
        }
    };

    //Guardar datos de las pistas en txt
    public void guardarPistasTxt (RegistrarCarrera carrera){
        //Referencia Archivo
        File archivoPistas = new File("pistas.txt");

        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivoPistas, archivoPistas.exists() ));
            salida.println(carrera.reescribirCarrera());
            salida.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el archivo de pistas");
        }

    }
    


    public void cargarDatosCarreras(){
        File archivo = new File("pistas.txt");
        ServicioListaUsuario.listCMapasCarrera.clear();

        try{
            //Abrimo el archivo
            BufferedReader entrada = new BufferedReader (new FileReader(archivo));
            var linea = entrada.readLine();
            while(linea != null){
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                String categoria = partes[1].trim();
                String fecha = partes[2].trim();
                ServicioListaUsuario.listCMapasCarrera.add(new RegistrarCarrera(nombre, categoria,fecha));
                linea = entrada.readLine();

            }
            entrada.close();
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar los datos" + e.getMessage());
        }
    }
}

