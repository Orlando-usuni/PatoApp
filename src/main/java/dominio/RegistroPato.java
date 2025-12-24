package dominio;

public class RegistroPato {
    private String Nombre;
    static int cantidadGanada = 0;

    public RegistroPato(String nombre, int contadorPartidas) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public static int getCantidadGanada() {
        return cantidadGanada;
    }

    public static void setCantidadGanada(int cantidadGanada) {
        RegistroPato.cantidadGanada = cantidadGanada;
    }

    public String sobreEscribirPato(){
        return this.getNombre() +","+ cantidadGanada;
    }
}



