/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa el historial de una recarga de inventario de medicamento.
 *
 * @author Grupo
 * @version 1.0
 */
public class RegistroRecarga {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private final String nombreMedicamento;
    private final int cantidadAgregada;
    private final int stockResultante;
    private final LocalDateTime fechaHora;

    /**
     * Constructor del registro de recarga.
     *
     * @param nombreMedicamento Nombre del medicamento recargado.
     * @param cantidadAgregada  Unidades añadidas al inventario.
     * @param stockResultante   Stock total tras la recarga.
     */
    public RegistroRecarga(String nombreMedicamento, int cantidadAgregada, int stockResultante) {
        this.nombreMedicamento = nombreMedicamento;
        this.cantidadAgregada = cantidadAgregada;
        this.stockResultante = stockResultante;
        this.fechaHora = LocalDateTime.now();
    }

    /** @return Nombre del medicamento */
    public String getNombreMedicamento() { return nombreMedicamento; }

    /** @return Cantidad de unidades añadidas */
    public int getCantidadAgregada() { return cantidadAgregada; }

    /** @return Stock tras la recarga */
    public int getStockResultante() { return stockResultante; }

    /** @return Fecha y hora de la recarga */
    public LocalDateTime getFechaHora() { return fechaHora; }

    @Override
    public String toString() {
        return String.format("[%s] +%d unidades a %s -> Stock: %d",
                fechaHora.format(FORMATO), cantidadAgregada, nombreMedicamento, stockResultante);
    }
}