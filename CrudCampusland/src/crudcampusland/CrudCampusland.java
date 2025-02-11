package crudcampusland;

import java.util.Scanner;
import javax.swing.JOptionPane;


public class CrudCampusland {

    public static void main(String[] args) {
        
         Boolean ciclo = true;
         
         while(ciclo){
         
             String Seleccion = JOptionPane.showInputDialog("""
                                         ===============================================
                                         1).Coordinacion
                                         2).Estudiante.
                                         3).Trainer.
                                         4).Aprobacion.
                                         ===============================================
                                         """);
             switch(Seleccion){
                 case "1" -> {
                     JOptionPane.showConfirmDialog(null, "hola");
                     break;
                             
                 }
                     
             }
         
         }
        
        
        
    }
    
}
