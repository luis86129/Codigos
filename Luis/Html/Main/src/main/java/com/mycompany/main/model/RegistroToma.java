/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa el registro histórico de una toma de medicamento.
 *
 * @author Grupo
 * @version 1.0
 */
public class RegistroToma {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private final String nombreMedicamento;
    private final LocalDateTime fechaHora;
    private final String dosis;

    /**
     * Constructor del registro de toma.
     *
     * @param nombreMedicamento Nombre del medicamento tomado.
     * @param fechaHora         Fecha y hora de la toma.
     * @param dosis             Dosis administrada.
     */
    public RegistroToma(String nombreMedicamento, LocalDateTime fechaHora, String dosis) {
        this.nombreMedicamento = nombreMedicamento;
        this.fechaHora = fechaHora;
        this.dosis = dosis;
    }

    /** @return Nombre del medicamento */
    public String getNombreMedicamento() { return nombreMedicamento; }

    /** @return Fecha y hora de la toma */
    public LocalDateTime getFechaHora() { return fechaHora; }

    /** @return Dosis administrada */
    public String getDosis() { return dosis; }

    @Override
    public String toString() {
        return String.format("%s tomado el %s (Dosis: %s)",
                nombreMedicamento, fechaHora.format(FORMATO), dosis);
    }
}