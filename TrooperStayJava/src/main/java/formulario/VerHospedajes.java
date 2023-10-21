
package formulario;

import database.ActualizarInformacion;
import database.ObtenerInformacion;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.AlojamientoHospedaje;
import modelo.Provincias;

/**
 * @author lopoj
 */
public class VerHospedajes extends JPanel {
    private final ObtenerInformacion obtenerInformacion;
    private final Carrito carrito;
    Provincias provincias = new Provincias(); // Instanciamos el modelo


    public VerHospedajes() {
        setLayout(new BorderLayout());

        obtenerInformacion = new ObtenerInformacion();
        carrito = new Carrito();

    }

    public void ingresarFiltrosDeUsuario(int idUsuario, double saldoUsuario) {
        // Llamamos al metodo get provincia para realizar la muestra por filtrado
        String localizacion = provincias.getProvincias();
        // Esto para seguir un patron de ingreso a la base de datos.

        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad:"));

        // Realiza la búsqueda con los filtros ingresados por el usuario
        List<AlojamientoHospedaje> hospedajes = obtenerInformacion.filtrarHospedajes(localizacion, capacidad);

        // Muestra los resultados y permite al usuario seleccionar alquileres
        AlojamientoHospedaje alquilerSeleccionado = seleccionarAlquileres(hospedajes);

        // Ingresamos el id del que acaba de Alquilar
        alquilerSeleccionado.setId_usuario_inquilino(idUsuario);

        // Fecha de hospedaje
        alquilerSeleccionado.setInicio_estadia(JOptionPane.showInputDialog("Ingrese AAAA-MM-DD:"));

        // Definimos cantidad de dias de hospedajes para poder calcular luego.
        int diasHospedaje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los numeros de días a Hospedarse:"));

        // Dias a hospedarse
        alquilerSeleccionado.setEstadia(diasHospedaje);

        // Calculamos el monto que le descontamos al saldo
        double montoFinal = diasHospedaje * alquilerSeleccionado.getPrecio_por_noche();
        if (montoFinal <= saldoUsuario) {
            ActualizarInformacion actualizarInformacion = new ActualizarInformacion();
            // TODO: PRIMERO ACTUALIZAMOS EL HOSPEDAJE
            actualizarInformacion.actualizarHospedajes(alquilerSeleccionado);

            // TODO: SEGUNDO ACTUALIZAMOS EL USUARIO INQUILINO
            double montoFinalInquilino = saldoUsuario - montoFinal;
            actualizarInformacion.actualizarUsuarioInquilino(alquilerSeleccionado, montoFinalInquilino);

            // TODO: TERCER ACTUALIZAMOS EL USUARIO PROPIETARIO
            actualizarInformacion.actualizarUsuarioPropietario(alquilerSeleccionado, montoFinal);

        } else {
            JOptionPane.showMessageDialog(null, "POBRE DE MIERDA NO PODES VIAJAR");
        }
        
        JOptionPane.showMessageDialog(null, "PERFECTO");
        
    }
// Listado alquileres

    public AlojamientoHospedaje seleccionarAlquileres(List<AlojamientoHospedaje> hospedajes) {
        String[] objetoDetallado = new String[hospedajes.size()];

        for (int i = 0; i < hospedajes.size(); i++) {
            AlojamientoHospedaje hospedaje = hospedajes.get(i);

            String tipo = "";
            switch (hospedaje.getTipo()) {
                case 1:
                    tipo = "Departamento";
                    break;
                case 2:
                    tipo = "Cabaña";
                    break;
                case 3:
                    tipo = "Hotel 1/4";
                    break;
            }

            objetoDetallado[i] = "Nombre: " + hospedaje.getNombre() +
                    " - Precio: " + hospedaje.getPrecio_por_noche() +
                    " - Capacidad: " + hospedaje.getCapacidad() +
                    " - Tipo: " + tipo
            ;
        }

        Object seleccion = JOptionPane.showInputDialog(
                this,
                "Seleccione alquileres para agregar al carrito:",
                "Selección de Alquileres",
                JOptionPane.PLAIN_MESSAGE,
                null,
                objetoDetallado,
                null
        );

        // Obtén el índice seleccionado y úsalo para obtener el objeto correspondiente de la lista original.
        if (seleccion != null) {
            int indiceSeleccionado = Arrays.asList(objetoDetallado).indexOf(seleccion);
            return hospedajes.get(indiceSeleccionado);
        } else {
            return null; // Devuelve null si el usuario cancela la selección.
        }
    }
}