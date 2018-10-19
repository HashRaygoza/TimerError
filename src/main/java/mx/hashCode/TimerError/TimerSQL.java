package mx.hashCode.TimerError;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimerSQL extends TimerTask {
    static private final Logger LOGGER = Logger.getLogger("mx.hashCode.TimerError.TimerSQL");

    public Connection crearConexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String usuario = "archivista";
        String passwd = "123456789";

        Connection cx = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/"+ "?useSSL=false&" + "user="+ usuario + "&" + "password=" + passwd + "");

        return cx;
    }

    @Override
    public void run() {
        try {
            String sql = "SELECT * FROM pruebas.juegos;";            
            
            try(Connection cx = this.crearConexion(); Statement consulta = cx.createStatement()) {
                ResultSet data = consulta.executeQuery(sql);

                LOGGER.log(Level.INFO, "Presentaremos los datos");
                System.out.println("");
                while(data.next() == true) {
                    System.out.print(data.getString("nombre") + " ");
                    System.out.println(data.getString("consola"));
                }
                System.out.println("");
                data.close();
            }

        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "OCURRIO UN ERROR DE ACCESO A DB!!!");
            LOGGER.log(Level.SEVERE, "Pero el ciclo deberia repetirse sin problema");
            //LOGGER.log(Level.SEVERE, null, e);
        }
    }

}