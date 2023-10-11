package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.AlojamientoHospedaje;

public class ObtenerInformacion {

    private static final Connection CONEXION = new Conexion().getConexion();

    public List<AlojamientoHospedaje> filtrarHospedajes(String localizacion, int capacidad) {
        List<AlojamientoHospedaje> hospedajesFiltrados = new ArrayList<>();

        try {
            String sql = "SELECT * FROM hospedajes WHERE localizacion = ? AND capacidad >= ?";
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
}
