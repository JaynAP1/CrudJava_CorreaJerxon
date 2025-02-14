import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();

        try (Connection conn = conexion.conectarMySQL()) {
            if (conn != null) {
                Funciones.MenuPrincipal(conn);

            } else {
                System.out.println("No conexion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
