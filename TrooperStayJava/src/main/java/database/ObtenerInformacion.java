package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import modelo.AlojamientoHospedaje;
import modelo.Usuario;

import javax.swing.*;

public class ObtenerInformacion {

    private static final Connection CONEXION = new Conexion().getConexion();


    public Usuario loguearse(String nombreUsuario, String contrasenia) {
        //Query de consulta para verificar si los datos ingresados son correctos
        String sql = "SELECT id, nombre_de_usuario, saldo, contrasenia FROM usuarios WHERE nombre_de_usuario = ?";
        try (PreparedStatement statement = CONEXION.prepareStatement(sql)) {
            statement.setString(1, nombreUsuario);
            ResultSet resultSet = statement.executeQuery();

            // Devolvemos un null si el usuario no se encontro
            // resultSet.next() == false => !resultSet.next()
            if (!resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Usuario incorrecto");
                return null;
            }

            // Defini, la contraseña del db
            String contraseniaDB = resultSet.getString("contrasenia");

            if (Objects.equals(contraseniaDB, contrasenia)) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre_de_usuario"),
                        resultSet.getDouble("saldo")
                );
                return usuario;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }
    
    
    public boolean verificarUsuario(String nombreUsuario) {
    // Query de consulta para verificar si los datos ingresados son correctos
    String sql = "SELECT nombre_de_usuario FROM tu_tabla WHERE nombre_de_usuario = ?";
    try (PreparedStatement statement = CONEXION.prepareStatement(sql)) {
        statement.setString(1, nombreUsuario);
        ResultSet resultSet = statement.executeQuery();

        // Verificar si se encontró un resultado en la consulta
        return resultSet.next();
    } catch (SQLException e) { // Puedes imprimir el error para depuración.
        
        return false;
    }
}

    public List<AlojamientoHospedaje> filtrarHospedajes(String localizacion, int capacidad) {
        List<AlojamientoHospedaje> hospedajesFiltrados = new ArrayList<>();

        try {
            String sql = "SELECT * FROM hospedajes WHERE localizacion = ? AND capacidad >= ? AND estado = 0";
            PreparedStatement stmt = CONEXION.prepareStatement(sql);
            stmt.setString(1, localizacion);
            stmt.setInt(2, capacidad);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreLugar = rs.getString("nombre");
                int tipoHospedaje = rs.getInt("tipo");
                int capacidadHospedaje = rs.getInt("capacidad");
                String localizacionHospedaje = rs.getString("localizacion");
                double precioPorNoche = rs.getDouble("precio_por_noche");
                byte estado = rs.getByte("estado");
                int idUsuario = rs.getInt("id_usuario");
                int idUsuarioInquilino = rs.getInt("id_usuario_inquilino");
                String estadia = rs.getString("estadia");
                //Instanciamos la clase alojamiento hospedaje
                AlojamientoHospedaje hospedaje = new AlojamientoHospedaje(id, nombreLugar, tipoHospedaje, capacidadHospedaje, localizacionHospedaje, precioPorNoche, estado, idUsuario, idUsuarioInquilino, estadia);
                hospedajesFiltrados.add(hospedaje);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hospedajesFiltrados;
    }

    public double obtenerSaldoDeUsuarioPorId(int usuarioId) {
        String sql = "SELECT saldo FROM usuarios WHERE id = ?;";

        try {
            PreparedStatement stmt = CONEXION.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            return rs.getDouble("saldo");

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
