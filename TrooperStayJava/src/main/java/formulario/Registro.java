
package formulario;



import database.Conexion;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Registro {
    
    Conexion cn = new Conexion();
     public void registrarUsuario() {
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese un nombre de usuario:");
        String contrasenia = JOptionPane.showInputDialog("Ingrese una contraseña:");
        String correo = JOptionPane.showInputDialog("Ingrese su correo:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese su apellido:");
        float saldo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese su saldo:"));

        if (insertarUsuario(nombreUsuario, contrasenia, correo, edad, nombre, apellido, saldo)) {
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
        } else {
            JOptionPane.showMessageDialog(null, "Error en el registro. Inténtelo nuevamente.");
        }
    }

    private boolean insertarUsuario(String nombreUsuario, String contrasenia, String correo, int edad, String nombre, String apellido, float saldo) {
        String sql = "INSERT INTO usuarios (nombre_de_usuario, contrasenia, correo, edad, nombre, apellido, saldo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conexion = cn.conexion;

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasenia);
            statement.setString(3, correo);
            statement.setInt(4, edad);
            statement.setString(5, nombre);
            statement.setString(6, apellido);
            statement.setFloat(7, saldo);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
