package koneksi;

import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class KoneksiDatabase {
    Connection cn;
    public static Connection BukaKoneksi()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager
                    .getConnection("jdbc:mysql://localhost/dbapotek","root","");
            return cn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
