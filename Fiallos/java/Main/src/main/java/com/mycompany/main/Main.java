/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

import com.mycompany.main.controllers.*;
import com.mycompany.main.model.Perfil;
import com.mycompany.main.util.Consola;
import com.mycompany.main.util.DataInitializer;
import com.mycompany.main.view.PerfilView;

import java.util.List;

/**
 * Clase principal del Sistema de Control de Medicamentos.
 * Punto de entrada de la aplicación. Inicializa datos y lanza el menú principal.
 *
 * @author Grupo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        // Cargar datos iniciales
        List<Perfil> perfiles = DataInitializer.inicializar();

        // Instanciar controladores
        PerfilController perfilController     = new PerfilController();
        MedicamentoController medController   = new MedicamentoController();
        DoctorController doctorController     = new DoctorController();
        CitaController citaController         = new CitaController();
        ActividadController actividadController = new ActividadController();
        NotaSaludController notaController    = new NotaSaludController();

        PerfilView perfilView = new PerfilView();

        boolean ejecutando = true;

        while (ejecutando) {
            // Pantalla de selección de perfil
            Perfil perfilActivo = perfilController.pantallaBienvenida(perfiles);

            if (perfilActivo == null) {
                ejecutando = false;
                break;
            }

            // Menú principal del perfil seleccionado
            boolean enPerfil = true;
            while (enPerfil) {
                perfilView.mostrarMenuPrincipal(perfilActivo);
                int opcion = Consola.leerEntero("> Seleccione una opción: ", 0, 5);

                switch (opcion) {
                    case 1 -> medController.mostrarMenu(perfilActivo);
                    case 2 -> doctorController.mostrarMenu(perfilActivo);
                    case 3 -> citaController.mostrarMenu(perfilActivo);
                    case 4 -> actividadController.mostrarMenu(perfilActivo);
                    case 5 -> notaController.mostrarMenu(perfilActivo);
                    case 0 -> enPerfil = false;
                }
            }
        }

        Consola.separadorDoble();
        System.out.println("  Gracias por usar el Sistema de Control de Medicamentos.");
        Consola.separadorDoble();
    }
}