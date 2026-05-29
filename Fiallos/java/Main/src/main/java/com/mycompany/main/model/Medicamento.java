/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un medicamento registrado en el sistema.
 * Contiene información sobre presentación, frecuencia, dosis e inventario.
 *
 * @author Grupo
 * @version 1.0
 */
public class Medicamento {

    /** Contador estático para generar IDs secuenciales */
    private static int contadorId = 1;

    /** Presentaciones disponibles para el medicamento */
    public enum Presentacion {
        PASTILLA("Pastilla"),
        INYECCION("Inyección"),
        SOLUCION("Solución"),
        GOTAS("Gotas"),
        INHALADOR("Inhalador"),
        POLVO("Polvo");

        private final String descripcion;

        Presentacion(String descripcion) { this.descripcion = descripcion; }

        /** @return Descripción legible de la presentación */
        public String getDescripcion() { return descripcion; }
    }

    /** Tipo de frecuencia de consumo */
    public enum TipoFrecuencia {
        CADA_DIA("Cada día"),
        CADA_DOS_DIAS("Cada dos días"),
        DIAS_ESPECIFICOS("Días específicos de la semana"),
        CADA_X_DIAS("Cada X días"),
        CADA_X_SEMANAS("Cada X semanas"),
        CADA_X_MESES("Cada X meses");

        private final String descripcion;

        TipoFrecuencia(String descripcion) { this.descripcion = descripcion; }

        /** @return Descripción legible de la frecuencia */
        public String getDescripcion() { return descripcion; }
    }

    /** Número de tomas al día */
    public enum TomasDiarias {
        UNA(1, "Una vez al día"),
        DOS(2, "Dos veces al día"),
        TRES(3, "Tres veces al día");

        private final int cantidad;
        private final String descripcion;

        TomasDiarias(int cantidad, String descripcion) {
            this.cantidad = cantidad;
            this.descripcion = descripcion;
        }

        /** @return Número de tomas */
        public int getCantidad() { return cantidad; }

        /** @return Descripción legible */
        public String getDescripcion() { return descripcion; }
    }

    private final String id;
    private String nombre;
    private int stock;
    private Presentacion presentacion;
    private TipoFrecuencia tipoFrecuencia;
    private String detalleFrecuencia;   // ej: "L,Mi,V" o "3"
    private TomasDiarias tomasDiarias;
    private List<String> horarios;      // formato HH:MM
    private String dosis;
    private int umbralAlerta;
    private List<RegistroToma> historialTomas;
    private List<RegistroRecarga> historialRecargas;

    /**
     * Constructor del medicamento.
     *
     * @param nombre          Nombre del medicamento.
     * @param stock           Cantidad inicial en inventario.
     * @param presentacion    Presentación del medicamento.
     * @param tipoFrecuencia  Frecuencia de consumo.
     * @param detalleFrecuencia Detalle específico de frecuencia (días, número).
     * @param tomasDiarias    Número de tomas por día.
     * @param horarios        Lista de horarios en formato HH:MM.
     * @param dosis           Cantidad a tomar en cada ocasión.
     */
    public Medicamento(String nombre, int stock, Presentacion presentacion,
                       TipoFrecuencia tipoFrecuencia, String detalleFrecuencia,
                       TomasDiarias tomasDiarias, List<String> horarios, String dosis) {
        this.id = String.format("%03d", contadorId++);
        this.nombre = nombre;
        this.stock = stock;
        this.presentacion = presentacion;
        this.tipoFrecuencia = tipoFrecuencia;
        this.detalleFrecuencia = detalleFrecuencia;
        this.tomasDiarias = tomasDiarias;
        this.horarios = new ArrayList<>(horarios);
        this.dosis = dosis;
        this.umbralAlerta = 0;
        this.historialTomas = new ArrayList<>();
        this.historialRecargas = new ArrayList<>();
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    /** @return ID único del medicamento */
    public String getId() { return id; }

    /** @return Nombre del medicamento */
    public String getNombre() { return nombre; }

    /** @param nombre Nombre del medicamento */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return Stock actual */
    public int getStock() { return stock; }

    /** @param stock Nuevo stock */
    public void setStock(int stock) { this.stock = stock; }

    /** @return Presentación del medicamento */
    public Presentacion getPresentacion() { return presentacion; }

    /** @return Tipo de frecuencia */
    public TipoFrecuencia getTipoFrecuencia() { return tipoFrecuencia; }

    /** @return Detalle de frecuencia */
    public String getDetalleFrecuencia() { return detalleFrecuencia; }

    /** @return Tomas diarias */
    public TomasDiarias getTomasDiarias() { return tomasDiarias; }

    /** @return Lista de horarios */
    public List<String> getHorarios() { return horarios; }

    /** @return Dosis por toma */
    public String getDosis() { return dosis; }

    /** @return Umbral de alerta de stock */
    public int getUmbralAlerta() { return umbralAlerta; }

    /** @param umbral Umbral mínimo para activar alerta */
    public void setUmbralAlerta(int umbral) { this.umbralAlerta = umbral; }

    /** @return Historial de tomas */
    public List<RegistroToma> getHistorialTomas() { return historialTomas; }

    /** @return Historial de recargas */
    public List<RegistroRecarga> getHistorialRecargas() { return historialRecargas; }

    /**
     * Registra una toma del medicamento y decrementa el stock.
     *
     * @param fechaHora Fecha y hora de la toma.
     */
    public void registrarToma(LocalDateTime fechaHora) {
        historialTomas.add(new RegistroToma(nombre, fechaHora, dosis));
        if (stock > 0) stock--;
    }

    /**
     * Recarga el inventario del medicamento.
     *
     * @param cantidad Unidades a agregar.
     */
    public void recargar(int cantidad) {
        this.stock += cantidad;
        historialRecargas.add(new RegistroRecarga(nombre, cantidad, stock));
    }

    /**
     * Indica si el stock está por debajo del umbral de alerta.
     *
     * @return true si el stock es menor o igual al umbral configurado.
     */
    public boolean necesitaRecarga() {
        return umbralAlerta > 0 && stock <= umbralAlerta;
    }

    /**
     * Cuenta las tomas registradas en el día actual.
     *
     * @return Número de tomas de hoy.
     */
    public long tomasHoy() {
        LocalDateTime ahora = LocalDateTime.now();
        return historialTomas.stream()
                .filter(t -> t.getFechaHora().toLocalDate().equals(ahora.toLocalDate()))
                .count();
    }

    @Override
    public String toString() {
        return String.format("%-3s | %-15s | %-15s | %-15s | %d unidades",
                id, nombre, presentacion.getDescripcion(),
                tipoFrecuencia.getDescripcion(), stock);
    }
}