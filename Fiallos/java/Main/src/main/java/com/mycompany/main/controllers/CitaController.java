/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.controllers;

import com.mycompany.main.model.Cita;
import com.mycompany.main.model.Doctor;
import com.mycompany.main.model.Perfil;
import com.mycompany.main.util.Consola;
import com.mycompany.main.view.CitaView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

/**
 * Controlador para la gestión de citas médicas.
 * Coordina las operaciones entre el modelo {@link Cita} y la vista {@link CitaView}.
 *
 * @author Grupo
 * @version 1.0
 */
public class CitaController {

    private final CitaView vista;

    /** Constructor del controlador de citas. */
    public CitaController() {
        this.vista = new CitaView();
    }

    /**
     * Muestra el menú principal de gestión de citas.
     *
     * @param perfil Perfil activo del usuario.
     */
    public void mostrarMenu(Perfil perfil) {
        boolean continuar = true;
        while (continuar) {
            Consola.encabezado("3. Gestión de Citas Médicas");
            List<Cita> citasOrdenadas = perfil.getCitas().stream()
                    .sorted(Comparator.comparing(Cita::getFechaHora))
                    .toList();
            vista.mostrarListaCitas(citasOrdenadas);
            System.out.println();
            vista.mostrarMenuCitas();
            int opcion = Consola.leerEntero("> Seleccione una opción: ", 0, 2);
            switch (opcion) {
                case 1 -> programarCita(perfil);
                case 2 -> cancelarCita(perfil);
                case 0 -> continuar = false;
            }
        }
    }

    /**
     * Guía al usuario para programar una nueva cita médica.
     *
     * @param perfil Perfil del usuario.
     */
    private void programarCita(Perfil perfil) {
        if (perfil.getDoctores().isEmpty()) {
            Consola.error("No hay médicos registrados. Registre un médico primero.");
            Consola.pausar();
            return;
        }

        Consola.separador();
        System.out.println("[Gestión de Citas > Programar Nueva Cita]");
        Consola.separador();

        String titulo = Consola.leerTextoObligatorio("1. Título de la cita (ej: Consulta General): ");

        System.out.println("2. Seleccione el médico para la cita:");
        List<Doctor> doctores = perfil.getDoctores();
        for (int i = 0; i < doctores.size(); i++) {
            System.out.printf("   [%d] %s (%s)%n",
                    i + 1, doctores.get(i).getNombre(), doctores.get(i).getEspecialidad());
        }
        int selDoctor = Consola.leerEntero("   Seleccione el número de médico: ", 1, doctores.size());
        Doctor doctor = doctores.get(selDoctor - 1);

        LocalDate fecha = Consola.leerFecha("3. Ingrese la fecha de la cita", false);
        LocalTime hora  = Consola.leerHora("4. Ingrese la hora de la cita");
        LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);

        if (fechaHora.isBefore(LocalDateTime.now())) {
            Consola.advertencia("La fecha de la cita es en el pasado. ¿Desea continuar?");
            if (!Consola.confirmar("¿Confirmar?")) {
                System.out.println("Operación cancelada.");
                Consola.pausar();
                return;
            }
        }

        Cita cita = new Cita(titulo, doctor, fechaHora);
        perfil.getCitas().add(cita);

        Consola.separador();
        System.out.println("PROCESANDO CITA...");
        Consola.separador();
        Consola.exito("Cita programada correctamente:");
        Consola.detalle("ID: " + cita.getId());
        Consola.detalle("Título: " + titulo);
        Consola.detalle("Médico: " + doctor.getNombre());
        Consola.detalle("Horario: " + fechaHora.format(
                java.time.format.DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy 'a las' HH:mm",
                        new java.util.Locale("es"))));
        Consola.separadorDoble();
        Consola.pausar();
    }

    /**
     * Permite al usuario cancelar una cita futura.
     *
     * @param perfil Perfil del usuario.
     */
    private void cancelarCita(Perfil perfil) {
        List<Cita> futuras = perfil.getCitas().stream()
                .filter(Cita::esFutura)
                .toList();

        if (futuras.isEmpty()) {
            Consola.error("No hay citas futuras para cancelar.");
            Consola.pausar();
            return;
        }

        Consola.separador();
        System.out.println("[Gestión de Citas > Cancelar Cita Futura]");
        Consola.separador();
        vista.mostrarListaCitas(futuras);

        String id = Consola.leerTextoObligatorio("> Ingrese el ID de la cita a eliminar: ");
        Cita cita = futuras.stream()
                .filter(c -> c.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);

        if (cita == null) {
            Consola.error("ID no encontrado o la cita ya pasó.");
            Consola.pausar();
            return;
        }

        Consola.separador();
        System.out.println("¡CONFIRMACIÓN DE CANCELACIÓN!");
        Consola.separador();
        System.out.println("[Cita a eliminar]: " + cita.getId() + " - " + cita.getTitulo() +
                " con " + cita.getDoctor().getNombre());

        if (Consola.confirmar("¿Confirmar eliminación?")) {
            perfil.getCitas().remove(cita);
            Consola.exito("La cita \"" + cita.getId() + " - " + cita.getTitulo() + "\" ha sido cancelada.");
        } else {
            System.out.println("Operación cancelada.");
        }
        Consola.pausar();
    }
}