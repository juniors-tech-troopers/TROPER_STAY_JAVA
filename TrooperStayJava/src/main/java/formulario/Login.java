
package formulario;

import database.Conexion;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;
public class Login {

    //Creamos una instancia de la clase conexion
    Conexion cn = new Conexion();
    //Creamos una instancia de la clase panel
    Panel panel = new Panel();
    public void iniciarSesion() {
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contrasenia = JOptionPane.showInputDialog("Ingrese su contraseña:");

        if (validarCredenciales(nombreUsuario, contrasenia)) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
            panel.Panel();
            
        } else {
            JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Verifique sus credenciales.");
        }
    }

    private boolean validarCredenciales(String nombreUsuario, String contrasenia) {
        //Query de consulta para verificar si los datos ingresados son correctos
        String sql = "SELECT * FROM usuarios WHERE nombre_de_usuario = ? AND contrasenia = ?";
        
        //Obtenemos la conexión desde la instancia de "Conexion" (cn)
        Connection conexion = cn.conexion;
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasenia);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
    }

    

    
}
