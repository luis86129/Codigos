//direccion
package espol.poo.controlador;
//librerias
import java.lang.reflect.Array;
import java.util.ArrayList;

//archivos usados
import espol.poo.modelo.*;
import espol.poo.vista.*;
import java.util.Scanner;

//funciones
public abstract class ControladorMedicinas {
    //funcion AgregarMedicina
    public static void AgregarMedicina(ArrayList<Medicina> medicinas , Perfil perfil){
        Scanner grabar = new Scanner(System.in);
        System.out.println("Ingrese el nombre del medicamento:");
        String nombreMedicamento = grabar.next();
        System.out.println("Ingrese la cantidad de unidades disponible en el inventario:");
        int cantidadInventario = grabar.nextInt();
        grabar.nextLine();
        System.out.println("Ingrese la presentacion del medicamento ejemplo\nPastilla\nInyección\nSolución\nGotas\nInhalador\nPolvo");
        String presentacionMedicina = grabar.nextLine();
        System.out.println("Ingrese la frecuencia Cada día\nCada dos días\nDías específicos de la semana (seleccionar días L Ma Mi J V)\nCada x días\nCada x semanas\nCada x meses");
        String frecuencioMedicamento = grabar.nextLine();
        System.out.println("Ingrese la frecuencia por dia (numero) \n1 al día\n2 al día\n3 al día");
        int frecuenciaMedicamentoDia = grabar.nextInt();
        grabar.nextLine();
        System.out.println("Ingrese las horas de consumo hh:mm (ingrese todos los horarios):");
        String horario = grabar.nextLine();
        System.out.println("ingrese las dosis por cada toma:");
        int dosis = grabar.nextInt();
        grabar.nextLine();
        Medicina medicina = new Medicina(nombreMedicamento , cantidadInventario , presentacionMedicina ,frecuencioMedicamento,frecuenciaMedicamentoDia,horario,dosis,perfil);
        medicinas.add(medicina);
    }
    //funcion ElegirOpcionesMedicinas
    public static void ElegirOpcionesMedicinas(){
        System.out.println("Ingrese que desea realizar:\n1. Lista de Medicamentos activos\n2. Añadir Medicina\n3. Eliminar Medicina\n4. Registrar Toma\n5. Salir");

    }
    //funcion MostrarMedicinas
    public static void MostrarMedicinas(ArrayList<Medicina> medicinas){
        VistaMedicinas.mostrarMedicinas(medicinas);
    }
    //funcion ELiminarMedicina
    public static void ELiminarMedicina(ArrayList<Medicina> medicinas , ArrayList<Perfil> perfiles , Perfil perfil){
        Scanner grabar = new Scanner(System.in);
        System.out.println("Ingrese el medicamento a eliminar");
        int num1 = 1;
        ArrayList<Medicina> listaUsuario = new ArrayList<Medicina>();
        for (Medicina m : medicinas) {
            if (m.getPerfil() == perfil){
            listaUsuario.add(m);
            }
        }
        ControladorMedicinas.MostrarMedicinas(listaUsuario);
        int indice = grabar.nextInt();
        System.err.println("Confirme que desea eliminar el medicamento: " + indice + "\n1. Si (Eliminar) \n2. No (Volver al menu)");
        int confimacion = grabar.nextInt();
        grabar.nextLine();
        if (confimacion == 1) {
        int valor1 = 0;
        for (Medicina elem : medicinas) {
        if (elem.equals(listaUsuario.get(indice - 1))){
            medicinas.remove(valor1);
            break;
            }
        valor1 ++ ;
        }                                
        }
    }
    //funcion mostrarMedicinas
    public static void RegistrarToma(Perfil UsuarioIngresado , ArrayList<Medicina> medicinas){
        Scanner grabar = new Scanner(System.in);
        System.out.println("seleccione un medicamento a tomar: ");
        ArrayList<Medicina> listaUsuario = new ArrayList<Medicina>();
        for (Medicina m : medicinas){
            if (m.getPerfil() == UsuarioIngresado){
                listaUsuario.add(m);
            }
        }
        VistaMedicinas.mostrarMedicinas(listaUsuario);
        int tomar = grabar.nextInt();
        grabar.nextLine();
        System.out.println("Ingrese la fecha y hora de la toma: ");
        String fecha = grabar.nextLine();
        System.err.println("Se ha registrado la toma del medicamento " + listaUsuario.get(tomar - 1).getNombreMedicamento() + " a la fecha y hora " + fecha);
    }
}
