package formulario;

import database.Conexion;
import database.IngresarInformacion;
import modelo.AlojamientoHospedaje;
import modelo.Provincias;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class CrearHospedaje {

    //Creamos una instancia de la clase conexion
    private static final IngresarInformacion INGRESAR_DB= new IngresarInformacion(); // Son atributos
    // Instanciamos la clase ArrayList con las provincias para el selector

    Provincias provincias = new Provincias();



    public void cargarHospedaje(int idUsuario){
        String nombreLugar = JOptionPane.showInputDialog("Ingrese un nombre del Lugar:");
        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1- Departamento 2- Cabaña 3- Hotel un 1/4:"));
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese capacidad MAXIMA:"));
        String localizacion = provincias.getProvincias();
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto por día:"));



        // Creamos un constructor, creo un objeto con estados cargados y otros por defecto (ya que esto no se pasa a la base de datos)
        AlojamientoHospedaje newhospedaje = new AlojamientoHospedaje(nombreLugar,tipo,capacidad,localizacion,precio,idUsuario);


        INGRESAR_DB.cargarHospedaje(newhospedaje);



    }

}