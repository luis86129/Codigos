/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.controllers;

import com.mycompany.main.model.Doctor;
import com.mycompany.main.model.Perfil;
import com.mycompany.main.util.Consola;
import com.mycompany.main.view.DoctorView;

import java.util.List;

/**
 * Controlador para la gestión de médicos.
 * Coordina las operaciones entre el modelo {@link Doctor} y la vista {@link DoctorView}.
 *
 * @author Grupo
 * @version 1.0
 */
public class DoctorController {

    private final DoctorView vista;

    /** Constructor del controlador de médicos. */
    public DoctorController() {
        this.vista = new DoctorView();
    }

    /**
     * Muestra el menú principal de gestión de médicos.
     *
     * @param perfil Perfil activo del usuario.
     */
    public void mostrarMenu(Perfil perfil) {
        boolean continuar = true;
        while (continuar) {
            Consola.encabezado("2. Gestión de Médicos");
            vista.mostrarListaDoctores(perfil.getDoctores());
            System.out.println();
            vista.mostrarMenuDoctores();
            int opcion = Consola.leerEntero("> Seleccione una opción: ", 0, 2);
            switch (opcion) {
                case 1 -> agregarDoctor(perfil);
                case 2 -> eliminarDoctor(perfil);
                case 0 -> continuar = false;
            }
        }
    }

    /**
     * Guía al usuario para agregar un nuevo médico al perfil.
     *
     * @param perfil Perfil del usuario.
     */
    private void agregarDoctor(Perfil perfil) {
        Consola.separador();
        System.out.println("[Gestión de Médicos > Agregar Médico]");
        Consola.separador();

        String nombre       = Consola.leerTextoObligatorio("1. Nombre Completo: ");
        String especialidad = Consola.leerTextoObligatorio("2. Especialidad: ");
        String telefono     = Consola.leerTextoObligatorio("3. Número de Teléfono: ");
        String email        = Consola.leerTexto("4. Correo Electrónico (opcional): ");
        String direccion    = Consola.leerTextoObligatorio("5. Dirección de la Consulta: ");

        Doctor doctor = new Doctor(nombre, especialidad, telefono, email, direccion);
        perfil.getDoctores().add(doctor);

        Consola.exito(nombre + " ha sido registrado con el ID " + doctor.getId() + ".");
        Consola.separadorDoble();
        Consola.pausar();
    }

    /**
     * Permite al usuario seleccionar y eliminar un médico.
     *
     * @param perfil Perfil del usuario.
     */
    private void eliminarDoctor(Perfil perfil) {
        if (perfil.getDoctores().isEmpty()) {
            Consola.error("No hay médicos registrados.");
            Consola.pausar();
            return;
        }

        Consola.separador();
        System.out.println("[Gestión de Médicos > Eliminar Médico]");
        Consola.separador();

        String id = Consola.leerTextoObligatorio("> Ingrese el ID del médico a eliminar: ");
        Doctor doctor = buscarPorId(perfil.getDoctores(), id);

        if (doctor == null) {
            Consola.error("ID no encontrado.");
            Consola.pausar();
            return;
        }

        if (Consola.confirmar("¿Está seguro de que desea eliminar a " + doctor.getNombre() + "?")) {
            // Verificar si tiene citas asociadas
            boolean tieneCitas = perfil.getCitas().stream()
                    .anyMatch(c -> c.getDoctor().getId().equals(doctor.getId()));
            if (tieneCitas) {
                Consola.advertencia("Este médico tiene citas asociadas. Elimínelas primero.");
                Consola.pausar();
                return;
            }
            perfil.getDoctores().remove(doctor);
            Consola.exito("El registro del médico ha sido removido.");
        } else {
            System.out.println("Operación cancelada.");
        }
        Consola.pausar();
    }

    /**
     * Busca un doctor por su ID en la lista.
     *
     * @param lista Lista de doctores.
     * @param id    ID a buscar.
     * @return El doctor encontrado, o null si no existe.
     */
    private Doctor buscarPorId(List<Doctor> lista, String id) {
        return lista.stream()
                .filter(d -> d.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Retorna la lista de doctores del perfil (para uso en otros controladores).
     *
     * @param perfil Perfil del usuario.
     * @return Lista de doctores.
     */
    public List<Doctor> getDoctores(Perfil perfil) {
        return perfil.getDoctores();
    }
}