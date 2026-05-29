/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.view;


import com.mycompany.main.model.Medicamento;
import com.mycompany.main.util.Consola;

import java.util.List;

/**
 * Vista para la gestión de medicamentos.
 * Responsable de toda la presentación en consola relacionada con medicamentos.
 *
 * @author Grupo
 * @version 1.0
 */
public class MedicamentoView {

    /**
     * Muestra el menú principal de administración de medicamentos.
     */
    public void mostrarMenuMedicamentos() {
        Consola.encabezado("1. Administrar Medicamentos");
        System.out.println("[1] Lista de Medicamentos Activos");
        System.out.println("[2] Añadir Medicina");
        System.out.println("[3] Eliminar Medicina");
        System.out.println("[4] Registrar Toma");
        System.out.println("[5] Recarga de Medicina");
        System.out.println("[6] Recordatorio de Recarga");
        System.out.println("[0] Regresar al Menú Principal");
        Consola.separador();
    }

    /**
     * Muestra la lista completa de medicamentos con estadísticas.
     *
     * @param medicamentos Lista de medicamentos activos.
     */
    public void mostrarListaMedicamentos(List<Medicamento> medicamentos) {
        Consola.encabezado("1.1. Lista de Medicamentos Activos");

        if (medicamentos.isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
            return;
        }

        System.out.println("Se encontraron " + medicamentos.size() + " medicamento(s) activo(s).");
        Consola.separador();
        System.out.printf("%-4s | %-15s | %-15s | %-20s | %s%n",
                "ID", "NOMBRE", "PRESENTACIÓN", "FRECUENCIA", "STOCK/CANT.");
        Consola.separador();
        for (Medicamento m : medicamentos) {
            System.out.println(m);
        }
        Consola.separador();

        long tomasHoy = medicamentos.stream().mapToLong(Medicamento::tomasHoy).sum();
        long alertas  = medicamentos.stream().filter(Medicamento::necesitaRecarga).count();

        System.out.println("Estadísticas rápidas:");
        System.out.println("-> Total de dosis administradas hoy: " + tomasHoy);
        if (alertas == 0) {
            System.out.println("-> Alertas: Ningún medicamento está próximo a agotarse.");
        } else {
            medicamentos.stream()
                    .filter(Medicamento::necesitaRecarga)
                    .forEach(m -> System.out.println("-> ALERTA: " + m.getNombre() +
                            " tiene solo " + m.getStock() + " unidades (umbral: " + m.getUmbralAlerta() + ")"));
        }
        Consola.separadorDoble();
    }

    /**
     * Muestra una lista simplificada de medicamentos para selección.
     *
     * @param medicamentos Lista de medicamentos.
     */
    public void mostrarListaSimple(List<Medicamento> medicamentos) {
        System.out.printf("%-4s | %-15s | %-15s | %s%n",
                "ID", "NOMBRE", "PRESENTACIÓN", "STOCK/CANT.");
        Consola.separador();
        for (Medicamento m : medicamentos) {
            System.out.printf("%-4s | %-15s | %-15s | %d unidades%n",
                    m.getId(), m.getNombre(), m.getPresentacion().getDescripcion(), m.getStock());
        }
        Consola.separador();
    }

    /**
     * Muestra la lista de medicamentos con formato para registrar toma.
     *
     * @param medicamentos Lista de medicamentos.
     */
    public void mostrarListaParaToma(List<Medicamento> medicamentos) {
        System.out.printf("%-4s | %-15s | %-15s | %-10s | %s%n",
                "ID", "NOMBRE", "PRESENTACIÓN", "DOSIS", "STOCK ACTUAL");
        Consola.separador();
        for (Medicamento m : medicamentos) {
            System.out.printf("%-4s | %-15s | %-15s | %-10s | %d unidades%n",
                    m.getId(), m.getNombre(), m.getPresentacion().getDescripcion(),
                    m.getDosis(), m.getStock());
        }
        Consola.separador();
    }

    /**
     * Muestra el inventario actual de medicamentos.
     *
     * @param medicamentos Lista de medicamentos.
     */
    public void mostrarInventario(List<Medicamento> medicamentos) {
        System.out.printf("%-4s | %-15s | %-15s | %s%n",
                "ID", "NOMBRE", "PRESENTACIÓN", "STOCK ACTUAL");
        Consola.separador();
        for (Medicamento m : medicamentos) {
            System.out.printf("%-4s | %-15s | %-15s | %d unidades%n",
                    m.getId(), m.getNombre(), m.getPresentacion().getDescripcion(), m.getStock());
        }
        Consola.separador();
    }

    /**
     * Muestra la configuración actual de alertas de inventario.
     *
     * @param medicamentos Lista de medicamentos.
     */
    public void mostrarConfiguracionAlertas(List<Medicamento> medicamentos) {
        System.out.printf("%-4s | %-15s | %-15s | %s%n",
                "ID", "NOMBRE", "STOCK ACTUAL", "UMBRAL CONFIGURADO");
        Consola.separador();
        for (Medicamento m : medicamentos) {
            String umbral = m.getUmbralAlerta() == 0
                    ? "Sin activar (0)"
                    : m.getUmbralAlerta() + " unidades";
            System.out.printf("%-4s | %-15s | %-15s | %s%n",
                    m.getId(), m.getNombre(), m.getStock() + " unidades", umbral);
        }
        Consola.separador();
    }
}
