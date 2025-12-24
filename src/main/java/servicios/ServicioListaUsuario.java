package servicios;

import dominio.RegistrarCarrera;
import dominio.RegistrarPato;
import dominio.RegistroUsuario;

import java.util.ArrayList;

public  class ServicioListaUsuario {
    static ArrayList<RegistroUsuario> listaUsuarios = new ArrayList<>();
    static ArrayList<RegistrarCarrera> listCMapasCarrera = new ArrayList<>();
    static ArrayList<RegistrarPato> listPatos = new ArrayList<>();

    public ArrayList<RegistrarPato> getListaPatos(){
        return listPatos;
    }
    ManejoArchivos manejoArchivos = new ManejoArchivos();

    public ArrayList<RegistroUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<RegistrarCarrera> getlistCMapasCarrera() {
        return listCMapasCarrera;
    }

    //MEtodo para validar la informacion.
    public boolean existeDocumento(String documento) {
        for (RegistroUsuario usuario : listaUsuarios) {
            if (usuario.getDocumento().equals(documento)) {
                return true;
            }
        }
        return false;
    }

    //Metodo para controla la validacion
    public boolean registrarUsuario(RegistroUsuario nuevo) {

        if (existeDocumento(nuevo.getDocumento())) {
            return false; // ya existe
        }

        agregarUsuario(nuevo);
        return true; // registro exitoso
    }

    //Va en el javapara argegar usuarios
    public void agregarUsuario(RegistroUsuario registroUsuario){
        listaUsuarios.add(registroUsuario);
        manejoArchivos.guardarInformacion(registroUsuario, "registroUsuarios.txt");
    }

}
