/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.controllers;


import com.mycompany.main.model.ActividadFisica;
import com.mycompany.main.model.Perfil;
import com.mycompany.main.util.Consola;
import com.mycompany.main.view.ActividadView;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

/**
 * Controlador para la gestión de actividades físicas.
 * Coordina las operaciones entre el modelo {@link ActividadFisica} y la vista {@link ActividadView}.
 *
 * @author Grupo
 * @version 1.0
 */
public class ActividadController {

    private final ActividadView vista;

    /** Constructor del controlador de actividades. */
    public ActividadController() {
        this.vista = new ActividadView();
    }

    /**
     * Muestra el menú principal de administración de actividad física.
     *
     * @param perfil Perfil activo del usuario.
     */
    public void mostrarMenu(Perfil perfil) {
        boolean continuar = true;
        while (continuar) {
            Consola.encabezado("4. Notas de Salud: Actividad Física");
            List<ActividadFisica> ordenadas = perfil.getActividades().stream()
                    .sorted(Comparator.comparing(ActividadFisica::getFecha).reversed())
                    .toList();
            vista.mostrarListaActividades(ordenadas);
            System.out.println();
            vista.mostrarMenuActividades();
            int opcion = Consola.leerEntero("> Seleccione una opción: ", 0, 1);
            switch (opcion) {
                case 1 -> registrarActividad(perfil);
                case 0 -> continuar = false;
            }
        }
    }

    /**
     * Guía al usuario para registrar una nueva actividad física.
     *
     * @param perfil Perfil del usuario.
     */
    private void registrarActividad(Perfil perfil) {
        Consola.separador();
        System.out.println("[> Registrar Actividad Física]");
        Consola.separador();

        LocalDate fecha = Consola.leerFecha("1. Ingrese la fecha de la actividad", true);

        ActividadFisica.TipoActividad tipo = seleccionarTipoActividad();
        int duracion = Consola.leerEnteroPositivo("3. Ingrese la duración (en minutos): ");
        ActividadFisica.Horario horario = seleccionarHorario();

        ActividadFisica actividad = new ActividadFisica(fecha, tipo, duracion, horario);
        perfil.getActividades().add(actividad);

        Consola.separador();
        System.out.println("PROCESANDO REGISTRO...");
        Consola.separador();
        Consola.exito("Actividad registrada correctamente en tus notas de salud:");
        Consola.detalle("Fecha: " + fecha.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        Consola.detalle("Actividad: " + tipo.getDescripcion());
        Consola.detalle("Duración: " + duracion + " minutos");
        Consola.detalle("Horario: " + horario.getDescripcion());
        Consola.separadorDoble();
        Consola.pausar();
    }

    /**
     * Solicita al usuario que seleccione el tipo de actividad.
     *
     * @return El tipo de actividad seleccionado.
     */
    private ActividadFisica.TipoActividad seleccionarTipoActividad() {
        ActividadFisica.TipoActividad[] tipos = ActividadFisica.TipoActividad.values();
        System.out.println("2. Tipo de actividad:");
        for (int i = 0; i < tipos.length; i++) {
            System.out.printf("   [%d] %s%n", i + 1, tipos[i].getDescripcion());
        }
        int sel = Consola.leerEntero("   Seleccione una opción (1-" + tipos.length + "): ", 1, tipos.length);
        return tipos[sel - 1];
    }

    /**
     * Solicita al usuario que seleccione el horario del día.
     *
     * @return El horario seleccionado.
     */
    private ActividadFisica.Horario seleccionarHorario() {
        ActividadFisica.Horario[] horarios = ActividadFisica.Horario.values();
        System.out.println("4. Horario:");
        for (int i = 0; i < horarios.length; i++) {
            System.out.printf("   [%d] %s%n", i + 1, horarios[i].getDescripcion());
        }
        int sel = Consola.leerEntero("   Seleccione una opción (1-" + horarios.length + "): ", 1, horarios.length);
        return horarios[sel - 1];
    }
}
