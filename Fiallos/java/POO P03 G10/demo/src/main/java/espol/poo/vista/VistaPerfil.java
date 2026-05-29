//Direccion
package espol.poo.vista;
//librerias
import java.util.ArrayList;

import espol.poo.modelo.Perfil;
//print de lo que se necesite
public class VistaPerfil {
    public static void MenuPerfiles(ArrayList<Perfil> listaPerfiles , int num ){
        for (Perfil perfil : listaPerfiles) {
            if (perfil.getEmail() != null ){
                System.out.println(num + ". Usuario: " + perfil.getNombreUsuario() + " ,Relacion con el usuario: " + perfil.getRelacion() + " ,correo electronico: " + perfil.getEmail());
            }else{
                System.out.println(num + ". Usuario: " + perfil.getNombreUsuario() + " ,Relacion con el usuario: " + perfil.getRelacion());

            }
            num++;
        }
    }
}
