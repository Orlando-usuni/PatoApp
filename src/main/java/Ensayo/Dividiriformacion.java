package Ensayo;

public class Dividiriformacion {


    public static void main(String[] args) {
        String mensaje = "Orlando, Apellido, 1006465213";
        String[] partes = mensaje.split(",");

        String nombre = partes[0].trim();
        String apellido = partes[0].trim();
        String cc = partes[0].trim();

        System.out.println(partes[0]);
    }
}
