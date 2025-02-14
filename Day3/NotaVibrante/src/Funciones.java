import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Funciones {



    public static void Login (Connection conn) throws SQLException {
        String Usuario = JOptionPane.showInputDialog(null, "Ingrese su usuario");
        String Contrasena = JOptionPane.showInputDialog(null, "Ingrese su contraseña");

        String sql = "select id, nombre, apellido, correo, telefono from cliente where id = ? and correo = ?";

        try(PreparedStatement Search = conn.prepareStatement(sql)) {
            Search.setString(1, Usuario);
            Search.setString(2, Contrasena);
            ResultSet User = Search.executeQuery();

            if (User.next()) {
                JOptionPane.showMessageDialog(null, "Usuario Ingresado Correctamente");
                MenuUsuario(conn,Usuario);
            }
            else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }

        }
    }
    public static boolean Registrar (Connection conn) throws SQLException {
        JOptionPane.showMessageDialog(null, "Empezaras el sistema de registros");

        try{
            int Identificacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su identificacion"));
            String Nombre = JOptionPane.showInputDialog(null,"Ingrese su nombre");
            String Apellido = JOptionPane.showInputDialog(null,"Ingrese su apellido");
            String Correo = JOptionPane.showInputDialog(null,"Ingrese su correo");
            String Telefono = JOptionPane.showInputDialog(null,"Ingrese su telefono");

            String sql = "insert into Cliente (id, nombre, apellido, correo, telefono) values (?,?,?,?,?)";

            try(PreparedStatement Search = conn.prepareStatement(sql)) {
                Search.setInt(1, Identificacion);
                Search.setString(2, Nombre);
                Search.setString(3, Apellido);
                Search.setString(4, Correo);
                Search.setString(5, Telefono);

                int Registro = Search.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Agregado Correctamente");

                return Registro > 0;
            }

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al ingresar el usuario");
        }

        return false;
    }

    public  static void MenuPrincipal(Connection conn) throws SQLException {
        boolean Ciclo1 = true;

        while (Ciclo1) {
            String seleccion = JOptionPane.showInputDialog(null, """
                        ===================================
                        1.Iniciar sesion.
                        2.Registrarse.
                        3.Salir
                        ===================================
                        """);
            switch (seleccion) {
                case "1" ->{
                    Login(conn);
                }
                case "2" ->{
                    Registrar(conn);
                }
                case "3" ->{
                    JOptionPane.showMessageDialog(null,"Saliendo");
                    Ciclo1 = false;
                }
                default->{
                    JOptionPane.showMessageDialog(null, "El numero no existe");
                }
            }
        }
    }
    public static void VerConciertos(Connection conn) throws SQLException {
        String Sql = "select nombre, artista, fecha, lugar, preciobase from concierto";
        try(PreparedStatement Search = conn.prepareStatement(Sql)) {
            ResultSet Conciertos = Search.executeQuery();
            String AllConciertos = "";
            int i = 0;
            while (Conciertos.next()) {
                i = i + 1;

                String Nombre = Conciertos.getString("nombre");
                String Artista = Conciertos.getString("artista");
                String Fecha = Conciertos.getString("fecha");
                String Lugar = Conciertos.getString("lugar");

                AllConciertos += "==================================\nNombre: "+Nombre+"\nArtista: "+Artista+"\nFecha: "+Fecha+"\nLugar: "+Lugar+"\n";
            }
            JTextArea textArea = new JTextArea(AllConciertos);
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
            JOptionPane.showMessageDialog(null, scrollPane, "Conciertos",
                    JOptionPane.DEFAULT_OPTION);
        }
    }
    public static boolean ComprarTicket(Connection conn, String Usuario) throws SQLException {
        String SeleccionConcierto = "";
        String SeleccionZona = "";
        int Preciobase = 0;

        String SqlC = "select id, nombre, artista, fecha, lugar, preciobase from concierto";
        try (PreparedStatement Search = conn.prepareStatement(SqlC)) {
            ResultSet Conciertos = Search.executeQuery();
            String AllConciertos = "";

            while (Conciertos.next()) {
                
                int id = Conciertos.getInt("id");
                String Nombre = Conciertos.getString("nombre");
                String Artista = Conciertos.getString("artista");
                String Fecha = Conciertos.getString("fecha");
                String Lugar = Conciertos.getString("lugar");
                Preciobase = Conciertos.getInt("preciobase");

                AllConciertos += "==================================\nid: "+ id +"\nNombre: " + Nombre + "\nArtista: " + Artista + "\nFecha: " + Fecha + "\nLugar: " + Lugar + "\nPrecio Base: "+Preciobase+"\n";
            }
            JTextArea textArea = new JTextArea(AllConciertos);
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            SeleccionConcierto = JOptionPane.showInputDialog(null, scrollPane, "Conciertos",
                    JOptionPane.DEFAULT_OPTION);
        }

        String SqlL = "select concierto.nombre, nombrezona, capacidad from zona inner join concierto on zona.id_concierto = concierto.id where id_concierto = ?";

        int CapacidadZona = 0;
        try(PreparedStatement Search = conn.prepareStatement(SqlL)) {
            Search.setString(1, SeleccionConcierto);

            ResultSet Zonas = Search.executeQuery();
            String AllZonas = "";
            int i = 0;

            while(Zonas.next()) {
                i = i + 1;
                String NombreZona = Zonas.getString("nombrezona");
                CapacidadZona = Zonas.getInt("capacidad");
                String nombre = Zonas.getString("concierto.nombre");

                AllZonas += "==================================\nNumero: "+i+"\nNombreConcierto: " + nombre + "\nCapacidad: " + CapacidadZona + "\nLugar: " + NombreZona + "\n";
            }
            SeleccionZona = JOptionPane.showInputDialog(null,"Selecciona Zona\n" + AllZonas);
        }
        int CantidadEscogida = 0;
        boolean ciclo1 = true;
        while (ciclo1){
            CantidadEscogida = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantos puestos desea."));
            if (CapacidadZona < CantidadEscogida){
                JOptionPane.showMessageDialog(null,"La cantidad que deseas comprar no esta disponible");
            }
            else {
                ciclo1 = false;
            }
        }
        int Cantidad = 0;
        String Zona = "";

        String SqllA = "select concierto.nombre, nombrezona, capacidad from zona inner join concierto on zona.id_concierto = concierto.id where id_concierto = ? and id_seleccion = ?";
        try(PreparedStatement Search = conn.prepareStatement(SqllA)) {
            Search.setString(1, SeleccionConcierto);
            Search.setString(2, SeleccionZona);

            ResultSet CantidadD = Search.executeQuery();

            while (CantidadD.next()){
                Cantidad = CantidadD.getInt("capacidad");
                Zona = CantidadD.getString("nombrezona");
            }
        }

        String SqllE = "update Zona set capacidad = ? where id_seleccion = ? and id_concierto = ?";
        try(PreparedStatement Search = conn.prepareStatement(SqllE)) {
            Search.setInt(1, (Cantidad - CantidadEscogida));
            Search.setInt(2, Integer.parseInt(SeleccionZona));
            Search.setString(3, SeleccionConcierto);

            int PrecioTotal = CantidadEscogida * Preciobase;

            int Registro = Search.executeUpdate();

            SaveTickets(conn,Usuario,SeleccionConcierto,Zona,PrecioTotal,CantidadEscogida);
            return Registro > 0;
        }
    }

    public static boolean SaveTickets(Connection conn, String Usuario, String Concierto, String Zona, int precioBase,int cantidad) throws SQLException {

        LocalDateTime CurrentTime = LocalDateTime.now();

        String SqllT = "insert into Ticket ( id_cliente, id_concierto, zona, precioFinal, fechaCompra, cantidad) values (?,?,?,?,?,?)";
        try(PreparedStatement Search = conn.prepareStatement(SqllT)) {
            Search.setInt(1, Integer.parseInt(Usuario));
            Search.setInt(2, Integer.parseInt(Concierto));
            Search.setString(3, Zona);
            Search.setInt(4, precioBase);
            Search.setString(5, String.valueOf(CurrentTime));
            Search.setInt(6, cantidad);
            int AddTicket = Search.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tickets comprados con exito, su total fueron: "+ precioBase);

            return AddTicket > 0;
        }
    }

    public static void VerTickets(Connection conn, String Usuario) throws SQLException{
        String SqlTV = "Select concierto.nombre, zona, precioFinal, fechaCompra, cantidad from ticket inner join concierto on ticket.id_concierto = concierto.id where id_cliente = ?";
        try(PreparedStatement Search = conn.prepareStatement(SqlTV)){
            Search.setInt(1, Integer.parseInt(Usuario));

            ResultSet VerT = Search.executeQuery();

            String AllTickets = "";
            while (VerT.next()){
                String NombreConcierto = VerT.getString("nombre");
                String NombreZona = VerT.getString("zona");
                String PrecioFinal = VerT.getString("precioFinal");
                String fechaCompra = VerT.getString("fechaCompra");
                int Cantidad = VerT.getInt("cantidad");

                AllTickets += "===================================\nConcierto: "+ NombreConcierto+ "\nZona: "+NombreZona+"\nTotal: "+PrecioFinal+"\nFecha de compra: "+fechaCompra+"\nCantidad: "+Cantidad+"\n";
            }
            JTextArea textArea = new JTextArea(AllTickets);
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            JOptionPane.showMessageDialog(null, scrollPane, "Tickets",
                    JOptionPane.DEFAULT_OPTION);
        }
    }
    public static boolean CancelarTickets(Connection conn, String Usuario) throws SQLException{
        String SqlTV = "Select ticket.id, concierto.nombre, zona, precioFinal, fechaCompra from ticket inner join concierto on ticket.id_concierto = concierto.id where id_cliente = ?";

        String SeleccionEliminar = "";

        try(PreparedStatement Search = conn.prepareStatement(SqlTV)){
            Search.setInt(1, Integer.parseInt(Usuario));

            ResultSet VerT = Search.executeQuery();

            String AllTickets = "";
            while (VerT.next()){
                String id = VerT.getString("ticket.id");
                String NombreConcierto = VerT.getString("nombre");
                String NombreZona = VerT.getString("zona");
                String PrecioFinal = VerT.getString("precioFinal");
                String fechaCompra = VerT.getString("fechaCompra");

                AllTickets += "===================================\nid: "+ id +"\nConcierto: "+ NombreConcierto+ "\nZona: "+NombreZona+"\nTotal: "+PrecioFinal+"\nFecha de compra: "+fechaCompra+"\n";
            }
            JTextArea textArea = new JTextArea(AllTickets);
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            SeleccionEliminar = JOptionPane.showInputDialog(null, scrollPane, "Tickets",
                    JOptionPane.DEFAULT_OPTION);
        }
        String SqlE = "delete from ticket where id_cliente = ? and id = ?";
        try(PreparedStatement Search = conn.prepareStatement(SqlE)){
            Search.setInt(1, Integer.parseInt(Usuario));
            Search.setInt(2, Integer.parseInt(SeleccionEliminar));

            int DeleteTicket = Search.executeUpdate();
            return DeleteTicket > 0;
        }
    }

    public static void MenuUsuario(Connection conn, String Usuario) throws SQLException {
        boolean Menu = true;
        while (Menu){
            String MenuUser = JOptionPane.showInputDialog(null, """
                ===================================
                1.Ver conciertos disponibles.
                2.Comprar ticket.
                3.Ver mis tickets.
                4.Cancelar tickets.
                5.Salir
                ===================================
                """);

            switch (MenuUser) {
                case "1" ->{
                    VerConciertos(conn);
                }
                case "2" ->{
                    ComprarTicket(conn, Usuario);
                }
                case "3" ->{
                    VerTickets(conn,Usuario);
                }
                case "4" ->{
                    CancelarTickets(conn,Usuario);
                }
                case "5" ->{
                    Menu = false;
                }
                default->{
                    JOptionPane.showMessageDialog(null, "El numero no existe");
                }
            }
        }
    }

}
