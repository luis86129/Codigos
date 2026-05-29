/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.util;

import com.mycompany.main.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Clase utilitaria para inicializar los datos de prueba del sistema.
 * Carga un perfil, medicamento, actividad, doctor, cita y nota predeterminados.
 *
 * @author Grupo
 * @version 1.0
 */
public class DataInitializer {

    /**
     * Crea y retorna la lista de perfiles con datos precargados.
     *
     * @return Lista con un perfil cargado con datos de ejemplo.
     */
    public static java.util.List<Perfil> inicializar() {
        java.util.List<Perfil> perfiles = new java.util.ArrayList<>();

        // ── Perfil inicial ─────────────────────────────────────────────────────
        Perfil perfil = new Perfil("Gladys Carrillo", "Titular", "gladys@example.com");

        // ── 1 Medicamento: pastilla diaria a las 08:00 con 30 unidades ─────────
        Medicamento med = new Medicamento(
                "Paracetamol",
                30,
                Medicamento.Presentacion.PASTILLA,
                Medicamento.TipoFrecuencia.CADA_DIA,
                "",
                Medicamento.TomasDiarias.UNA,
                List.of("08:00"),
                "1 pastilla"
        );
        med.setUmbralAlerta(5);
        perfil.getMedicamentos().add(med);

        // ── 1 Doctor ──────────────────────────────────────────────────────────
        Doctor doctor = new Doctor(
                "Dr. Carlos Mendoza",
                "Medicina General",
                "+593 98 765 4321",
                "c.mendoza@clinica.com",
                "Av. Principal 123"
        );
        perfil.getDoctores().add(doctor);

        // ── 1 Cita (futura) ───────────────────────────────────────────────────
        Cita cita = new Cita(
                "Chequeo Semestral",
                doctor,
                LocalDateTime.of(
                        LocalDate.now().plusDays(10),
                        java.time.LocalTime.of(15, 0)
                )
        );
        perfil.getCitas().add(cita);

        // ── 1 Actividad Física ────────────────────────────────────────────────
        ActividadFisica actividad = new ActividadFisica(
                LocalDate.now().minusDays(1),
                ActividadFisica.TipoActividad.CAMINAR,
                45,
                ActividadFisica.Horario.MANANA
        );
        perfil.getActividades().add(actividad);

        // ── 1 Nota de Salud ───────────────────────────────────────────────────
        NotaSalud nota = new NotaSalud(
                LocalDateTime.now().minusDays(1),
                "Leve dolor de cabeza al despertar."
        );
        perfil.getNotas().add(nota);

        perfiles.add(perfil);
        return perfiles;
    }
}