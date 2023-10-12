
package formulario;


import database.Conexion;
import javax.swing.JOptionPane;

public class Panel {
    
    //Creamos un objeto de la clase cargar hospedaje
    CrearHospedaje crearhospedaje = new CrearHospedaje();     
        
    //Creamos un objeto de la clase verHospedaje
    VerHospedajes vista = new VerHospedajes();
        
    private int idUsuario; // Agrega una variable para almacenar el ID de usuario
    //Constructor 
     public Panel() {
        
                
    }
      
    public void Panel() {
        while (true) { // Cambiamos la condición a true
            String[] arreglo = {"Ver hospedajes", "Cargar Hospedaje", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Elige una opción", "MENÚ PRINCIPAL", 0, JOptionPane.QUESTION_MESSAGE, null, arreglo, "");

            if (opcion == -1 || opcion == 2) { // Salir si se cierra el cuadro o se selecciona "Salir"
                break;
            }

            switch (opcion) {
                case 0:
                    // Lógica para "Ver hospedajes"
                    vista.ingresarFiltrosDeUsuario();
                    break;
                case 1:
                    //Lógica para "Insetar hospedajes"
                   crearhospedaje.cargarHospedaje(11);
                    
                    break;
                case 2:
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        }
    }
}

