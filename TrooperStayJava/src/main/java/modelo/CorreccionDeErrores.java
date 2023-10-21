package modelo;

import database.ObtenerInformacion;
import javax.swing.JOptionPane;

public class CorreccionDeErrores {
    ObtenerInformacion ObtenerInformacion = new ObtenerInformacion();
    
    public String correccionString(String dato) {
    int conteo = 0;

    while (conteo <= 3) {
        String texto = JOptionPane.showInputDialog(dato);
        if (texto == null || texto.isEmpty() && conteo < 3)  {
            // Si el texto es nulo o está vacío, pedir al usuario que ingrese un texto no nulo.
            JOptionPane.showMessageDialog(null, "ERROR: No puede estar vacío. Intentos restantes: " + (3 - conteo));
            conteo += 1;
        } else if (texto.length() < 6 || texto.length() > 8 && conteo < 3) {
            // Si el texto tiene menos de 6 o más de 8 caracteres, pedir al usuario que ingrese un texto con la longitud adecuada.
            JOptionPane.showMessageDialog(null, "ERROR: Debe tener entre 6 y 8 caracteres. Intentos restantes: " + (3 - conteo));
            conteo += 1;
        } else {
            // Si el texto cumple con los requisitos, simplemente lo devolvemos sin cambios.
            return texto;
        }
    }

    JOptionPane.showMessageDialog(null, "Volvemos al menú principal");
    return null; // Retorna null para indicar que no se pudo obtener un valor válido después de tres intentos.
}

    public Integer correccionInt(String mensaje) {
        int conteo = 1;
        int numero = 0;

        while (conteo <= 3) {
           String input = JOptionPane.showInputDialog(mensaje);
            try {
                numero = Integer.parseInt(input);
                if (numero != 0) {
                    return numero;
                }
            } catch (NumberFormatException e) {
                // Error al convertir a entero
            }
            if (conteo < 3) {
                JOptionPane.showMessageDialog(null, "ERROR: Ingrese un número entero meyor a cero. Intentos restantes: " + (3 - conteo));
                conteo += 1;
                
            } else {
                JOptionPane.showMessageDialog(null, "Volvemos al menú principal");
                return 0;
            }
        }

        return 0; // En teoría, no deberíamos llegar a este punto.
    }
    
    public String correccionCorreo(String dato) {
    int conteo = 0;

    while (conteo < 3) {
        String texto = JOptionPane.showInputDialog(dato);
        if (texto == null || texto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: el correo no puede estar vacío. Intentos restantes: " + (3 - conteo));
        } else if (!texto.contains("@") || !texto.contains(".com")) {
            JOptionPane.showMessageDialog(null, "ERROR: Correo electrónico incorrecto. Intentos restantes: " + (3 - conteo));
        } else {
            return texto;
        }

        conteo++;
    }

    // Si después de 3 intentos no se proporciona un correo válido, puedes manejar el flujo de tu programa como lo desees, por ejemplo, lanzando una excepción o devolviendo un valor predeterminado.
    return "Correo no válido"; // O puedes lanzar una excepción aquí.
}

    public String correccionUsuario(String dato) {
    int conteo = 0;

    while (conteo < 3) {
        String texto = JOptionPane.showInputDialog(dato);
        if (texto == null || texto.isEmpty())  {
            // Si el texto es nulo o está vacío, pedir al usuario que ingrese un texto no nulo.
            JOptionPane.showMessageDialog(null, "El usuario no puede estar vacío. Intentos restantes: " + (3 - conteo));
            conteo += 1;
        } else if (ObtenerInformacion.verificarUsuario(texto)) {
            // Si el usuario ya existe, mostrar un mensaje de error.
            JOptionPane.showMessageDialog(null, "El usuario ya existe. Intentos restantes: " + (3 - conteo));
            conteo += 1;
        } else if (texto.length() < 6 || texto.length() > 8) {
            // Si el texto tiene menos de 6 o más de 8 caracteres, pedir al usuario que ingrese un texto con la longitud adecuada.
            JOptionPane.showMessageDialog(null, "El usuario debe tener entre 6 y 8 caracteres. Intentos restantes: " + (3 - conteo));
            conteo += 1;
        } else {
            return texto;
        }
    }

    JOptionPane.showMessageDialog(null, "Volvemos al menú principal");
    return null; // Retorna null para indicar que no se pudo obtener un valor válido después de tres intentos.
}

}
