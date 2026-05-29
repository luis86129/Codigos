/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un perfil de usuario dentro del sistema.
 * Cada perfil contiene su propia información de salud.
 *
 * @author Grupo
 * @version 1.0
 */
public class Perfil {

    /** Contador estático para generar IDs secuenciales */
    private static int contadorId = 1;

    private final int id;
    private String nombre;
    private String relacion;
    private String email;

    private List<Medicamento> medicamentos;
    private List<Doctor> doctores;
    private List<Cita> citas;
    private List<ActividadFisica> actividades;
    private List<NotaSalud> notas;

    /**
     * Constructor del perfil.
     *
     * @param nombre   Nombre del miembro de la familia.
     * @param relacion Relación con el usuario creador del perfil.
     * @param email    Correo electrónico (puede ser vacío).
     */
    public Perfil(String nombre, String relacion, String email) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.relacion = relacion;
        this.email = email;
        this.medicamentos = new ArrayList<>();
        this.doctores = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.actividades = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    /** @return ID único del perfil */
    public int getId() { return id; }

    /** @return Nombre del usuario */
    public String getNombre() { return nombre; }

    /** @param nombre Nombre del usuario */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return Relación familiar */
    public String getRelacion() { return relacion; }

    /** @param relacion Relación familiar */
    public void setRelacion(String relacion) { this.relacion = relacion; }

    /** @return Email del usuario */
    public String getEmail() { return email; }

    /** @param email Email del usuario */
    public void setEmail(String email) { this.email = email; }

    /** @return Lista de medicamentos del perfil */
    public List<Medicamento> getMedicamentos() { return medicamentos; }

    /** @return Lista de doctores del perfil */
    public List<Doctor> getDoctores() { return doctores; }

    /** @return Lista de citas del perfil */
    public List<Cita> getCitas() { return citas; }

    /** @return Lista de actividades físicas del perfil */
    public List<ActividadFisica> getActividades() { return actividades; }

    /** @return Lista de notas de salud del perfil */
    public List<NotaSalud> getNotas() { return notas; }

    @Override
    public String toString() {
        return id + ". " + nombre + " (" + relacion + ")";
    }
}