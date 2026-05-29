/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.view;

import com.mycompany.main.model.Perfil;
import com.mycompany.main.util.Consola;

import java.util.List;

/**
 * Vista para la gestión de perfiles de usuario.
 *
 * @author Grupo
 * @version 1.0
 */
public class PerfilView {

    /**
     * Muestra la pantalla de bienvenida con la lista de perfiles.
     *
     * @param perfiles Lista de perfiles registrados.
     */
    public void mostrarListaPerfiles(List<Perfil> perfiles) {
        Consola.separadorDoble();
        System.out.println(" SISTEMA DE CONTROL DE MEDICAMENTOS");
        Consola.separadorDoble();
        System.out.println("Perfiles disponibles:");
        Consola.separador();
        if (perfiles.isEmpty()) {
            System.out.println("  No hay perfiles registrados. Cree uno nuevo.");
        } else {
            for (Perfil p : perfiles) {
                System.out.println("  " + p);
            }
        }
        Consola.separador();
    }

    /**
     * Muestra las opciones principales de la pantalla de inicio.
     */
    public void mostrarOpcionesInicio() {
        System.out.println("Opciones:");
        System.out.println("[1] Crear perfil");
        System.out.println("[2] Seleccionar perfil");
        System.out.println("[0] Salir");
        Consola.separador();
    }

    /**
     * Muestra el menú principal para el perfil activo.
     *
     * @param perfil Perfil activo.
     */
    public void mostrarMenuPrincipal(Perfil perfil) {
        Consola.separadorDoble();
        System.out.println(" SISTEMA DE CONTROL DE MEDICAMENTOS | Perfil: " + perfil.getNombre());
        Consola.separadorDoble();
        System.out.println("[1] Administrar Medicamentos");
        System.out.println("[2] Administrar Médicos");
        System.out.println("[3] Administrar Citas Médicas");
        System.out.println("[4] Administrar Actividad Física");
        System.out.println("[5] Administrar Notas de Salud");
        System.out.println("[0] Cambiar / Regresar a Perfiles");
        Consola.separador();
    }
}
