public class Estudiantes {
    String id;
    String nombre;
    String telefono;
    int nota;
    String ruta;

    public Estudiantes(String id, String nombre, String telefono, int nota, String ruta) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nota = nota;
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Estudiantes{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", Nota=" + nota +
                ", ruta='" + ruta + '\'' +
                '}';
    }
}
