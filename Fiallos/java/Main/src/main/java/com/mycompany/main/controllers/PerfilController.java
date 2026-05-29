/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.controllers;

import com.mycompany.main.model.Perfil;
import com.mycompany.main.util.Consola;
import com.mycompany.main.view.PerfilView;

import java.util.List;

/**
 * Controlador para la gestión de perfiles de usuario.
 * Coordina las operaciones entre el modelo {@link Perfil} y la vista {@link PerfilView}.
 *
 * @author Grupo
 * @version 1.0
 */
public class PerfilController {

    private final PerfilView vista;

    /** Constructor del controlador de perfiles. */
    public PerfilController() {
        this.vista = new PerfilView();
    }

    /**
     * Muestra la pantalla de inicio con la lista de perfiles.
     * Retorna el perfil seleccionado o recién creado.
     *
     * @param perfiles Lista de perfiles existentes.
     * @return El perfil con el que se trabajará, o null para salir.
     */
    public Perfil pantallaBienvenida(List<Perfil> perfiles) {
        while (true) {
            vista.mostrarListaPerfiles(perfiles);
            vista.mostrarOpcionesInicio();
            int opcion = Consola.leerEntero("> Seleccione una opción: ", 0, 2);
            switch (opcion) {
                case 1 -> { return crearPerfil(perfiles); }
                case 2 -> {
                    if (perfiles.isEmpty()) {
                        Consola.error("No hay perfiles registrados. Cree uno primero.");
                        Consola.pausar();
                    } else {
                        return seleccionarPerfil(perfiles);
                    }
                }
                case 0 -> { return null; }
            }
        }
    }

    /**
     * Guía al usuario para crear un nuevo perfil.
     *
     * @param perfiles Lista donde se agregará el nuevo perfil.
     * @return El perfil recién creado.
     */
    private Perfil crearPerfil(List<Perfil> perfiles) {
        Consola.encabezado("Crear Perfil");

        String nombre   = Consola.leerTextoObligatorio("Nombre del Usuario: ");
        String relacion = Consola.leerTextoObligatorio("Relación (ej: hijo, cónyuge, padre): ");
        String email    = Consola.leerTexto("Email (dejar en blanco si no aplica): ");

        Perfil perfil = new Perfil(nombre, relacion, email);
        perfiles.add(perfil);

        Consola.exito("Perfil creado para " + nombre + ".");
        Consola.pausar();
        return perfil;
    }

    /**
     * Permite al usuario seleccionar un perfil existente de la lista.
     *
     * @param perfiles Lista de perfiles disponibles.
     * @return El perfil seleccionado.
     */
    private Perfil seleccionarPerfil(List<Perfil> perfiles) {
        Consola.encabezado("Seleccionar Perfil");
        for (int i = 0; i < perfiles.size(); i++) {
            System.out.printf("[%d] %s%n", i + 1, perfiles.get(i).getNombre());
        }
        int sel = Consola.leerEntero("> Ingrese el número de perfil: ", 1, perfiles.size());
        return perfiles.get(sel - 1);
    }
}
