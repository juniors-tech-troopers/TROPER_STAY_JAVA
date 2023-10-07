package modelo;

public class AlojamientoHospedaje {

    public int id;
    public String nombre;
    public String tipo;
    public int capacidad;
    public String localizacion;
    public double precio_por_noche;
    public boolean estado;
    public int id_usuario;
    public int id_usuario_inquilino;
    public String estadia;

    public AlojamientoHospedaje(int id, String nombre, String tipo, int capacidad, String localizacion, double precio_por_noche, boolean estado, int id_usuario, int id_usuario_inquilino, String estadia) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
        this.precio_por_noche = precio_por_noche;
        this.estado = estado;
        this.id_usuario = id_usuario;
        this.id_usuario_inquilino = id_usuario_inquilino;
        this.estadia = estadia;
    }

}
