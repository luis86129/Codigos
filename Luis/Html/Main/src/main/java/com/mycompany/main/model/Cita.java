/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa una cita médica programada en el sistema.
 *
 * @author Grupo
 * @version 1.0
 */
public class Cita {

    /** Contador estático para generar IDs secuenciales */
    private static int contadorId = 1;

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

    private final String id;
    private String titulo;
    private Doctor doctor;
    private LocalDateTime fechaHora;

    /**
     * Constructor de la cita.
     *
     * @param titulo    Título descriptivo de la cita.
     * @param doctor    Médico asignado a la cita.
     * @param fechaHora Fecha y hora de la cita.
     */
    public Cita(String titulo, Doctor doctor, LocalDateTime fechaHora) {
        this.id = String.format("C-%02d", contadorId++);
        this.titulo = titulo;
        this.doctor = doctor;
        this.fechaHora = fechaHora;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    /** @return ID único de la cita */
    public String getId() { return id; }

    /** @return Título de la cita */
    public String getTitulo() { return titulo; }

    /** @param titulo Título de la cita */
    public void setTitulo(String titulo) { this.titulo = titulo; }

    /** @return Doctor asignado */
    public Doctor getDoctor() { return doctor; }

    /** @param doctor Doctor asignado */
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    /** @return Fecha y hora de la cita */
    public LocalDateTime getFechaHora() { return fechaHora; }

    /** @param fechaHora Fecha y hora de la cita */
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    /**
     * Verifica si la cita es futura respecto al momento actual.
     *
     * @return true si la cita aún no ha pasado.
     */
    public boolean esFutura() {
        return fechaHora.isAfter(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-25s | %-25s | %s",
                id, titulo, doctor.getNombre(), fechaHora.format(FORMATO));
    }
}