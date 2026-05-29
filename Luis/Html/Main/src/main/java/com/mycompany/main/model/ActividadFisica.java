/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa una actividad física registrada por el usuario.
 *
 * @author Grupo
 * @version 1.0
 */
public class ActividadFisica {

    /** Tipos de actividad física disponibles */
    public enum TipoActividad {
        CAMINAR("Caminar"),
        TROTAR("Trotar"),
        CORRER("Correr"),
        FUNCIONAL("Funcional"),
        CROSSFIT("Crossfit"),
        ENTRENAMIENTO_PESAS("Entrenamiento de pesas"),
        NADAR("Nadar");

        private final String descripcion;

        TipoActividad(String descripcion) { this.descripcion = descripcion; }

        /** @return Descripción legible del tipo de actividad */
        public String getDescripcion() { return descripcion; }
    }

    /** Horario del día en que se realizó la actividad */
    public enum Horario {
        MANANA("Mañana"),
        TARDE("Tarde"),
        NOCHE("Noche");

        private final String descripcion;

        Horario(String descripcion) { this.descripcion = descripcion; }

        /** @return Descripción legible del horario */
        public String getDescripcion() { return descripcion; }
    }

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final LocalDate fecha;
    private final TipoActividad tipo;
    private final int duracionMinutos;
    private final Horario horario;

    /**
     * Constructor de la actividad física.
     *
     * @param fecha            Fecha en que se realizó la actividad.
     * @param tipo             Tipo de actividad.
     * @param duracionMinutos  Duración en minutos.
     * @param horario          Horario del día.
     */
    public ActividadFisica(LocalDate fecha, TipoActividad tipo,
                           int duracionMinutos, Horario horario) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.duracionMinutos = duracionMinutos;
        this.horario = horario;
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    /** @return Fecha de la actividad */
    public LocalDate getFecha() { return fecha; }

    /** @return Tipo de actividad */
    public TipoActividad getTipo() { return tipo; }

    /** @return Duración en minutos */
    public int getDuracionMinutos() { return duracionMinutos; }

    /** @return Horario del día */
    public Horario getHorario() { return horario; }

    @Override
    public String toString() {
        return String.format("%-12s | %-25s | %-8s | %s",
                fecha.format(FORMATO), tipo.getDescripcion(),
                duracionMinutos + " min", horario.getDescripcion());
    }
}