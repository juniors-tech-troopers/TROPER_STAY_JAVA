
package formulario;


import database.Conexion;
import javax.swing.JOptionPane;

public class Panel {
    Conexion miConexion = new Conexion(); // Esto al parecer no va
    CrearHospedaje crearHospedaje = new CrearHospedaje();
     boolean salir = false;

    public void panel(){
           while (!salir) {
            String opcion = JOptionPane.showInputDialog("Home:\n1.Ver hospedajes\n2.Cargar hospedaje\n3. Salir");

            switch (opcion) {
                case "1":
                    // Lógica para iniciar sesión

                    break;
                case "2":
                    // Lógica para registrarse
                    crearHospedaje.cargarHospedaje(1); // Esto es codigo duro
                    break;
                case "3":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        } 
    }
}
