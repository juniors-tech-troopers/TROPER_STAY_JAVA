package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public Connection conexion;

    public Conexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/trooper_stay", "root", "02091898");
        } catch (Exception e) {
            System.err.print("Error" + e);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

}
