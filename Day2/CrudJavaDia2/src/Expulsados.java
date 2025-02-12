public class Expulsados {
    String id;
    String nombre;
    String Razon;

    public Expulsados(String id, String nombre, String Razon) {
        this.id = id;
        this.nombre = nombre;
        this.Razon = Razon;
    }

    @Override
    public String toString() {
        return "Expulsados{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", Razon='" + Razon + '\'' +
                '}';
    }
}
