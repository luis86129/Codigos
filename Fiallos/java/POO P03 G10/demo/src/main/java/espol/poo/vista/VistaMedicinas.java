//Direccion
package espol.poo.vista;
//librerias
import java.util.ArrayList;

import espol.poo.modelo.Medicina;
//print de lo que se necesite
public abstract  class VistaMedicinas {
    public static void mostrarMedicinas(ArrayList<Medicina> medicinas){
        int num = 1;
        for(Medicina m : medicinas){
            System.out.println(num + ". Nombre del medicamento: " + m.getNombreMedicamento() + " Presentacion del medicamento: " + m.getPresentacionMedicamento() + " Frecuencia de consumo: " + m.getFrecuencia() + " a su vez " + m.getFrecuenciaDia() + " veces al dia, a las horas " + m.getFrecuenciaHora() + " Cantidad existente en Stock: " + m.getCantidadInventario());
            num ++;
        }

    }
}
