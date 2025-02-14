package poo;

public class Vehiculo extends Garage{

    private String modelo;
    private int velocidad;
    
    public Vehiculo(int id, String modelo, int velocidad){
        super();
        this.velocidad = velocidad;
        this.modelo = modelo;
    }
    
    public void Correr(){
        System.out.println("El vehiculo esta corriendo a una velocidad de: "+ velocidad + "km/h");
    }
    
}
