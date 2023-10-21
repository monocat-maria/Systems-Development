package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */
public class ConnectDAO {

    private Connection conn = null;

    public Connection connectDB() {
        try {

            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11", "root", "Mnct@152!");
                System.out.println("Conectado ao BD");
            } else if (conn.isClosed()) {
                conn = null;
                return connectDB();
            }

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to Driver: " + e.getMessage());

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Error ConnectDAO: " + erro.getMessage());
        }
        return conn;
    }

    public void desconnectDB() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Unable to disconnect from database: " + e.getMessage());
            }
        }
    }
}
