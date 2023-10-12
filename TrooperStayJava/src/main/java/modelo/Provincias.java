package modelo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Provincias {
    private ArrayList<String> provincias = new ArrayList<>(Arrays.asList(
            "Buenos Aires",
            "Catamarca",
            "Chaco",
            "Chubut",
            "Córdoba",
            "Corrientes",
            "Entre Ríos",
            "Formosa",
            "Jujuy",
            "La Pampa",
            "La Rioja",
            "Mendoza",
            "Misiones",
            "Neuquén",
            "Río Negro",
            "Salta",
            "San Juan",
            "San Luis",
            "Santa Cruz",
            "Santa Fe",
            "Santiago del Estero",
            "Tierra del Fuego"
    ));
    public String getProvincias() {
        String[] provinciasArray = provincias.toArray(new String[0]);

        String localizacion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una provincia:",
                "Selección de Provincia",
                JOptionPane.QUESTION_MESSAGE,
                null,
                provinciasArray,
                provinciasArray[0]
        );
        return localizacion.toLowerCase();
        // TODO: toLowerCase(Locale.ROOT) convierte a minuscula
    }
}
