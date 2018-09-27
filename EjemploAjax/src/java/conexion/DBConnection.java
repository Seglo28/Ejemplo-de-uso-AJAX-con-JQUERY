
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
 
    
    static String db = "evaluacion";
    static String login = "root";
    static String password = "root";
    static String url = "jdbc:mysql://localhost/" + db;
    Connection conn=null;

    
    public DBConnection()throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
             if(conn!=null){
                 System.out.println("Correcto"+db);
             }
        } catch (Exception e) {
            System.out.println("error"+ e.getMessage());
        }
}
    public Connection getConeccion(){
        return conn;
    }
    public void desconectar(){
        try {
            if(conn!=null)
                System.out.println("bien");
        } catch (Exception e) {
            System.out.println("arruinado"+e.getMessage());
        }
    }
    }
