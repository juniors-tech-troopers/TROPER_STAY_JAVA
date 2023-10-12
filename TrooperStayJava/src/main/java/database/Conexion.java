package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {

    public Connection conexion;

    // TODO: ANTIGUO CONECTION
    public Conexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/trooper_stay", "root", "root");
        } catch (Exception e) {
            System.err.print("Error" + e);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

}

/* TODO: Este se va a reemplazar por el antiguo conection, EL VIERNES
public Conexion() {
        try {
            Properties properties = new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream("src/main/resources/database.properties");
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            conexion = DriverManager.getConnection(
                    properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD")
            );
        } catch (Exception e) {
            System.err.print("Error" + e);
        }
    }
 */
