//Ubicacion
package espol.poo;
//Librerias
import java.util.ArrayList;
import java.util.Scanner;
//carpetas usadas
import espol.poo.controlador.ControladorActividadFisica;
import espol.poo.controlador.ControladorCitasMedicas;
import espol.poo.controlador.ControladorMedicinas;
import espol.poo.controlador.ControladorMedicos;
import espol.poo.controlador.ControladorPerfil;
import espol.poo.modelo.ActividadFisica;
import espol.poo.modelo.CitasMedicas;
import espol.poo.modelo.Medicina;
import espol.poo.modelo.Medicos;
import espol.poo.modelo.Perfil;
import espol.poo.vista.Vista;
//codigo principal
public class Main {
    public static void main(String[] args) {
        // scanner 
        Scanner grabar = new Scanner(System.in);
        // Listas
        ArrayList<Perfil> perfiles = new ArrayList<Perfil>();
        ArrayList<Medicina> medicinas = new ArrayList<Medicina>();
        ArrayList<Medicos> medicos = new ArrayList<Medicos>();
        ArrayList<CitasMedicas> citas = new ArrayList<CitasMedicas>();
        ArrayList<ActividadFisica> actividadFisicas = new ArrayList<ActividadFisica>();
        //Usuario
        Perfil Juan = new Perfil("Juan Perez", "Hermano","juan@gmail.com");
        Medicina Medicina_Juan = new Medicina("Ibuprofeno", 20, "Pastilla", "Cada 1 dia", 1, "12/10/2024", 2, Juan);
        Medicos Pedro = new Medicos("Pedro sanchez", "Pediatra",83294384,"pedro@gmail.com","23 y portete");
        CitasMedicas cita = new CitasMedicas("Chequeo rutinario", Pedro, "16:00", Juan);
        ActividadFisica actividad = new ActividadFisica("12/10/2024", "Nadar", 20, "Tarde", Juan);
        //agregar a las listas
        perfiles.add(Juan);
        medicinas.add(Medicina_Juan);
        medicos.add(Pedro);
        citas.add(cita);
        actividadFisicas.add(actividad);
        // Codigo principal
        //bucle
        while (true) {
            //opciones de perfill
            Vista.OpcionesIniciales();
            int eleccion1 = grabar.nextInt();
            grabar.nextLine();
            //if para separar cada decicion
            if (eleccion1 == 1){
                //crear perfiles
                ControladorPerfil.CrearPerfil(perfiles);
            //Elgir perfil y ejecutar el programar general
            }else if (eleccion1 == 2) {
                //Solicitar perfil
                System.out.println("Ingrese el perfil a ingresar");
                ControladorPerfil.MostrarPefiles(perfiles);
                int indiceUsuario = grabar.nextInt();
                Perfil UsuarioIngresado = perfiles.get(indiceUsuario - 1);
                //bucle
                while (true) { 
                    //solicitar decicion
                    Vista.Menu();
                    int eleccion2 = grabar.nextInt();
                    grabar.nextLine();
                    if (eleccion2 == 1){
                        //bucle
                        while (true) { 
                        //solicitar decicion
                        ControladorMedicinas.ElegirOpcionesMedicinas();
                        int eleccionMedicina = grabar.nextInt();
                        grabar.nextLine();
                            //eleccion en el sub menu y ejecutar funciones
                            if (eleccionMedicina == 1){
                                ControladorMedicinas.MostrarMedicinas(medicinas);
                            }else if (eleccionMedicina == 2) {
                                ControladorMedicinas.AgregarMedicina(medicinas, UsuarioIngresado);
                            }else if (eleccionMedicina == 3){
                                ControladorMedicinas.ELiminarMedicina(medicinas, perfiles, UsuarioIngresado);
                            }else if (eleccionMedicina == 4){
                                ControladorMedicinas.RegistrarToma(UsuarioIngresado, medicinas);
                            }else{
                                break;
                            }
                        }
                    }else if (eleccion2 == 2 ){
                        //bucle
                        while (true) {
                            //solicitar decicion
                            ControladorMedicos.MostrarMenuMedicos();
                            int eleccionMedicos = grabar.nextInt();
                            grabar.nextLine();
                            //eleccion en el sub menu y ejecutar funciones
                            if (eleccionMedicos == 1){
                                ControladorMedicos.MostrarMedicos(medicos);
                            }else if (eleccionMedicos == 2) {
                                ControladorMedicos.AgregarMedico(medicos);
                            }else{
                                break;
                            }
                        }
                    }else if (eleccion2 == 3){
                        //bucle
                        while (true) { 
                            //solicitar decicion
                            ControladorCitasMedicas.MostrarMenuCitasMedicas();
                            int eleccionCitasMedicas = grabar.nextInt();
                            grabar.nextLine();
                            //eleccion en el sub menu y ejecutar funciones
                            if (eleccionCitasMedicas == 1){
                                ControladorCitasMedicas.MostrarCitasMedicas(citas, UsuarioIngresado);
                            }else if (eleccionCitasMedicas == 2) {
                                ControladorCitasMedicas.AgregarCitaMedica(citas, medicos, UsuarioIngresado);
                            }else{
                                break;
                            }
                        }
                    }else if (eleccion2 == 4){
                        //bucle
                        while (true) { 
                            //solicitar decicion
                            ControladorActividadFisica.MostrarMenuActividadFisica();
                            int eleccionActividadFisica = grabar.nextInt();
                            grabar.nextLine();
                            //eleccion en el sub menu y ejecutar funciones
                            if (eleccionActividadFisica == 1){
                                ControladorActividadFisica.mostrarActividadFisica(actividadFisicas, UsuarioIngresado);
                            }else if (eleccionActividadFisica == 2) {
                                ControladorActividadFisica.AgregarActividadFisica(actividadFisicas, UsuarioIngresado);
                            }else{
                                break;
                            }
                        }
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }
    }    
}
