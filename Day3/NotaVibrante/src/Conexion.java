import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {

    public String driver = "com.mysql.cj.jdbc.Driver";
    public String database = "notasvibrantes";
    public String hostname = "localhost";
    public String port = "3306";
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    public String username = "root";
    public String password = "campus2023";

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


}