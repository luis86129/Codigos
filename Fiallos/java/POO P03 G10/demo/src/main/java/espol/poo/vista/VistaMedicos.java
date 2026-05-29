//Direccion
package espol.poo.vista;
//librerias
import java.util.ArrayList;

import espol.poo.modelo.Medicos;
//print de lo que se necesite
public abstract  class VistaMedicos {
    public static void ImprimirMedicos(ArrayList<Medicos> listaMedicos){
        int num = 1 ;
        for (Medicos doc : listaMedicos){
            System.out.println(num + ". El doctor " + doc.getNombre() + " con la especialidad: " + doc.getEspecialidad() + " numero de contracto: " + doc.getTelefono());
            num ++ ;
        }
    }
}
