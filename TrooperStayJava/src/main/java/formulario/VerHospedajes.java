/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulario;

import database.ObtenerInformacion;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.AlojamientoHospedaje;

/**
 *
 * @author lopoj
 */
public class VerHospedajes extends JPanel {
    private final ObtenerInformacion obtenerInformacion;

      
    public VerHospedajes() {
        setLayout(new BorderLayout());
        obtenerInformacion = new ObtenerInformacion();
    }
    
    public void ingresarFiltrosDeUsuario() {
        String localizacion = JOptionPane.showInputDialog("Ingrese la localización:");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad:"));

        // Realiza la búsqueda con los filtros ingresados por el usuario
        List<AlojamientoHospedaje> hospedajes = obtenerInformacion.filtrarHospedajes(localizacion, capacidad);
        mostrarResultados(hospedajes);
    }

    public void mostrarResultados(List<AlojamientoHospedaje> hospedajes) {
        StringBuilder mensaje = new StringBuilder("Resultados de la búsqueda:\n");
        for (AlojamientoHospedaje hospedaje : hospedajes) {
            mensaje.append("Nombre: ").append(hospedaje.getNombre()).append(", Tipo: ").append(hospedaje.getTipo()).append(", Capacidad: ").append(hospedaje.getCapacidad()).append("\n");
        }
        JOptionPane.showMessageDialog(this, mensaje.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    
}
