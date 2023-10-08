package formulario;

import database.Conexion;
import database.IngresarInformacion;
import modelo.AlojamientoHospedaje;

import javax.swing.*;

public class CrearHospedaje {

    //Creamos una instancia de la clase conexion
    private static final IngresarInformacion INGRESAR_DB= new IngresarInformacion(); // Son atributos

    public void cargarHospedaje(int idUsuario){
        String nombreLugar = JOptionPane.showInputDialog("Ingrese un nombre del Lugar:");
        String tipo = JOptionPane.showInputDialog("Ingrese 1- Departamento 2- Cabaña 3- Hotel un 1/4:");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese capacidad MAXIMA:"));
        String localizacion = JOptionPane.showInputDialog("Ingrese PROVINCIA:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto por día:"));



        // Creamos un constructor, creo un objeto con estados cargados y otros por defecto (ya que esto no se pasa a la base de datos)
        AlojamientoHospedaje newhospedaje = new AlojamientoHospedaje(nombreLugar,tipo,capacidad,localizacion,precio,idUsuario);


        INGRESAR_DB.cargarHospedaje(newhospedaje);



    }

}
