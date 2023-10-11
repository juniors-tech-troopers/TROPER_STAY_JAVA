package modelo;

public class Usuario {
    public int id;
    public String nombre_de_usuario;
    public String contrasenia;
    public String correo;
    public int edad;
    public String nombre;
    public String apellido;
    public double saldo;

    public Usuario(int id, String nombre_de_usuario, String contrasenia, String correo, int edad, String nombre, String apellido, double saldo) {
        this.id = id;
        this.nombre_de_usuario = nombre_de_usuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
    }    
    
    public Usuario(String nombre_de_usuario, String contrasenia, String correo, int edad, String nombre, String apellido) {
        this.nombre_de_usuario = nombre_de_usuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        
        // Son creados por default 
        this.id = 0;
        this.saldo = 20000/2;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_de_usuario() {
        return nombre_de_usuario;
    }

    public void setNombre_de_usuario(String nombre_de_usuario) {
        this.nombre_de_usuario = nombre_de_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
