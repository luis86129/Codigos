//Direccion
package espol.poo.controlador;
//librerias
import java.util.ArrayList;
import java.util.Scanner;

import espol.poo.modelo.ActividadFisica;
import espol.poo.modelo.Perfil;
import espol.poo.vista.VistaActividadFisica;
//funciones
public abstract class ControladorActividadFisica {
    //funcion MostrarMenuActividadFisica
    public static void MostrarMenuActividadFisica() {
        System.out.println("Ingrese que desea realizar:\n1. Listado de actividades\n2. Registrar Actividad Física\n3. Salir");
    }
    //funcion mostrarActividadFisica
    public static void mostrarActividadFisica(ArrayList<ActividadFisica> actividadFisicas , Perfil usuarioIngresado){
        VistaActividadFisica.mostrarActividadFisica(actividadFisicas, usuarioIngresado);
    }
    //funcion AgregarActividadFisica
    public static void AgregarActividadFisica(ArrayList<ActividadFisica> actividadFisicas , Perfil usuarioIngresado) {
        Scanner grabar = new Scanner(System.in);
        System.out.println("Ingrese la fecha en la que se realizo la actividad DD/MM/AAAA: ");
        String Fecha = grabar.nextLine();
        System.out.println("Ingrese la actividad fisica que realizo: \nCaminar\nTrotar\nCorrer\nFuncional\nCrossfit\nEntrenamiento de pesas\nNadar");
        String actividad = grabar.nextLine();
        System.out.println("Ingrese la Duracion (en minutos) de la actividad fisica: ");
        int duracionMinutos = grabar.nextInt();
        grabar.nextLine();
        System.out.println("Ingrese cuando se realizo la activida:\nMañana\nTarde\nNoche");
        String cuando = grabar.nextLine();
        ActividadFisica actividadRealizada = new ActividadFisica(Fecha, actividad, duracionMinutos, cuando, usuarioIngresado);
        actividadFisicas.add(0, actividadRealizada);
    }
}
