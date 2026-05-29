//Dirreccion
package espol.poo.controlador;
//Librerias
import java.util.ArrayList;
import java.util.Scanner;

import espol.poo.modelo.CitasMedicas;
import espol.poo.modelo.Medicos;
import espol.poo.modelo.Perfil;
import espol.poo.vista.VistaCitasMedicas;
//funciones
public abstract class ControladorCitasMedicas {
    //funcion MostrarMenuCitasMedicas
    public static void MostrarMenuCitasMedicas(){
        System.out.println("Ingrese que desea realizar \n1. Revisar Listado de citas\n2. Agregar cita\n3. Salir");
    }
    //funcion MostrarCitasMedicas
    public static void MostrarCitasMedicas(ArrayList<CitasMedicas> citas , Perfil UsuarioIngresado){
        VistaCitasMedicas.mostrarCitasMedicas(citas, UsuarioIngresado);
    }
    //funcion AgregarCitaMedica
    public static void AgregarCitaMedica(ArrayList<CitasMedicas> citas,ArrayList<Medicos> medicos , Perfil UsuarioIngresado) {
        Scanner grabar = new Scanner(System.in);
        System.out.println("Ingrese el titulo de la consulta:");
        String titulo = grabar.nextLine();
        System.out.println("Ingrese el medico para la consulta");
        ControladorMedicos.MostrarMedicos(medicos);
        int indicedoc = grabar.nextInt();
        grabar.nextLine();
        System.out.println("Ingrese la fecha y hora de la consulta DD/MM/AAAA_HH:MM :");
        String fecha = grabar.nextLine();
        CitasMedicas cita = new CitasMedicas(titulo, medicos.get(indicedoc - 1), fecha, UsuarioIngresado);
        citas.add(0, cita);
        System.out.println("Se ha registrado una cita con el doctor " + medicos.get(indicedoc - 1).getNombre() + " La fecha: " + fecha);
    }

}
