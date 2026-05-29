/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.view;


import com.mycompany.main.model.ActividadFisica;
import com.mycompany.main.util.Consola;

import java.util.List;

/**
 * Vista para la gestión de actividades físicas.
 *
 * @author Grupo
 * @version 1.0
 */
public class ActividadView {

    /**
     * Muestra las opciones del menú de actividades.
     */
    public void mostrarMenuActividades() {
        System.out.println("¿Qué acción desea realizar?");
        System.out.println("[1] Registrar una nueva actividad física");
        System.out.println("[0] Regresar al Menú Principal");
        Consola.separador();
    }

    /**
     * Muestra la lista de actividades físicas registradas.
     *
     * @param actividades Lista de actividades (ordenadas externamente, más reciente primero).
     */
    public void mostrarListaActividades(List<ActividadFisica> actividades) {
        System.out.println("Listado de actividades registradas (más reciente primero):");
        Consola.separador();
        if (actividades.isEmpty()) {
            System.out.println("  No hay actividades registradas.");
        } else {
            System.out.printf("%-12s | %-25s | %-9s | %s%n",
                    "FECHA", "ACTIVIDAD", "DURACIÓN", "HORARIO");
            Consola.separador();
            for (ActividadFisica a : actividades) {
                System.out.println(a);
            }
        }
        Consola.separador();
    }
}