public class main {
    public static void main(String[] args) {
        //Creamos una instancia de la clase conexion para establecer la conexión a la base de datos
        conexion cn = new conexion();
        //Intanciamos la clase Menu
        Menu menu = new Menu();
        if(cn.conexion != null){
            System.out.println("La conexión fue exitosa");
            menu.Menu();
        }else{
            System.out.println("La conexión falló");
        }


    }
}
