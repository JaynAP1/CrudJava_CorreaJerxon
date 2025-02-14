package poo;

public class Conductor extends Garage {
    
    private int Edad;
    private String Apellido;
    
    public Conductor(int id, String nombre, int Edad, String Apellido){
    super();
    this.Edad = Edad;
    this.Apellido = Apellido;
    this.nombre = nombre;
    }

    public void dormir(){
        System.out.println("el conductor "+nombre+" esta durmiendo");
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    
    
}
