package dominio;

public class RegistrarCarrera {
    private String nombre;
    private String categoria;
    private String fecha;

    public RegistrarCarrera(String nombre, String categoria, String fecha) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String reescribirCarrera(){
        return this.nombre + "," + this.categoria + "," + this.fecha;
    }
}
