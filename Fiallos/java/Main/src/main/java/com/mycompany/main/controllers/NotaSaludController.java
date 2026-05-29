/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.controllers;

import com.mycompany.main.model.NotaSalud;
import com.mycompany.main.model.Perfil;
import com.mycompany.main.util.Consola;
import com.mycompany.main.view.NotaSaludView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

/**
 * Controlador para la gestión de notas de salud.
 * Coordina las operaciones entre el modelo {@link NotaSalud} y la vista {@link NotaSaludView}.
 *
 * @author Grupo
 * @version 1.0
 */
public class NotaSaludController {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    private final NotaSaludView vista;

    /** Constructor del controlador de notas de salud. */
    public NotaSaludController() {
        this.vista = new NotaSaludView();
    }

    /**
     * Muestra el menú principal de notas de salud.
     *
     * @param perfil Perfil activo del usuario.
     */
    public void mostrarMenu(Perfil perfil) {
        boolean continuar = true;
        while (continuar) {
            Consola.encabezado("5. Notas de Salud");
            List<NotaSalud> ordenadas = perfil.getNotas().stream()
                    .sorted(Comparator.comparing(NotaSalud::getFechaHora).reversed())
                    .toList();
            vista.mostrarListaNotas(ordenadas);
            System.out.println();
            vista.mostrarMenuNotas();
            int opcion = Consola.leerEntero("> Seleccione una opción: ", 0, 1);
            switch (opcion) {
                case 1 -> agregarNota(perfil);
                case 0 -> continuar = false;
            }
        }
    }

    /**
     * Guía al usuario para agregar una nueva nota de salud.
     * La fecha y hora se capturan automáticamente del sistema.
     *
     * @param perfil Perfil del usuario.
     */
    private void agregarNota(Perfil perfil) {
        Consola.separador();
        System.out.println("[Notas de Salud > Añadir Nueva Nota]");
        Consola.separador();

        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Fecha y hora actuales del registro: " + ahora.format(FORMATO));
        String descripcion = Consola.leerTextoObligatorio("> Ingrese la descripción de su estado de salud: ");

        NotaSalud nota = new NotaSalud(ahora, descripcion);
        perfil.getNotas().add(nota);

        Consola.separador();
        System.out.println("GUARDANDO NOTA...");
        Consola.separador();
        Consola.exito("Tu nota de salud ha sido guardada:");
        Consola.detalle("Registro: " + ahora.format(FORMATO));
        Consola.detalle("Nota: \"" + descripcion + "\"");
        Consola.separadorDoble();
        Consola.pausar();
    }
}