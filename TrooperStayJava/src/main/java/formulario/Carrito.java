package formulario;

import java.util.ArrayList;
import java.util.List;
import modelo.AlojamientoHospedaje;

/**
 *
 * @author Yamil
 */
public class Carrito {
    private List<AlojamientoHospedaje> alojamientosEnCarrito;

    public Carrito() {
        alojamientosEnCarrito = new ArrayList<>();
    }

    public void agregarAlojamiento(AlojamientoHospedaje alojamiento) {
        alojamientosEnCarrito.add(alojamiento);
    }

    public void eliminarAlojamiento(AlojamientoHospedaje alojamiento) {
        alojamientosEnCarrito.remove(alojamiento);
    }

    public List<AlojamientoHospedaje> obtenerAlojamientosEnCarrito() {
        return alojamientosEnCarrito;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (AlojamientoHospedaje alojamiento : alojamientosEnCarrito) {
            // Asumiendo que AlojamientoHospedaje tiene un método getPrecio() para obtener el precio
            total += alojamiento.getPrecio_por_noche();
        }
        return total;
    }
}