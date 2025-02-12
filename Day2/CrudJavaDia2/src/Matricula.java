public class Matricula {
    String id;
    String Nombre;
    String Telefono;
    int Nota;

    public Matricula(String id, String Nombre, String Telefono, int Nota) {
        this.id = id;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Nota = Nota;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id='" + id + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Nota=" + Nota +
                '}';
    }
}
