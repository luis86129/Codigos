//direccion
package espol.poo.controlador;
//librerias
import java.util.ArrayList;
import java.util.Scanner;

import espol.poo.modelo.Medicos;
import espol.poo.vista.VistaMedicos;
//funciones
public abstract class ControladorMedicos {
    //funcion MostrarMenuMedicos
    public static void MostrarMenuMedicos() {
        System.out.println("Ingrese que desea realizar: \n1. Listado de Médicos\n2. Añadir Médico\n3. Salir");
    }
    //funcion AgregarMedico
    public static void AgregarMedico(ArrayList<Medicos> listaMedicos) {
        Scanner grabar = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Medico: ");
        String nombre = grabar.nextLine();
        System.out.println("Ingrese la especialidad del medico: ");
        String especialidad = grabar.nextLine();
        System.out.println("Ingrese el telefono del medico: ");
        int telefono = grabar.nextInt();
        grabar.nextLine();
        System.out.println("Ingrese el Correo electronico del medico: ");
        String correo = grabar.nextLine();
        System.out.println("Ingrese la direccion de la consulta medica: ");
        String direccion = grabar.nextLine();
        Medicos e = new Medicos(nombre, especialidad, telefono, correo, direccion);
        listaMedicos.add(e);

    }
    //funcion MostrarMedicos
    public static void MostrarMedicos(ArrayList<Medicos> listaMedicos){
        VistaMedicos.ImprimirMedicos(listaMedicos);
    }
}
