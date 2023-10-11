package modelo;

public class AlojamientoHospedaje {

    
    // Se usa private final porque es un atributo inmutable y despues usamos un get
    private final int id;
    private final String nombre;
    //Cambiasmos el tipo de dato int
    private final int tipo;
    private final int capacidad;
    private final String localizacion;
    private final double precio_por_noche;
    //Cambiamos el tipo de dato a estado
    private byte estado;
    private final int id_usuario;
    private final int id_usuario_inquilino;
    private final String estadia;

    public AlojamientoHospedaje(int id, String nombre, int tipo, int capacidad, String localizacion, double precio_por_noche, byte estado, int id_usuario, int idUsuarioInquilino, String estadia) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
        this.precio_por_noche = precio_por_noche;
        this.estado = estado;
        this.id_usuario = id_usuario;
        this.id_usuario_inquilino = idUsuarioInquilino;
        this.estadia = estadia;
    }

    // Se creo para crear un nuevo hospedaje
    public AlojamientoHospedaje(String nombre, int tipo, int capacidad, String localizacion, double precio_por_noche, int id_usuario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
        this.precio_por_noche = precio_por_noche;
        this.id_usuario = id_usuario;
        // Son creados por default
        this.id = 0;
        this.estado = 0; // Falso porque no esta alquilado :)
        this.id_usuario_inquilino = 0;
        this.estadia = "";

    }
    
    //Getter y Setter
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public double getPrecio_por_noche() {
        return precio_por_noche;
    }

    public byte getEstado() {
        return estado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getId_usuario_inquilino() {
        return id_usuario_inquilino;
    }

    public String getEstadia() {
        return estadia;
    }

   
   

   
  
}

