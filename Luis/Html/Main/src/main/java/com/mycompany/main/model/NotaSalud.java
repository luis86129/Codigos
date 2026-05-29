/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa una nota de salud o síntoma registrado por el usuario.
 * La fecha y hora se capturan automáticamente al crear la nota.
 *
 * @author Grupo
 * @version 1.0
 */
public class NotaSalud {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

    private final LocalDateTime fechaHora;
    private final String descripcion;

    /**
     * Constructor de la nota de salud.
     * Registra automáticamente la fecha y hora actuales del sistema.
     *
     * @param descripcion Descripción del estado de salud o síntomas.
     */
    public NotaSalud(String descripcion) {
        this.fechaHora = LocalDateTime.now();
        this.descripcion = descripcion;
    }

    /**
     * Constructor con fecha y hora explícita (para datos iniciales).
     *
     * @param fechaHora   Fecha y hora de la nota.
     * @param descripcion Descripción del estado de salud o síntomas.
     */
    public NotaSalud(LocalDateTime fechaHora, String descripcion) {
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    /** @return Fecha y hora del registro */
    public LocalDateTime getFechaHora() { return fechaHora; }

    /** @return Descripción de los síntomas */
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return String.format("%-20s | %s", fechaHora.format(FORMATO), descripcion);
    }
}
