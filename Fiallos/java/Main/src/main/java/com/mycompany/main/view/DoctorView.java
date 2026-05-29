/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.view;

import com.mycompany.main.model.Doctor;
import com.mycompany.main.util.Consola;

import java.util.List;

/**
 * Vista para la gestión de médicos.
 *
 * @author Grupo
 * @version 1.0
 */
public class DoctorView {

    /**
     * Muestra las opciones del menú de médicos.
     */
    public void mostrarMenuDoctores() {
        System.out.println("¿Qué acción desea realizar?");
        System.out.println("[1] Agregar un nuevo médico");
        System.out.println("[2] Eliminar un médico existente");
        System.out.println("[0] Regresar al Menú Principal");
        Consola.separador();
    }

    /**
     * Muestra la lista de todos los médicos registrados.
     *
     * @param doctores Lista de médicos.
     */
    public void mostrarListaDoctores(List<Doctor> doctores) {
        System.out.println("Listado actual del personal médico registrado:");
        Consola.separador();
        if (doctores.isEmpty()) {
            System.out.println("  No hay médicos registrados.");
        } else {
            System.out.printf("%-6s | %-25s | %-15s | %s%n",
                    "ID", "NOMBRE COMPLETO", "ESPECIALIDAD", "TELÉFONO / CONTACTO");
            Consola.separador();
            for (Doctor d : doctores) {
                System.out.println(d);
            }
        }
        Consola.separador();
    }
}