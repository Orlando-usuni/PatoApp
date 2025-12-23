package dominio;

public class RegistroUsuario {
    private String nombre;
    private String edad;
    private String documento;
    private String categoria;
    private String nPatos;
    private int cantidadVecesGanadas=0;

    public RegistroUsuario(String nombre, String edad, String documento, String categoria, String nPatos) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.categoria = categoria;
        this.nPatos = nPatos;
    }

    public RegistroUsuario(String nombre, String edad, String documento, String categoria, String nPatos,int cantidadVecesGanadas) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.categoria = categoria;
        this.nPatos = nPatos;
        this.cantidadVecesGanadas = cantidadVecesGanadas;

    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getnPatos() {
        return nPatos;
    }

    public void setnPatos(String nPatos) {
        this.nPatos = nPatos;
    }

    @Override
    public String toString() {
        return "RegistroUsuario{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", documento='" + documento + '\'' +
                ", categoria='" + categoria + '\'' +
                ", nPatos='" + nPatos + '\'' +
                '}';
    }

    public String escribirRegistro(){
        return this.nombre + ","+ this.edad +"," + this.documento +"," + this.categoria +","+ this.nPatos;
    }
}
