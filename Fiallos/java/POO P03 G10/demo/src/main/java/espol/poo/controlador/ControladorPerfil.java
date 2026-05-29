//Direccion
package espol.poo.controlador;
//librerias
import java.util.ArrayList;
import java.util.Scanner;

import espol.poo.modelo.Perfil;
import espol.poo.vista.VistaPerfil;
//funciones
public abstract class ControladorPerfil {
    //funcion CrearPerfil
    public static void CrearPerfil(ArrayList<Perfil> perfiles ){
        Scanner grabar = new Scanner(System.in);
        System.out.println("Ingrese el nombre del usuario nuevo");
        String nombre = grabar.nextLine();
        System.out.println("Ingrese la relacion del usuario nuevo\npor ejemplo, hijo, cónyuge, padre");
        String relacion = grabar.next();
        System.out.println("Desea ingresar un correo electronico?\n1.Si\n2.No");
        int agregar = grabar.nextInt();

        if (agregar == 1){
            System.out.println("Ingrese el correo electronico");
            String email = grabar.next();
            Perfil perfil = new Perfil(nombre,relacion,email);
            perfiles.add(perfil);
        } else {
            Perfil perfil = new Perfil(nombre,relacion);
            perfiles.add(perfil);
                }
    }
    //funcion MostrarPefiles
    public static void MostrarPefiles(ArrayList<Perfil> listaPerfiles){
        int num = 1;
        VistaPerfil.MenuPerfiles(listaPerfiles, num);
    }
}
