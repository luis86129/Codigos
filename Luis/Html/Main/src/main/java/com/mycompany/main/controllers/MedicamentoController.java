/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.controllers;


import com.mycompany.main.model.*;
import com.mycompany.main.util.Consola;
import com.mycompany.main.view.MedicamentoView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la gestión de medicamentos.
 * Coordina las operaciones entre el modelo {@link Medicamento} y la vista {@link MedicamentoView}.
 *
 * @author Grupo
 * @version 1.0
 */
public class MedicamentoController {

    private final MedicamentoView vista;

    /** Constructor del controlador de medicamentos. */
    public MedicamentoController() {
        this.vista = new MedicamentoView();
    }

    /**
     * Muestra el menú principal de administración de medicamentos.
     *
     * @param perfil Perfil activo del usuario.
     */
    public void mostrarMenu(Perfil perfil) {
        boolean continuar = true;
        while (continuar) {
            vista.mostrarMenuMedicamentos();
            int opcion = Consola.leerEntero("> Seleccione una opción: ", 0, 6);
            switch (opcion) {
                case 1 -> listarMedicamentos(perfil);
                case 2 -> agregarMedicamento(perfil);
                case 3 -> eliminarMedicamento(perfil);
                case 4 -> registrarToma(perfil);
                case 5 -> recargarMedicamento(perfil);
                case 6 -> configurarRecordatorio(perfil);
                case 0 -> continuar = false;
            }
        }
    }

    /**
     * Lista todos los medicamentos activos del perfil.
     *
     * @param perfil Perfil del usuario.
     */
    private void listarMedicamentos(Perfil perfil) {
        vista.mostrarListaMedicamentos(perfil.getMedicamentos());
        Consola.pausar();
    }

    /**
     * Guía al usuario para agregar un nuevo medicamento al perfil.
     *
     * @param perfil Perfil del usuario.
     */
    private void agregarMedicamento(Perfil perfil) {
        Consola.encabezado("1.2. Añadir Medicina");

        String nombre = Consola.leerTextoObligatorio("1. Nombre del Medicamento: ");

        int stock = Consola.leerEnteroPositivo("2. Cantidad de unidades disponibles (inventario): ");

        Medicamento.Presentacion presentacion = seleccionarPresentacion();

        Medicamento.TipoFrecuencia tipoFrecuencia = seleccionarTipoFrecuencia();
        String detalleFrecuencia = leerDetalleFrecuencia(tipoFrecuencia);

        Medicamento.TomasDiarias tomasDiarias = seleccionarTomasDiarias();
        List<String> horarios = leerHorarios(tomasDiarias.getCantidad());

        String dosis = Consola.leerTextoObligatorio("7. Dosis por toma (ej: 1 pastilla, 5ml): ");

        Medicamento med = new Medicamento(nombre, stock, presentacion,
                tipoFrecuencia, detalleFrecuencia, tomasDiarias, horarios, dosis);
        perfil.getMedicamentos().add(med);

        Consola.separador();
        System.out.println("PROCESANDO REGISTRO...");
        Consola.separador();
        Consola.exito("El medicamento ha sido registrado correctamente:");
        Consola.detalle("Medicina: " + nombre + " (" + stock + " unidades en inventario)");
        Consola.detalle("Presentación: " + presentacion.getDescripcion());
        Consola.detalle("Horarios: " + String.join(", ", horarios) + " (Dosis: " + dosis + ")");
        Consola.separadorDoble();
        Consola.pausar();
    }

    /**
     * Permite al usuario seleccionar y eliminar un medicamento.
     *
     * @param perfil Perfil del usuario.
     */
    private void eliminarMedicamento(Perfil perfil) {
        if (perfil.getMedicamentos().isEmpty()) {
            Consola.error("No hay medicamentos registrados.");
            Consola.pausar();
            return;
        }
        Consola.encabezado("1.3. Eliminar Medicina");
        vista.mostrarListaSimple(perfil.getMedicamentos());

        String id = Consola.leerTextoObligatorio("> Ingrese el ID del medicamento a eliminar: ");
        Medicamento med = buscarPorId(perfil.getMedicamentos(), id);

        if (med == null) {
            Consola.error("ID no encontrado.");
            Consola.pausar();
            return;
        }

        Consola.separador();
        System.out.println("¡ADVERTENCIA: ESTA ACCIÓN NO SE PUEDE DESHACER!");
        Consola.separador();
        System.out.println("[Medicina Seleccionada]: " + med.getId() + " - " + med.getNombre());

        if (Consola.confirmar("¿Confirmar eliminación?")) {
            perfil.getMedicamentos().remove(med);
            Consola.exito("El medicamento \"" + med.getNombre() + "\" ha sido removido del sistema.");
        } else {
            System.out.println("Operación cancelada.");
        }
        Consola.pausar();
    }

    /**
     * Permite al usuario registrar la toma de un medicamento.
     *
     * @param perfil Perfil del usuario.
     */
    private void registrarToma(Perfil perfil) {
        if (perfil.getMedicamentos().isEmpty()) {
            Consola.error("No hay medicamentos registrados.");
            Consola.pausar();
            return;
        }
        Consola.encabezado("1.4. Registrar Toma");
        vista.mostrarListaParaToma(perfil.getMedicamentos());

        String id = Consola.leerTextoObligatorio("> Ingrese el ID del medicamento tomado: ");
        Medicamento med = buscarPorId(perfil.getMedicamentos(), id);

        if (med == null) {
            Consola.error("ID no encontrado.");
            Consola.pausar();
            return;
        }

        LocalDateTime fechaHora;
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("\nMedicamento: " + med.getNombre() + " (Dosis: " + med.getDosis() + ")");
        System.out.printf("[Fecha actual: %s | Hora actual: %s]%n",
                ahora.toLocalDate().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                ahora.toLocalTime().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));

        if (Consola.confirmar("¿Registrar con la fecha y hora actual?")) {
            fechaHora = ahora;
        } else {
            LocalDate fecha = Consola.leerFecha("> Ingrese la fecha de la toma", false);
            LocalTime hora  = Consola.leerHora("> Ingrese la hora de la toma");
            fechaHora = LocalDateTime.of(fecha, hora);
        }

        med.registrarToma(fechaHora);
        Consola.separador();
        Consola.exito("Toma registrada correctamente.");
        Consola.detalle("Detalles: " + med.getNombre() + " tomado el " +
                fechaHora.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " a las " + fechaHora.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")) + ".");
        Consola.detalle("Nuevo stock disponible: " + med.getStock() + " unidades.");

        if (med.necesitaRecarga()) {
            System.out.println("\n  [ALERTA] Stock bajo. Considere recargar " + med.getNombre() + ".");
        }
        Consola.pausar();
    }

    /**
     * Permite al usuario recargar el inventario de un medicamento.
     *
     * @param perfil Perfil del usuario.
     */
    private void recargarMedicamento(Perfil perfil) {
        if (perfil.getMedicamentos().isEmpty()) {
            Consola.error("No hay medicamentos registrados.");
            Consola.pausar();
            return;
        }
        Consola.encabezado("1.5. Recarga de Medicina");
        vista.mostrarInventario(perfil.getMedicamentos());

        String id = Consola.leerTextoObligatorio("> Ingrese el ID del medicamento a recargar: ");
        Medicamento med = buscarPorId(perfil.getMedicamentos(), id);

        if (med == null) {
            Consola.error("ID no encontrado.");
            Consola.pausar();
            return;
        }

        System.out.println("\nMedicamento: " + med.getNombre() + " (Stock actual: " + med.getStock() + " unidades)");
        int cantidad = Consola.leerEnteroPositivo("> Ingrese la cantidad a agregar: ");

        if (Consola.confirmar("¿Confirmar el ingreso de " + cantidad + " unidades a " + med.getNombre() + "?")) {
            med.recargar(cantidad);
            Consola.exito("Inventario actualizado correctamente.");
            Consola.detalle("Se agregaron " + cantidad + " unidades a " + med.getNombre() + ".");
            Consola.detalle("Nuevo stock total disponible: " + med.getStock() + " unidades.");
        } else {
            System.out.println("Operación cancelada.");
        }
        Consola.pausar();
    }

    /**
     * Configura el umbral de alerta de stock de un medicamento.
     *
     * @param perfil Perfil del usuario.
     */
    private void configurarRecordatorio(Perfil perfil) {
        if (perfil.getMedicamentos().isEmpty()) {
            Consola.error("No hay medicamentos registrados.");
            Consola.pausar();
            return;
        }
        Consola.encabezado("1.6. Recordatorio de Recarga");
        vista.mostrarConfiguracionAlertas(perfil.getMedicamentos());

        String id = Consola.leerTextoObligatorio("> Ingrese el ID del medicamento: ");
        Medicamento med = buscarPorId(perfil.getMedicamentos(), id);

        if (med == null) {
            Consola.error("ID no encontrado.");
            Consola.pausar();
            return;
        }

        System.out.println("\nMedicamento: " + med.getNombre() + " (Stock actual: " + med.getStock() + " unidades)");
        int umbral = Consola.leerEnteroPositivo("> Ingrese la cantidad mínima (umbral) para la alerta: ");

        if (Consola.confirmar("¿Confirmar alerta cuando " + med.getNombre() + " tenga " + umbral + " unidades o menos?")) {
            med.setUmbralAlerta(umbral);
            Consola.exito("Recordatorio configurado correctamente.");
            Consola.detalle(med.getNombre() + " activará alerta cuando stock sea <= " + umbral + " unidades.");
        } else {
            System.out.println("Operación cancelada.");
        }
        Consola.pausar();
    }

    // ── Helpers de selección ──────────────────────────────────────────────────

    private Medicamento.Presentacion seleccionarPresentacion() {
        Medicamento.Presentacion[] opciones = Medicamento.Presentacion.values();
        System.out.println("\n3. Presentación:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.printf("   [%d] %s%n", i + 1, opciones[i].getDescripcion());
        }
        int sel = Consola.leerEntero("   Seleccione una opción (1-" + opciones.length + "): ", 1, opciones.length);
        return opciones[sel - 1];
    }

    private Medicamento.TipoFrecuencia seleccionarTipoFrecuencia() {
        Medicamento.TipoFrecuencia[] opciones = Medicamento.TipoFrecuencia.values();
        System.out.println("\n4. Frecuencia de consumo:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.printf("   [%d] %s%n", i + 1, opciones[i].getDescripcion());
        }
        int sel = Consola.leerEntero("   Seleccione una opción (1-" + opciones.length + "): ", 1, opciones.length);
        return opciones[sel - 1];
    }

    private String leerDetalleFrecuencia(Medicamento.TipoFrecuencia tipo) {
        return switch (tipo) {
            case DIAS_ESPECIFICOS ->
                Consola.leerTextoObligatorio("   > Seleccione días (ej: L,Mi,V): ");
            case CADA_X_DIAS ->
                String.valueOf(Consola.leerEnteroPositivo("   > Cada cuántos días: "));
            case CADA_X_SEMANAS ->
                String.valueOf(Consola.leerEnteroPositivo("   > Cada cuántas semanas: "));
            case CADA_X_MESES ->
                String.valueOf(Consola.leerEnteroPositivo("   > Cada cuántos meses: "));
            default -> "";
        };
    }

    private Medicamento.TomasDiarias seleccionarTomasDiarias() {
        Medicamento.TomasDiarias[] opciones = Medicamento.TomasDiarias.values();
        System.out.println("\n5. Frecuencia del Día:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.printf("   [%d] %s%n", i + 1, opciones[i].getDescripcion());
        }
        int sel = Consola.leerEntero("   Seleccione una opción (1-" + opciones.length + "): ", 1, opciones.length);
        return opciones[sel - 1];
    }

    private List<String> leerHorarios(int cantidad) {
        List<String> horarios = new ArrayList<>();
        System.out.println("\n6. Configuración de Horarios (Formato 24h):");
        for (int i = 1; i <= cantidad; i++) {
            LocalTime hora = Consola.leerHora("   > Hora para la Toma " + i);
            horarios.add(hora.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));
        }
        return horarios;
    }

    /**
     * Busca un medicamento por su ID dentro de una lista.
     *
     * @param lista Lista de medicamentos.
     * @param id    ID a buscar.
     * @return El medicamento encontrado o null si no existe.
     */
    private Medicamento buscarPorId(List<Medicamento> lista, String id) {
        return lista.stream()
                .filter(m -> m.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}