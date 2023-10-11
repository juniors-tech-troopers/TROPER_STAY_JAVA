/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulario;

import database.ObtenerInformacion;
import java.awt.BorderLayout;
import java.util.ArrayList;
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
    private final Carrito carrito;   

    public VerHospedajes() {
        setLayout(new BorderLayout());
        obtenerInformacion = new ObtenerInformacion();
        carrito = new Carrito();
    }

    public void ingresarFiltrosDeUsuario() {
        String localizacion = JOptionPane.showInputDialog("Ingrese la localización:");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad:"));

        // Realiza la búsqueda con los filtros ingresados por el usuario
        List<AlojamientoHospedaje> hospedajes = obtenerInformacion.filtrarHospedajes(localizacion, capacidad);

        // Muestra los resultados y permite al usuario seleccionar alquileres
        List<AlojamientoHospedaje> alquileresSeleccionados = seleccionarAlquileres(hospedajes);

        // Agregar al carrito los alquileres seleccionados
        for (AlojamientoHospedaje hospedaje : alquileresSeleccionados) {
            carrito.agregarAlojamiento(hospedaje);
        }
        
        JOptionPane.showMessageDialog(this, "Alojamientos agregados al carrito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
// Listado alquileres
    
    public List<AlojamientoHospedaje> seleccionarAlquileres(List<AlojamientoHospedaje> hospedajes) {
        List<AlojamientoHospedaje> alquileresSeleccionados = new ArrayList<>();
        Object[] alquilerOptions = hospedajes.toArray();

        while (true) {
            Object seleccion = JOptionPane.showInputDialog(
                this,
                "Seleccione alquileres para agregar al carrito:",
                "Selección de Alquileres",
                JOptionPane.PLAIN_MESSAGE,
                null,
                alquilerOptions,
                null
            );

            if (seleccion == null) {
                break; // El usuario presionó "Cancelar" o cerró la ventana
            }

            // Agregar el alquiler seleccionado a la lista de alquileres seleccionados
            alquileresSeleccionados.add((AlojamientoHospedaje) seleccion);
        }

        return alquileresSeleccionados;
    }
}