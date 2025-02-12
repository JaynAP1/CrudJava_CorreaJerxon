public class Docente {
    String id;
    String nombre;
    String telefono;
    String ruta;

    public Docente(String id, String nombre, String telefono, String ruta) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.ruta = ruta;
    }
    @Override
    public String toString() {
        return "Docente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ruta='" + ruta + '\'' +
                '}';
    }
}
