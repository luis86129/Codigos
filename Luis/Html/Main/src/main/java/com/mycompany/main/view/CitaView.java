/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.view;


import com.mycompany.main.model.Cita;
import com.mycompany.main.util.Consola;

import java.util.List;

/**
 * Vista para la gestión de citas médicas.
 *
 * @author Grupo
 * @version 1.0
 */
public class CitaView {

    /**
     * Muestra las opciones del menú de citas.
     */
    public void mostrarMenuCitas() {
        System.out.println("¿Qué acción desea realizar?");
        System.out.println("[1] Programar una nueva cita");
        System.out.println("[2] Cancelar/Eliminar una cita futura");
        System.out.println("[0] Regresar al Menú Principal");
        Consola.separador();
    }

    /**
     * Muestra la lista de citas programadas.
     *
     * @param citas Lista de citas (ordenadas externamente).
     */
    public void mostrarListaCitas(List<Cita> citas) {
        System.out.println("Listado de citas programadas (ordenadas por la más próxima):");
        Consola.separador();
        if (citas.isEmpty()) {
            System.out.println("  No hay citas registradas.");
        } else {
            System.out.printf("%-6s | %-25s | %-25s | %s%n",
                    "ID", "TÍTULO DE LA CITA", "MÉDICO ASIGNADO", "FECHA Y HORA");
            Consola.separador();
            for (Cita c : citas) {
                System.out.println(c);
            }
        }
        Consola.separador();
    }
}
