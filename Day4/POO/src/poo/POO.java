package poo;

public class POO {

    public static void main(String[] args) {
               
        Vehiculo Carro1 = new Vehiculo(1,"Hilux", 100);
        Conductor Persona1 = new Conductor(1, "Jair",21,"Correa");
        
        Carro1.revisiones();
        
        Carro1.Correr();
        
        Persona1.dormir();
        
        System.out.println(Persona1.getEdad());
    }
    
}
