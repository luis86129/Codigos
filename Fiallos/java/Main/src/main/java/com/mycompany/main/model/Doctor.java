/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.model;

/**
 * Representa un médico registrado en el sistema.
 *
 * @author Grupo
 * @version 1.0
 */
public class Doctor {

    /** Contador estático para generar IDs secuenciales */
    private static int contadorId = 1;

    private final String id;
    private String nombre;
    private String especialidad;
    private String telefono;
    private String email;
    private String direccion;

    /**
     * Constructor del doctor.
     *
     * @param nombre       Nombre completo del médico.
     * @param especialidad Especialidad médica.
     * @param telefono     Número de contacto.
     * @param email        Correo electrónico.
     * @param direccion    Dirección de la consulta.
     */
    public Doctor(String nombre, String especialidad, String telefono,
                  String email, String direccion) {
        this.id = String.format("M-%02d", contadorId++);
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    /** @return ID único del doctor */
    public String getId() { return id; }

    /** @return Nombre completo */
    public String getNombre() { return nombre; }

    /** @param nombre Nombre completo */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return Especialidad */
    public String getEspecialidad() { return especialidad; }

    /** @param especialidad Especialidad */
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    /** @return Teléfono de contacto */
    public String getTelefono() { return telefono; }

    /** @param telefono Teléfono de contacto */
    public void setTelefono(String telefono) { this.telefono = telefono; }

    /** @return Email */
    public String getEmail() { return email; }

    /** @param email Email */
    public void setEmail(String email) { this.email = email; }

    /** @return Dirección de la consulta */
    public String getDireccion() { return direccion; }

    /** @param direccion Dirección de la consulta */
    public void setDireccion(String direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return String.format("%-5s | %-25s | %-15s | %s",
                id, nombre, especialidad, telefono);
    }
}