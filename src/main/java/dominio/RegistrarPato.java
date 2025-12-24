package dominio;

public class RegistrarPato {
    private String nombre;
    private int contadorGanancia;


    public RegistrarPato(String nombre) {
        this.nombre = nombre;
        this.contadorGanancia = 0;
    }

    public void llevarGanancia(){
        this.contadorGanancia ++;
    }

    public int getContadorGanancia(){
        return contadorGanancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContadorGanancia(int contadorGanancia) {
        this.contadorGanancia = contadorGanancia;
    }
}
