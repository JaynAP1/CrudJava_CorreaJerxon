import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {

        ArrayList<Matricula> PersonasMatriculadas = new ArrayList<>();
        ArrayList<Docente> DocentesMatriculadas = new ArrayList<>();
        ArrayList<Estudiantes> EstudiantesMatriculadas = new ArrayList<>();
        ArrayList<Expulsados> ExpulsadosMatriculadas = new ArrayList<>();

        boolean ciclo = true;

        while(ciclo){

            String Seleccion = JOptionPane.showInputDialog("""
                                         ===============================================
                                         1).Coordinacion
                                         2).Estudiante.
                                         3).Trainer.
                                         4).Salir.
                                         ===============================================
                                         """);
            switch(Seleccion){
                case "1" -> {
                    boolean ciclo2 = true;
                    while(ciclo2){

                        int Contrasena = Integer.parseInt(JOptionPane.showInputDialog("""
                                         ===============================================
                                         Escribe la contraseña del coordinador para continuar.
                                         ===============================================
                                         """));
                        System.out.println(Contrasena);

                        if (Contrasena == 12345){
                            boolean ciclo3 = true;
                            while (ciclo3){
                                int SeleccionCordinacion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                      ===============================================
                                                      1).Inscribir personas.
                                                      2).Inscribir docentes.
                                                      3).Ver Campers/Trainers/Inscritos.
                                                      4).Ingresar notas.
                                                      5).Destinar Trainers.
                                                      6).Expulsar camper.
                                                      7).Salir.
                                                      ===============================================
                                                    """));

                                switch(SeleccionCordinacion){
                                    case 1 -> {
                                        String Identificacion = JOptionPane.showInputDialog(null, "Ingrese la id de la persona que desea matricular");
                                        if (Identificacion.equals("1")){
                                            JOptionPane.showMessageDialog(null, "Persona Matriculada");
                                        }else{
                                            String Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo de la persona.");
                                            String Telefono = JOptionPane.showInputDialog(null, "Ingrese el telefono de la persona.");

                                            Matricula PersonaMatricula= new Matricula(Identificacion, Nombre,Telefono, 0);

                                            PersonasMatriculadas.add(PersonaMatricula);

                                            JOptionPane.showMessageDialog(null, "Persona matriculada con exito");
                                            System.out.println(PersonaMatricula);
                                        }
                                    }
                                    case 2 -> {
                                        String idNew = JOptionPane.showInputDialog(null, "Ingrese la id del docente que desea matricular");
                                        if (idNew.equals("1")){
                                            JOptionPane.showMessageDialog(null, "Docente Matriculada");
                                        }else{
                                            String Nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo de la persona.");
                                            String Telefono = JOptionPane.showInputDialog(null, "Ingrese el telefono de la persona.");

                                            Docente DocenteMatricula= new Docente(idNew, Nombre,Telefono, "No definida");

                                            DocentesMatriculadas.add(DocenteMatricula);

                                            JOptionPane.showMessageDialog(null, "Persona matriculada con exito");
                                        }
                                    }
                                    case 3 -> {
                                        boolean ciclo4 = true;
                                        while (ciclo4){
                                            int SeleccionCordinacion1 = Integer.parseInt(JOptionPane.showInputDialog("""
                                                      ===============================================
                                                      1).Ver inscritos.
                                                      2).Ver camper.
                                                      3).Ver docente.
                                                      4).Expulsados.
                                                      5).Salir.
                                                      ===============================================
                                                    """));

                                            switch(SeleccionCordinacion1){
                                                case 1 -> {
                                                    if (PersonasMatriculadas.isEmpty()){
                                                        JOptionPane.showMessageDialog(null, "No hay personas matriculadas");
                                                    }else {
                                                        String VerMatriculas = "";
                                                        for (int i = 0; i < PersonasMatriculadas.size(); i++) {
                                                            VerMatriculas += "========================================" +
                                                                    "\nNumero: " + (i + 1) +
                                                                    "\nIdentificacion: " + PersonasMatriculadas.get(i).id +
                                                                    "\nNombre: " + PersonasMatriculadas.get(i).Nombre +
                                                                    "\nTelefono: " + PersonasMatriculadas.get(i).Telefono +
                                                                    "\nNota: " + PersonasMatriculadas.get(i).Nota +
                                                                    "\n========================================";
                                                        }
                                                        JOptionPane.showMessageDialog(null, VerMatriculas);
                                                    }
                                                }
                                                case 2 ->{
                                                    if (EstudiantesMatriculadas.isEmpty()){
                                                        JOptionPane.showMessageDialog(null, "No hay estudiantes");
                                                    }else {
                                                        String VerEstudiantes = "";
                                                        for (int i = 0; i < EstudiantesMatriculadas.size(); i++) {
                                                            VerEstudiantes += "========================================" +
                                                                    "\nNumero: " + (i + 1) +
                                                                    "\nIdentificacion: " + EstudiantesMatriculadas.get(i).id +
                                                                    "\nNombre: " + EstudiantesMatriculadas.get(i).nombre +
                                                                    "\nTelefono: " + EstudiantesMatriculadas.get(i).telefono +
                                                                    "\nNota: "+ EstudiantesMatriculadas.get(i).nota +
                                                                    "\nRuta: " + EstudiantesMatriculadas.get(i).ruta +
                                                                    "\n========================================";
                                                        }
                                                        JOptionPane.showMessageDialog(null, VerEstudiantes);
                                                    }
                                                }
                                                case 3 ->{
                                                    if (DocentesMatriculadas.isEmpty()){
                                                        JOptionPane.showMessageDialog(null, "No hay docentes");
                                                    }else {
                                                        String VerDocentes = "";
                                                        for (int i = 0; i < DocentesMatriculadas.size(); i++) {
                                                            VerDocentes += "========================================" +
                                                                    "\nNumero: " + (i + 1) +
                                                                    "\nIdentificacion: " + DocentesMatriculadas.get(i).id +
                                                                    "\nNombre: " + DocentesMatriculadas.get(i).nombre +
                                                                    "\nTelefono: " + DocentesMatriculadas.get(i).telefono +
                                                                    "\nRuta: " + DocentesMatriculadas.get(i).ruta +
                                                                    "\n========================================";
                                                        }
                                                        JOptionPane.showMessageDialog(null, VerDocentes);
                                                    }
                                                }
                                                case 4 ->{
                                                    if (ExpulsadosMatriculadas.isEmpty()){
                                                        JOptionPane.showMessageDialog(null, "No hay docentes");
                                                    }else {
                                                        String VerExpulsados = "";
                                                        for (int i = 0; i < ExpulsadosMatriculadas.size(); i++) {
                                                            VerExpulsados += "========================================" +
                                                                    "\nNumero: " + (i + 1) +
                                                                    "\nIdentificacion: " + ExpulsadosMatriculadas.get(i).id +
                                                                    "\nNombre: " + ExpulsadosMatriculadas.get(i).nombre +
                                                                    "\nRazon: " + ExpulsadosMatriculadas.get(i).Razon +
                                                                    "\n========================================";
                                                        }
                                                        JOptionPane.showMessageDialog(null, VerExpulsados);
                                                    }
                                                }
                                                case 5 ->{
                                                    ciclo4 = false;
                                                }
                                            }

                                        }

                                    }
                                    case 4 -> {
                                        boolean ciclo5 = true;
                                        while (ciclo5){
                                            int SeleccionCordinacion2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                                      ===============================================
                                                      1).Agregar nota de examen inicial.
                                                      2).Agregar nota de filtro.
                                                      3).Salir
                                                      ===============================================
                                                    """));
                                            switch(SeleccionCordinacion2){
                                                case 1 ->{
                                                    if (PersonasMatriculadas.isEmpty()){
                                                        JOptionPane.showMessageDialog(null, "No hay personas matriculadas");
                                                    }else {
                                                        String VerMatriculas = "";
                                                        for (int i = 0; i < PersonasMatriculadas.size(); i++) {
                                                            VerMatriculas += "========================================" +
                                                                    "\nNumero: " + (i + 1) +
                                                                    "\nIdentificacion: " + PersonasMatriculadas.get(i).id +
                                                                    "\nNombre: " + PersonasMatriculadas.get(i).Nombre +
                                                                    "\nTelefono: " + PersonasMatriculadas.get(i).Telefono +
                                                                    "\nNota: " + PersonasMatriculadas.get(i).Nota +
                                                                    "\n========================================";
                                                        }
                                                        int SeleccionarMatriculado = Integer.parseInt(JOptionPane.showInputDialog(null,"Elija al matriculado que desea cambiarle la nota\n" + VerMatriculas));

                                                        int NewNota = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva nota"));

                                                        String idAct = PersonasMatriculadas.get(SeleccionarMatriculado-1).id;
                                                        String NombreAct = PersonasMatriculadas.get(SeleccionarMatriculado-1).Nombre;
                                                        String TelefonoAct = PersonasMatriculadas.get(SeleccionarMatriculado-1).Telefono;

                                                        PersonasMatriculadas.remove(SeleccionarMatriculado-1);

                                                        if (NewNota >= 60){
                                                            String Ruta = JOptionPane.showInputDialog(null, "Ingrese la ruta del estudiante ya que aprobo.\nNode\nJava\nNetCore");
                                                            Estudiantes EstudianteNew = new Estudiantes(idAct, NombreAct, TelefonoAct, 0, Ruta);
                                                            EstudiantesMatriculadas.add(EstudianteNew);
                                                        }else {
                                                            Matricula MatriculaAct = new Matricula(idAct, NombreAct, TelefonoAct, NewNota);
                                                            PersonasMatriculadas.add(MatriculaAct);
                                                        }
                                                    }
                                                }
                                                case 2 ->{
                                                    if (EstudiantesMatriculadas.isEmpty()){
                                                        JOptionPane.showMessageDialog(null, "No hay estudiantes");
                                                    }else {
                                                        String VerEstudiante = "";
                                                        for (int i = 0; i < EstudiantesMatriculadas.size(); i++) {
                                                            VerEstudiante += "========================================" +
                                                                    "\nNumero: " + (i + 1) +
                                                                    "\nIdentificacion: " + EstudiantesMatriculadas.get(i).id +
                                                                    "\nNombre: " + EstudiantesMatriculadas.get(i).nombre +
                                                                    "\nTelefono: " + EstudiantesMatriculadas.get(i).telefono +
                                                                    "\nRuta:" + EstudiantesMatriculadas.get(i).ruta +
                                                                    "\nNota: " + EstudiantesMatriculadas.get(i).nota +
                                                                    "\n========================================";
                                                        }
                                                        int SeleccionarEstudiante = Integer.parseInt(JOptionPane.showInputDialog(null, "Elija al estudiante al que desea agregarle la nota\n" + VerEstudiante));

                                                        int NewNota = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva nota"));

                                                        String idAct = EstudiantesMatriculadas.get(SeleccionarEstudiante - 1).id;
                                                        String NombreAct = EstudiantesMatriculadas.get(SeleccionarEstudiante - 1).nombre;
                                                        String TelefonoAct = EstudiantesMatriculadas.get(SeleccionarEstudiante - 1).telefono;
                                                        String RutaAct = EstudiantesMatriculadas.get(SeleccionarEstudiante - 1).ruta;

                                                        EstudiantesMatriculadas.remove(SeleccionarEstudiante - 1);

                                                        Estudiantes EstudianteAct = new Estudiantes(idAct, NombreAct, TelefonoAct, NewNota , RutaAct);
                                                    }
                                                }
                                                case  3->{
                                                    ciclo5 = false;
                                                }
                                            }
                                        }
                                    }
                                    case 5 -> {
                                        if (DocentesMatriculadas.isEmpty()){
                                            JOptionPane.showMessageDialog(null, "No hay docentes");
                                        }else {
                                            String VerDocentes = "";
                                            for (int i = 0; i < DocentesMatriculadas.size(); i++) {
                                                VerDocentes += "========================================" +
                                                        "\nNumero: " + (i + 1) +
                                                        "\nIdentificacion: " + DocentesMatriculadas.get(i).id +
                                                        "\nNombre: " + DocentesMatriculadas.get(i).nombre +
                                                        "\nTelefono: " + DocentesMatriculadas.get(i).telefono +
                                                        "\nRuta: " + DocentesMatriculadas.get(i).ruta +
                                                        "\n========================================";
                                            }
                                            int SeleccionDocente = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione al docente al que quiere establecer la ruta\n" + VerDocentes));

                                            String RutaDocente = JOptionPane.showInputDialog(null, "Escriba la ruta destinada \nNode\nJava\nNetCore");

                                            String NombreAct = DocentesMatriculadas.get(SeleccionDocente - 1).nombre;
                                            String IdAct = DocentesMatriculadas.get(SeleccionDocente - 1).id;
                                            String NumeroAct = DocentesMatriculadas.get(SeleccionDocente - 1).telefono;

                                            DocentesMatriculadas.remove(SeleccionDocente - 1);

                                            Docente DocenteAct = new Docente(IdAct, NombreAct, NumeroAct, RutaDocente);

                                            DocentesMatriculadas.add(DocenteAct);

                                            JOptionPane.showMessageDialog(null, "Ruta establecida con exito");

                                        }
                                    }
                                    case 6 -> {
                                        if (EstudiantesMatriculadas.isEmpty()){
                                            JOptionPane.showMessageDialog(null, "No hay estudiantes");
                                        }else {
                                            String VerEstudiante = "";
                                            for (int i = 0; i < EstudiantesMatriculadas.size(); i++) {
                                                VerEstudiante += "========================================" +
                                                        "\nNumero: " + (i + 1) +
                                                        "\nIdentificacion: " + EstudiantesMatriculadas.get(i).id +
                                                        "\nNombre: " + EstudiantesMatriculadas.get(i).nombre +
                                                        "\nTelefono: " + EstudiantesMatriculadas.get(i).telefono +
                                                        "\nRuta:" + EstudiantesMatriculadas.get(i).ruta +
                                                        "\nNota: " + EstudiantesMatriculadas.get(i).nota +
                                                        "\n========================================";
                                            }
                                            int SeleccionarEstudiante = Integer.parseInt(JOptionPane.showInputDialog(null, "Elija al estudiante que se expulsara\n" + VerEstudiante));

                                            String Razon = JOptionPane.showInputDialog(null, "Ingrese la razon de la expulsion");

                                            String idAct = EstudiantesMatriculadas.get(SeleccionarEstudiante - 1).id;
                                            String NombreAct = EstudiantesMatriculadas.get(SeleccionarEstudiante - 1).nombre;

                                            EstudiantesMatriculadas.remove(SeleccionarEstudiante - 1);

                                            Expulsados EstudianteExpulsado = new Expulsados(idAct, NombreAct, Razon);

                                            ExpulsadosMatriculadas.add(EstudianteExpulsado);
                                            JOptionPane.showMessageDialog(null,"Estudiante expulsado con exito");
                                        }
                                    }
                                    case 7 -> {
                                        ciclo2 = false;
                                        ciclo3 = false;
                                    }

                                    default -> {
                                        JOptionPane.showOptionDialog(
                                                null,
                                                "Seleccione una opcion correcta",
                                                "Selector de opciones",
                                                JOptionPane.OK_CANCEL_OPTION,
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                new Object[] { "Aceptar"},
                                                null);
                                    }
                                }
                            }

                        }else{
                            int ErrorC = JOptionPane.showConfirmDialog(null, "Contraseña incorrecta.\n ¿Deseas volver a intentarlo?");

                            System.out.println(ErrorC);

                            if (ErrorC == 1){
                                break;
                            }

                        }
                    }

                }
                case "2" ->{
                    String VerEstudiante = JOptionPane.showInputDialog(null, "Escribe su identificacion para ingresar");

                    boolean encontrado = false;

                    for (int i = 0; i < EstudiantesMatriculadas.size(); i++) {
                        if (EstudiantesMatriculadas.get(i).id.equals(VerEstudiante)) {
                            JOptionPane.showMessageDialog(null,
                                    "========================================" +
                                            "\nNumero: " + (i + 1) +
                                            "\nIdentificacion: " + EstudiantesMatriculadas.get(i).id +
                                            "\nNombre: " + EstudiantesMatriculadas.get(i).nombre +
                                            "\nTelefono: " + EstudiantesMatriculadas.get(i).telefono +
                                            "\nNota: "+ EstudiantesMatriculadas.get(i).nota +
                                            "\nRuta: " + EstudiantesMatriculadas.get(i).ruta +
                                            "\n========================================");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "El estudiante no existe");
                    }
                }
                case "3" ->{
                    String VerDocente = JOptionPane.showInputDialog(null, "Escribe su identifacion para ingresar");

                    boolean encontrado = false;

                    for (int i = 0; i < EstudiantesMatriculadas.size(); i++) {
                        if (EstudiantesMatriculadas.get(i).id.equals(VerDocente)) {
                            JOptionPane.showMessageDialog(null,
                                    "========================================" +
                                            "\nNumero: " + (i + 1) +
                                            "\nIdentificacion: " + EstudiantesMatriculadas.get(i).id +
                                            "\nNombre: " + EstudiantesMatriculadas.get(i).nombre +
                                            "\nTelefono: " + EstudiantesMatriculadas.get(i).telefono +
                                            "\nNota: "+ EstudiantesMatriculadas.get(i).nota +
                                            "\nRuta: " + EstudiantesMatriculadas.get(i).ruta +
                                            "\n========================================");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "El docente no existe");
                    }

                }
                case "4" ->{
                    ciclo = false;
                }

            }
        }
    }
}
