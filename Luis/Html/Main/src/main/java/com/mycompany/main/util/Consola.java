/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Clase utilitaria para la interacción con la consola.
 * Provee métodos para mostrar encabezados, separadores y leer entradas validadas.
 *
 * @author Grupo
 * @version 1.0
 */
public class Consola {

    /** Ancho estándar de la línea de separación */
    public static final int ANCHO = 70;

    /** Línea de separación simple */
    public static final String LINEA = "=".repeat(ANCHO);

    /** Línea de separación punteada */
    public static final String LINEA_PUNT = "-".repeat(ANCHO);

    private static final DateTimeFormatter FMT_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FMT_HORA  = DateTimeFormatter.ofPattern("HH:mm");
    private static final Scanner scanner = new Scanner(System.in);

    // ── Visualización ─────────────────────────────────────────────────────────

    /**
     * Imprime un encabezado de sección.
     *
     * @param titulo Título a mostrar dentro del encabezado.
     */
    public static void encabezado(String titulo) {
        System.out.println(LINEA);
        System.out.println(" SISTEMA DE CONTROL DE MEDICAMENTOS (Versión 1.0)");
        System.out.println(LINEA);
        System.out.println("[" + titulo + "]");
        System.out.println(LINEA_PUNT);
    }

    /**
     * Imprime una línea de separación completa.
     */
    public static void separador() {
        System.out.println(LINEA_PUNT);
    }

    /**
     * Imprime una línea de separación doble.
     */
    public static void separadorDoble() {
        System.out.println(LINEA);
    }

    /**
     * Muestra el mensaje de éxito con formato.
     *
     * @param mensaje Mensaje a mostrar.
     */
    public static void exito(String mensaje) {
        System.out.println("\n¡Éxito! " + mensaje);
    }

    /**
     * Muestra una advertencia con formato.
     *
     * @param mensaje Mensaje de advertencia.
     */
    public static void advertencia(String mensaje) {
        System.out.println("\n¡ADVERTENCIA! " + mensaje);
    }

    /**
     * Muestra un error con formato.
     *
     * @param mensaje Mensaje de error.
     */
    public static void error(String mensaje) {
        System.out.println("\n[ERROR] " + mensaje);
    }

    /**
     * Pausa la ejecución hasta que el usuario presione ENTER.
     */
    public static void pausar() {
        System.out.print("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }

    // ── Lectura de entradas ───────────────────────────────────────────────────

    /**
     * Lee una línea de texto desde la consola.
     *
     * @param prompt Mensaje a mostrar antes de la entrada.
     * @return Texto ingresado por el usuario (puede estar vacío).
     */
    public static String leerTexto(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Lee una línea de texto no vacía desde la consola.
     *
     * @param prompt Mensaje a mostrar antes de la entrada.
     * @return Texto ingresado por el usuario (no vacío).
     */
    public static String leerTextoObligatorio(String prompt) {
        String valor;
        do {
            System.out.print(prompt);
            valor = scanner.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.println("  Este campo es obligatorio. Intente nuevamente.");
            }
        } while (valor.isEmpty());
        return valor;
    }

    /**
     * Lee un número entero dentro de un rango dado.
     *
     * @param prompt Mensaje a mostrar.
     * @param min    Valor mínimo aceptado.
     * @param max    Valor máximo aceptado.
     * @return Número entero ingresado.
     */
    public static int leerEntero(String prompt, int min, int max) {
        int valor;
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            try {
                valor = Integer.parseInt(entrada);
                if (valor >= min && valor <= max) return valor;
                System.out.printf("  Ingrese un número entre %d y %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("  Entrada inválida. Ingrese un número.");
            }
        }
    }

    /**
     * Lee un número entero positivo.
     *
     * @param prompt Mensaje a mostrar.
     * @return Número entero positivo.
     */
    public static int leerEnteroPositivo(String prompt) {
        return leerEntero(prompt, 1, Integer.MAX_VALUE);
    }

    /**
     * Lee una fecha en formato DD/MM/YYYY.
     *
     * @param prompt   Mensaje a mostrar.
     * @param soloSoloPassado true si la fecha no puede ser futura.
     * @return LocalDate ingresada.
     */
    public static LocalDate leerFecha(String prompt, boolean soloSoloPassado) {
        while (true) {
            System.out.print(prompt + " (DD/MM/AAAA): ");
            String entrada = scanner.nextLine().trim();
            try {
                LocalDate fecha = LocalDate.parse(entrada, FMT_FECHA);
                if (soloSoloPassado && fecha.isAfter(LocalDate.now())) {
                    System.out.println("  La fecha no puede ser futura. Intente nuevamente.");
                    continue;
                }
                return fecha;
            } catch (DateTimeParseException e) {
                System.out.println("  Formato inválido. Use DD/MM/AAAA (ej: 27/05/2026).");
            }
        }
    }

    /**
     * Lee una hora en formato HH:MM.
     *
     * @param prompt Mensaje a mostrar.
     * @return LocalTime ingresada.
     */
    public static LocalTime leerHora(String prompt) {
        while (true) {
            System.out.print(prompt + " (HH:MM): ");
            String entrada = scanner.nextLine().trim();
            try {
                return LocalTime.parse(entrada, FMT_HORA);
            } catch (DateTimeParseException e) {
                System.out.println("  Formato inválido. Use HH:MM en formato 24h (ej: 08:00).");
            }
        }
    }

    /**
     * Lee una fecha y hora combinadas.
     *
     * @param promptFecha Mensaje para la fecha.
     * @param promptHora  Mensaje para la hora.
     * @return LocalDateTime resultante.
     */
    public static LocalDateTime leerFechaHora(String promptFecha, String promptHora) {
        LocalDate fecha = leerFecha(promptFecha, false);
        LocalTime hora  = leerHora(promptHora);
        return LocalDateTime.of(fecha, hora);
    }

    /**
     * Solicita confirmación S/N al usuario.
     *
     * @param prompt Mensaje de confirmación.
     * @return true si el usuario confirmó con 'S' o 's'.
     */
    public static boolean confirmar(String prompt) {
        while (true) {
            System.out.print(prompt + " (S/N): ");
            String resp = scanner.nextLine().trim().toUpperCase();
            if (resp.equals("S")) return true;
            if (resp.equals("N")) return false;
            System.out.println("  Por favor ingrese S para Sí o N para No.");
        }
    }

    /**
     * Imprime un detalle con prefijo '->'.
     *
     * @param texto Detalle a mostrar.
     */
    public static void detalle(String texto) {
        System.out.println("-> " + texto);
    }
}
