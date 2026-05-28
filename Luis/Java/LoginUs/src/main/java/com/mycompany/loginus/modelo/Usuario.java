package com.mycompany.loginus.modelo;

public class Usuario {

    private int id;

    private String nombre;

    private String apellido;

    private String usuario;

    private String correo;

    private String contraseña;

    // CONSTRUCTOR VACIO
    public Usuario() {
    }

    // CONSTRUCTOR SIN ID
    public Usuario(
            String nombre,
            String apellido,
            String usuario,
            String correo,
            String contraseña
    ) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;

    }

    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}