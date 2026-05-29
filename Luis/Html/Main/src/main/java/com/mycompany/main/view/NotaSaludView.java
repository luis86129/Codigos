/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.view;

import com.mycompany.main.model.NotaSalud;
import com.mycompany.main.util.Consola;

import java.util.List;

/**
 * Vista para la gestión de notas de salud.
 *
 * @author Grupo
 * @version 1.0
 */
public class NotaSaludView {

    /**
     * Muestra las opciones del menú de notas de salud.
     */
    public void mostrarMenuNotas() {
        System.out.println("¿Qué acción desea realizar?");
        System.out.println("[1] Añadir una nueva nota de salud");
        System.out.println("[0] Regresar al Menú Principal");
        Consola.separador();
    }

    /**
     * Muestra la lista de notas de salud registradas.
     *
     * @param notas Lista de notas (ordenadas externamente, más reciente primero).
     */
    public void mostrarListaNotas(List<NotaSalud> notas) {
        System.out.println("Listado de notas registradas (más reciente primero):");
        Consola.separador();
        if (notas.isEmpty()) {
            System.out.println("  No hay notas registradas.");
        } else {
            System.out.printf("%-22s | %s%n", "FECHA Y HORA", "DESCRIPCIÓN DE SALUD / SÍNTOMAS");
            Consola.separador();
            for (NotaSalud n : notas) {
                System.out.println(n);
            }
        }
        Consola.separador();
    }
}
